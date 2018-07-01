package com.kylin.electricassistsys.controller;

import cn.afterturn.easypoi.excel.ExcelExportUtil;
import cn.afterturn.easypoi.excel.ExcelImportUtil;
import cn.afterturn.easypoi.excel.entity.ExportParams;
import cn.afterturn.easypoi.excel.entity.ImportParams;
import cn.afterturn.easypoi.excel.entity.enmus.ExcelType;
import cn.afterturn.easypoi.excel.entity.params.ExcelExportEntity;
import com.alibaba.fastjson.JSON;
import com.kylin.electricassistsys.entity.*;
import com.kylin.electricassistsys.entity.log.AuditEventGrade;
import com.kylin.electricassistsys.entity.log.AuditEventName;
import com.kylin.electricassistsys.entity.log.AuditEventType;
import com.kylin.electricassistsys.entity.log.SysAuditLog;
import com.kylin.electricassistsys.handler.CustomExcelDataHandler;
import com.kylin.electricassistsys.service.BaseService;
import com.kylin.electricassistsys.service.log.SysAuditLogService;
import com.kylin.electricassistsys.service.system.RoleAuthorityService;
import com.kylin.electricassistsys.utility.*;
import org.apache.commons.lang3.StringUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.poi.ss.usermodel.Workbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.util.*;

/**
 * Created by Threecolors on 2017/12/13.
 */
public class BaseController<T extends BaseEntity, S extends BaseService<T>> extends AuthorityController
{
    protected final Log logger = LogFactory.getLog(this.getClass());

    @Autowired
    protected QueryFormHelper queryFormHelper;

    @Autowired
    protected SysAuditLogService sysAuditLogService;

    @Autowired
    protected EditFormHelper editFormHelper;

    @Autowired
    protected RoleAuthorityService roleAuthorityService;

    protected AutoBuilderParam autoBuilderParam;

    protected void setAutoBuilderParam(AutoBuilderParam autoBuilderParam)
    {
        this.autoBuilderParam = autoBuilderParam;
    }

    public BaseController()
    {
    }

    protected S service;

    protected void setBaseService(S baseService)
    {
        this.service = baseService;
    }

    protected String getListUrl()
    {
        return "commonJqGrid";
    }

    protected String getEditUrl()
    {
        return "commonEdit";
    }

    protected String getImportSettingUrl()
    {
        return "commonImportSetting";
    }

    protected AuditEventType auditEventType = AuditEventType.BUSINESS_EVENT;

    protected void setAuditEventType(AuditEventType auditEventType)
    {
        this.auditEventType = auditEventType;
    }

    /**
     * 构建查询
     *
     * @param model
     * @param customFields
     */
    protected void buildQueryForm(Model model,
                                  List<CustomField> customFields)
    {
        int buttonAuthority = this.getAuthority();
        String queryForm = queryFormHelper.bulidQueryForm(customFields, buttonAuthority);
        model.addAttribute("queryForm", queryForm);
    }

    /**
     * 构建JGrid
     *
     * @param model
     * @param customFields
     */
    protected void buildJGrid(Model model,
                              List<CustomField> customFields) throws InstantiationException, IllegalAccessException
    {
        int buttonAuthority = this.getAuthority();
        List<T> entities = service.getEntitiesByConditionForJGrid(service.getTInstance(), buttonAuthority);
        String jGridString = JQGridHelper.bulidJqGirdScript(autoBuilderParam.getTitle(), entities, customFields,
                                                            "id", buttonAuthority);
        model.addAttribute("jGrid", jGridString);
    }


    /**
     * 构建编辑
     *
     * @param model
     * @param entity
     */
    protected void buildEdit(HttpServletRequest request,
                             Model model,
                             T entity,
                             String type)
    {
        List<CustomField> customFields = service.getCustomFields(entity);
        String tableContent = editFormHelper.buildEditTable(customFields, autoBuilderParam.getColNum());
        model.addAttribute("tableContent", tableContent);
        model.addAttribute("entity", entity);
        model.addAttribute("autoBuilderParam", autoBuilderParam);
    }

