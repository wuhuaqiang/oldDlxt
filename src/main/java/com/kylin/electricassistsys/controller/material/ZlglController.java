package com.kylin.electricassistsys.controller.material;

import com.kylin.electricassistsys.controller.BaseController;
import com.kylin.electricassistsys.entity.AutoBuilderParam;
import com.kylin.electricassistsys.entity.ProcessResult;
import com.kylin.electricassistsys.entity.enumparam.KeyValueType;
import com.kylin.electricassistsys.entity.material.ZlglEntity;
import com.kylin.electricassistsys.exception.AppException;
import com.kylin.electricassistsys.service.KeyValueService;
import com.kylin.electricassistsys.service.material.ZlglService;
import com.kylin.electricassistsys.utility.FileUtil;
import com.kylin.electricassistsys.utility.StringHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.UUID;

/**
 * Created by Threecolors on 2018/1/2.
 */
@Controller
@RequestMapping("/material/zlgl")
public class ZlglController extends BaseController<ZlglEntity, ZlglService>
{
    @Autowired
    KeyValueService keyValueService;

    @Autowired
    public void setService(ZlglService service)
    {
        setBaseService(service);
    }

    @Autowired
    public void setRestrictAuthority()
    {
        setRestrictAuthority(31);
    }

    @Autowired
    private void setAutoBuilderParam()
    {
        AutoBuilderParam autoBuilderParam =new AutoBuilderParam("综合资料管理", "/material/zlgl", "350px", "500px", 2);
        this.setAutoBuilderParam(autoBuilderParam);
    }

    protected String getEditUrl()
    {
        return "material/zlglEdit";
    }

    protected void buildEdit(HttpServletRequest request,Model model, ZlglEntity entity)
    {
        HashMap<String, String> zllxs = keyValueService.getKeyValueMap(KeyValueType.ZLLX);
        model.addAttribute("zllxs", zllxs);
        model.addAttribute("entity", entity);
    }

    @ResponseBody
    @RequestMapping(value = "/upload", method = RequestMethod.POST)
    public ProcessResult upload(HttpServletRequest request, @RequestParam("file") MultipartFile file, ZlglEntity entity) throws AppException
    {
        String id = StringHelper.isNullOrWhiteSpace(entity.getId()) ? UUID.randomUUID().toString() : entity.getId();

        ProcessResult processResult = new ProcessResult();

        String fileName = file.getOriginalFilename();
        String filePath = String.format("uploadFiles/%s/", id);
        filePath = request.getSession().getServletContext().getRealPath(filePath);
        try
        {
            UserDetails user = (UserDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
            FileUtil.uploadFile(file.getBytes(), filePath, fileName);
            SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            entity.setUploadTime(formatter.format(new Date()));
            entity.setFileName(fileName);
            entity.setUploadUser(user.getUsername());
            entity.setPath(filePath);
            entity.setUrl(String.format("/material/zlgl/download?id=%s", id));
        } catch (Exception e)
        {
        }

        if (StringHelper.isNullOrWhiteSpace(entity.getId()))
        {
            entity.setId(id);
            processResult.setSuccess(service.add(entity));
        } else
        {
            entity.setUpdateTime(new Date());
            processResult.setSuccess(service.update(entity));
        }


        return processResult;
    }

    @RequestMapping(value = "/download", method = RequestMethod.GET)
    public void download(HttpServletResponse res, @RequestParam(value = "id") String id)
    {
        ZlglEntity zlglEntity = this.service.getEntityById(id);
        if (zlglEntity == null)
        {
            return;
        }
        res.setHeader("content-type", "application/octet-stream");
        res.setContentType("application/octet-stream");
        try
        {
            res.setHeader("Content-Disposition", "attachment;filename=" + new String(zlglEntity.getFileName().getBytes("gbk"), "iso-8859-1"));
        } catch (Exception ex)
        {

        }
        byte[] buff = new byte[1024];
        BufferedInputStream bis = null;
        OutputStream os = null;
        try
        {
            os = res.getOutputStream();
            bis = new BufferedInputStream(new FileInputStream(new File(zlglEntity.getPath() + "/" + zlglEntity.getFileName())));
            int i = bis.read(buff);
            while (i != -1)
            {
                os.write(buff, 0, buff.length);
                os.flush();
                i = bis.read(buff);
            }
        } catch (IOException e)
        {
            e.printStackTrace();
        } finally
        {
            if (bis != null)
            {
                try
                {
                    bis.close();
                } catch (IOException e)
                {
                    e.printStackTrace();
                }
            }
        }
    }
}