    /**
     * 构建列表构建Model
     *
     * @param model
     * @throws IllegalAccessException
     * @throws InstantiationException
     */
    protected void buildListModel(Model model,
                                  String type) throws IllegalAccessException, InstantiationException
    {
        List<CustomField> customFields = service.getCustomFields(null);
        buildQueryForm(model, customFields);
        buildJGrid(model, customFields);
        model.addAttribute("autoBuilderParam", autoBuilderParam);
    }

    @RequestMapping(value = "/list", method = RequestMethod.GET)
    public String list(HttpServletRequest request,
                       @PathVariable(name = "type", required = false) String type,
                       Model model) throws IllegalAccessException, InstantiationException
    {
        buildListModel(model, type);
        return getListUrl();
    }

    @RequestMapping(value = "/add", method = RequestMethod.GET)
    public String add(HttpServletRequest request,
                      @PathVariable(name = "type", required = false) String type,
                      Model model) throws InstantiationException, IllegalAccessException
    {
        T entity = service.getTInstance();
        this.buildEdit(request, model, entity, type);
        return getEditUrl();
    }

    @ResponseBody
    @RequestMapping(value = "/saveAdd", method = RequestMethod.POST)
    public ProcessResult saveAdd(HttpServletRequest request,
                                 @Validated T entity) throws Exception
    {
        String msg = "添加失败";
        AuditEventGrade auditEventGrade = AuditEventGrade.INFO;

        ProcessResult processResult = new ProcessResult();
        try
        {
            entity.setId(UUID.randomUUID().toString());
            processResult.setSuccess(service.insertSelective(entity));
            return processResult;
        }
        catch (Exception ex)
        {
            auditEventGrade = AuditEventGrade.ERROR;
            msg = "系统异常：" + ex.getMessage();
            throw ex;
        }
        finally
        {
            this.writeSysAuditLog(AuditEventName.ADD, processResult.isSuccess() ? "添加成功" : msg,auditEventGrade);
        }
    }


    @RequestMapping(value = "/modify", method = RequestMethod.GET)
    public String modify(HttpServletRequest request,
                         @RequestParam(value = "id") String id,
                         @PathVariable(name = "type", required = false) String type,
                         Model model) throws InstantiationException, IllegalAccessException
    {
        T entity = service.getEntityById(id);
        this.buildEdit(request, model, entity, type);
        return getEditUrl();
    }

    @ResponseBody
    @RequestMapping(value = "/saveModify", method = RequestMethod.POST)
    public ProcessResult saveModify(HttpServletRequest request,@RequestParam(value = "id") String id,
                                    @Validated T entity) throws Exception
    {
        String msg = "修改失败";
        AuditEventGrade auditEventGrade = AuditEventGrade.INFO;
        ProcessResult processResult = new ProcessResult();

        try
        {
            processResult.setSuccess(service.updateByPrimaryKeySelective(entity));
            return processResult;
        }
        catch (Exception ex)
        {
            auditEventGrade = AuditEventGrade.ERROR;
            msg = "系统异常：" + ex.getMessage();
            throw ex;
        }
        finally
        {
            this.writeSysAuditLog(AuditEventName.MODIFY, processResult.isSuccess() ? "修改成功" : msg,auditEventGrade);
        }
    }

    @ResponseBody
    @RequestMapping(value = "/delete", method = RequestMethod.POST)
    public ProcessResult delete(HttpServletRequest request,
                                String ids)
    {
        String msg = "删除失败";
        AuditEventGrade auditEventGrade = AuditEventGrade.INFO;
        ProcessResult processResult = new ProcessResult();
        try
        {
            int count = service.deleteByIds(ids.split(","));
            processResult.setCount(count);
            processResult.setSuccess(count>0);
            return processResult;
        }
        catch (Exception ex)
        {
            auditEventGrade = AuditEventGrade.ERROR;
            msg = "系统异常：" + ex.getMessage();
            throw ex;
        }
        finally
        {
            this.writeSysAuditLog(AuditEventName.DELETE, processResult.getCount() > 0 ? "删除成功" : msg,auditEventGrade);
        }
    }

    @ResponseBody
    @RequestMapping(value = "/query")
    public List<T> query(HttpServletRequest request,
                         T entity)
    {
        String msg = StringUtils.EMPTY;
        AuditEventGrade auditEventGrade = AuditEventGrade.INFO;
        try
        {
            //查询接口，需要获取页面按钮权限
            String url = this.getUrlWithQueryString();
            int buttonAuthority = roleAuthorityService.getPreviousMenuButtonAuthorityByUrl(url,
                                                                                           this.getUserInfo().getUsername());
            List<T> entities = service.getEntitiesByConditionForJGrid(entity, buttonAuthority&this.getAuthority());
            msg = "查询成功";
            return entities;
        }
        catch (Exception ex)
        {
            auditEventGrade = AuditEventGrade.ERROR;
            msg = "系统异常：" + ex.getMessage();
            throw ex;
        }
        finally
        {
           // this.writeSysAuditLog(AuditEventName.QUERY, msg,auditEventGrade);
        }
    }

    @RequestMapping(value = "/importSetting", method = RequestMethod.GET)
    public String importSetting(Model model,
                                @PathVariable(name = "type", required = false) String type)
    {
        //设置预览表头
        List<CustomField> customFields = service.getPreviewField(null);
        List<LigerGridColumn> ligerGridColumnList = new ArrayList<>();
        HashMap<String, String> keyColumns = new LinkedHashMap<>();
        for (CustomField customField : customFields)
        {
            ligerGridColumnList.add(new LigerGridColumn(customField.getMeta().description(), customField.getName()));
            keyColumns.put(customField.getName(), customField.getMeta().description());
        }
        LigerGridModel<T> ligerGridModel = new LigerGridModel<T>();
        model.addAttribute("columns", JSON.toJSONString(ligerGridColumnList));
        model.addAttribute("customersData", JSON.toJSONString(ligerGridModel));
        model.addAttribute("keyColumns", keyColumns);
        model.addAttribute("autoBuilderParam", autoBuilderParam);
        model.addAttribute("type", type);
        return this.getImportSettingUrl();
    }

    @ResponseBody
    @RequestMapping(value = "/importData", method = RequestMethod.POST)
    public ProcessResult importData(HttpServletRequest request,
                                    @RequestParam("keyColumn") String keyColumn,
                                    @RequestParam(value = "insert", required = false, defaultValue = "") String insert,
                                    @RequestParam(value = "update", required = false, defaultValue = "") String update,
                                    @PathVariable(value = "type", required = false) String type,
                                    @RequestParam("fuChoose") MultipartFile fuChoose) throws Exception
    {
        String msg = "导入失败";
        AuditEventGrade auditEventGrade = AuditEventGrade.INFO;
        ProcessResult processResult = new ProcessResult();
        try
        {
            if (StringHelper.isNullOrEmpty(insert.trim()) && StringHelper.isNullOrEmpty(update.trim()))
            {
                processResult.setSuccess(false);
                processResult.setMessage("请设置导入方式！");
                return processResult;
            }

            ImportParams params = new ImportParams();
            CustomExcelDataHandler customExcelDataHandler = new CustomExcelDataHandler();
            params.setDataHanlder(customExcelDataHandler);
            List<Map<String, Object>> mapList = ExcelImportUtil.importExcel(fuChoose.getInputStream(), Map.class,
                                                                            params);

            boolean success = service.importData(insert.equals("on"), update.equals("on"), keyColumn, mapList, type);
            processResult.setSuccess(success);
            return processResult;
        }
        catch (Exception ex)
        {
            auditEventGrade = AuditEventGrade.ERROR;
            msg = "系统异常：" + ex.getMessage();
            throw ex;
        }
        finally
        {
            this.writeSysAuditLog(AuditEventName.IMPORT, processResult.isSuccess() ? "导入成功" : msg,auditEventGrade);
        }
    }

    @ResponseBody
    @RequestMapping(value = "/preview", method = RequestMethod.POST)
    public LigerGridModel<T> preview(HttpServletRequest request,
                                     @RequestParam("fuChoose") MultipartFile fuChoose) throws Exception
    {
        LigerGridModel<T> ligerGridModel = new LigerGridModel<T>();
        ImportParams params = new ImportParams();
        CustomExcelDataHandler customExcelDataHandler = new CustomExcelDataHandler();
        params.setDataHanlder(customExcelDataHandler);
        List<Map<String, Object>> mapList = ExcelImportUtil.importExcel(fuChoose.getInputStream(), Map.class, params);
        return service.gettLigerGridModel(mapList);
    }

    @RequestMapping(value = "/downloadTemplate", method = RequestMethod.GET)
    public void downloadTemplate(HttpServletRequest request,
                                 HttpServletResponse res)
            throws UnsupportedEncodingException, InstantiationException, IllegalAccessException
    {
        //获取表头信息
        List<ExcelExportEntity> excelExportEntities = new ArrayList<>();
        List<CustomField> customFields = service.getImportField(null);
        for (CustomField customField : customFields)
        {
            excelExportEntities.add(new ExcelExportEntity(customField.getColName(), customField.getName()));
        }
        //构建表格数据
        List<Map<String, Object>> list = new ArrayList<>();

        String fileName = String.format("%s数据模板.xlsx", this.autoBuilderParam.getTitle());
        workBookWriteToOutputStream(res, excelExportEntities, list, fileName);
    }

    @RequestMapping(value = "/exportExcel", method = RequestMethod.GET)
    public void exportExcel(HttpServletRequest request,
                            HttpServletResponse res,
                            T queryEntity) throws UnsupportedEncodingException
    {
        String msg = "导出失败";
        AuditEventGrade auditEventGrade = AuditEventGrade.INFO;
        try
        {
            //获取表头信息
            List<ExcelExportEntity> excelExportEntities = new ArrayList<>();
            List<CustomField> customFields = service.getExportField(null);
            for (CustomField customField : customFields)
            {
                excelExportEntities.add(new ExcelExportEntity(customField.getColName(), customField.getName()));
            }

            //构建表格数据
            int buttonAuthority = this.getAuthority();
            List<T> entities = service.getEntitiesByConditionForJGrid(queryEntity, buttonAuthority);
            List<CustomField> fields;
            List<Map<String, Object>> list = new ArrayList<>();
            Map<String, Object> map;
            for (T entity : entities)
            {
                map = new LinkedHashMap<>();
                fields = service.getExportField(entity);
                for (CustomField field : fields)
                {
                    map.put(field.getName(), field.getFieldValue());
                }

                list.add(map);
            }

            String fileName = String.format("%s.xlsx", this.autoBuilderParam.getTitle());
            workBookWriteToOutputStream(res, excelExportEntities, list, fileName);
            msg = "导出成功";
        }
        catch (Exception ex)
        {
            auditEventGrade = AuditEventGrade.ERROR;
            msg = "系统异常：" + ex.getMessage();
            throw ex;
        }
        finally
        {
            this.writeSysAuditLog(AuditEventName.EXPORT, msg,auditEventGrade);
        }
    }


    protected void workBookWriteToOutputStream(HttpServletResponse res,
                                               List<ExcelExportEntity> excelExportEntities,
                                               List<Map<String, Object>> list,
                                               String fileName) throws UnsupportedEncodingException
    {
        ExportParams exportParams = new ExportParams();
        exportParams.setType(ExcelType.XSSF);
        Workbook workbook = ExcelExportUtil.exportExcel(exportParams, excelExportEntities, list);
        res.setHeader("content-type", "application/octet-stream");
        res.setContentType("application/octet-stream");
        res.setHeader("Content-Disposition",
                      "attachment;filename=" + new String(fileName.getBytes("gbk"), "iso-8859-1"));

        try
        {
            OutputStream outputStream = res.getOutputStream();
            workbook.write(outputStream);
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }
    }

    protected void writeSysAuditLog(AuditEventName eventName,
                                    String msg, AuditEventGrade auditEventGrade)
    {
        try
        {
            SysAuditLog sysAuditLog = new SysAuditLog();
            sysAuditLog.setAccount(this.getUserInfo().getUsername());
            sysAuditLog.setModuleName(this.autoBuilderParam.getTitle());
            sysAuditLog.setCurrentTime(new Date());
            sysAuditLog.setUserIp(this.getUserIp());
            sysAuditLog.setAuditEventName(eventName.getName());
            sysAuditLog.setMessage(msg);
            sysAuditLog.setType(this.auditEventType.getName());
            sysAuditLog.setAuditEventGrade(auditEventGrade.getName());
            sysAuditLog.setId(UUID.randomUUID().toString());
            sysAuditLogService.add(sysAuditLog);
        }
        catch (Exception ex)
        {
            logger.error(ex);
        }
    }
}
