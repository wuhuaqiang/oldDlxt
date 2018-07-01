package com.kylin.electricassistsys.service;

import com.kylin.electricassistsys.commonmapper.BaseMapper;
import com.kylin.electricassistsys.entity.BaseEntity;
import com.kylin.electricassistsys.entity.LigerGridModel;
import com.kylin.electricassistsys.exception.AppException;
import com.kylin.electricassistsys.exception.TemplateException;
import com.kylin.electricassistsys.utility.*;
import org.apache.calcite.linq4j.Linq4j;
import org.apache.commons.lang3.StringUtils;
import tk.mybatis.mapper.entity.Example;

import java.lang.reflect.Field;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.*;

/**
 * Created by Threecolors on 2017/11/18.
 */
public abstract class BaseService<T extends BaseEntity>
{
    private BaseMapper<T> mapper;

    public void setBaseMapper(BaseMapper<T> mapper)
    {
        this.mapper = mapper;
    }

    /**
     * 添加
     *
     * @param entity 实体
     * @return 影响条数
     */
    public boolean add(T entity)
    {
        return mapper.insert(entity) > 0;
    }


    /**添加，null字段使用数据库默认值
     * @param entity
     * @return
     */
    public boolean insertSelective(T entity)
    {
        return mapper.insertSelective(entity) > 0;
    }


    /**
     * 更新
     *
     * @param entity 实体
     * @return 影响条数
     */
    public boolean update(T entity)
    {
        return mapper.updateByPrimaryKey(entity) > 0;
    }

    public  boolean updateByPrimaryKeySelective(T entity)
    {
        return mapper.updateByPrimaryKeySelective(entity) > 0;
    }

    /**
     * 根据id获取实体
     *
     * @param id
     * @return 实体
     */
    public T getEntityById(String id)
    {
        return mapper.selectByPrimaryKey(id);
    }

    public int deleteByIds(String[] ids)
    {
        Example example = new Example(getMyClass());
        Example.Criteria criteria = example.createCriteria();
        criteria.andIn("id", java.util.Arrays.asList(ids));
        return mapper.deleteByExample(example);
    }


    /**
     * 根据设置的键值获取数据
     *
     * @param keyColumnName  字段名称
     * @param keyColumnValue 字段值
     * @return 数据集合
     */
    public List<T> getEntityByKeyColumn(String keyColumnName, Object keyColumnValue)
    {
        Example example = new Example(getMyClass());
        Example.Criteria criteria = example.createCriteria();
        criteria.andEqualTo(keyColumnName, keyColumnValue.toString());
        return mapper.selectByExample(example);
    }

    public int updateEntityByKeyColumn(String keyColumnName, Object keyColumnValue, T entity)
    {
        Example example = new Example(getMyClass());
        Example.Criteria criteria = example.createCriteria();
        criteria.andEqualTo(keyColumnName, keyColumnValue);
        return mapper.updateByExample(entity,example);
    }

    /**
     * 根据名称获取
     *
     * @return 所有实体集合
     */
    public List<T> getEntitiesByCondition(T conditionEntity)
    {
        List<T> entities = mapper.getEntitiesByCondition(conditionEntity);

        String operStr = OperateButtonScript.EIDIT_BUTTON + OperateButtonScript.DELETE_BUTTON;
        for (T entity : entities)
        {
            entity.setOperate(String.format(operStr, entity.getId(), entity.getId(), entity.getId()));
        }

        return entities;
    }

    public List<T> getEntitiesByConditionForJGrid(T conditionEntity, int buttonAuthority)
    {
        List<T> entities = this.getEntitiesByCondition(conditionEntity);

        String operStr =StringUtils.EMPTY;
        if((AuthorityType.DELETE.getIndex()&buttonAuthority)>0)
        {
            operStr+=OperateButtonScript.DELETE_BUTTON;
        }
        if((AuthorityType.MODIFY.getIndex()&buttonAuthority)>0)
        {
            operStr+=OperateButtonScript.EIDIT_BUTTON;
        }

        if (!StringUtils.isEmpty(operStr))
        {
            for (T entity : entities)
            {
                entity.setOperate(String.format(operStr, entity.getId(), entity.getId(), entity.getId()));
            }
        }

        return entities;
    }

    public LigerGridModel<T> gettLigerGridModel(List<Map<String, Object>> mapList) throws Exception
    {
        LigerGridModel<T> ligerGridModel = new LigerGridModel<T>();
        mapList = getNameValue(mapList);
        for (Map<String, Object> map : mapList)
        {
            T entity = convertMapToEntity(map);
            ligerGridModel.getRows().add(entity);
        }

        return ligerGridModel;
    }


    /**将description-value 转化为name-value
     * @param mapList
     * @return
     * @throws TemplateException
     */
    protected  List<Map<String,Object>> getNameValue(List<Map<String, Object>> mapList) throws TemplateException
    {
        List<Map<String,Object>> nameValueMapList = new LinkedList<>();
        List<CustomField> customFields = this.getImportField(null);
        boolean isCheckTemplate = false;
        for (Map<String, Object> map : mapList)
        {
            if(!isCheckTemplate)
            {
                isCheckTemplate = this.checkTemplate(map,customFields);
            }
            Map<String,Object> nameValueMap = new HashMap<>();
            for (CustomField customField : customFields)
            {
                if (map.containsKey(customField.getMeta().description()))
                {
                    nameValueMap.put(customField.getName(), map.get(customField.getMeta().description()));
                }
            }
            nameValueMapList.add(nameValueMap);
        }

        return  nameValueMapList;
    }

    private boolean checkTemplate(Map<String, Object> map, List<CustomField> customFields) throws TemplateException
    {
        Set<String> kset=map.keySet();
        for(String ks:kset)
        {
            if(!Linq4j.asEnumerable(customFields).any(a->a.getMeta().description().equals(ks)))
            {
                throw new TemplateException();
            }
        }

        return true;
    }

    protected T convertMapToEntity(Map<String, Object> nameValueMap) throws Exception
    {
        T entity = this.getTInstance();
        ReflectObjectTool.setFieldValue(nameValueMap, entity);
        return entity;
    }

    /**
     * 特殊处理，转化字段展示和数据库存储不一致的情况
     *
     * @param entity
     */
    protected void specialProcessForField(T entity,String type)
    {
    }

    /**
     * 数据导入处理
     *
     * @param intert    插入
     * @param updata    更新
     * @param keyColumn 主键
     * @param mapList
     * @return
     * @throws Exception
     */
    public boolean importData(boolean intert, boolean updata, String keyColumn, List<Map<String, Object>> mapList,String type) throws Exception
    {
        mapList = getNameValue(mapList);
        for (Map<String, Object> map : mapList)
        {
            T entity = convertMapToEntity(map);
            specialProcessForField(entity,type);
            if(StringHelper.isNullOrEmpty(keyColumn))
            {
                entity.setId(UUID.randomUUID().toString());
                entity.setUpdateTime(new Date());
                this.add(entity);
            }
            else
            {
                List<T> entityList = getEntityByKeyColumn(keyColumn, map.get(keyColumn));
                if (entityList.size() > 0)
                {
                    if (updata)
                    {
                        entity.setUpdateTime(new Date());
                        updateEntityByKeyColumn(keyColumn, map.get(keyColumn), entity);
                    }
                } else if (intert)
                {
                    entity.setId(UUID.randomUUID().toString());
                    entity.setUpdateTime(new Date());
                    this.add(entity);
                }
            }
        }

        return true;
    }


    /**
     * 获取可导出字段
     *
     * @param entity 实体
     * @return 可导出字段
     */
    public List<CustomField> getExportField(T entity)
    {
        List<CustomField> customFields = this.getCustomFields(entity);
        customFields = Linq4j.asEnumerable(customFields).where(a -> a.getMeta().isExport()).orderBy(a -> a.getRank()).toList();
        return customFields;
    }

    /**
     * 获取可导入字段
     *
     * @param entity 实体
     * @return 可导入字段
     */
    public List<CustomField> getImportField(T entity)
    {
        List<CustomField> customFields = this.getCustomFields(entity);
        customFields = Linq4j.asEnumerable(customFields).where(a -> a.getMeta().isImport()).orderBy(a -> a.getRank()).toList();
        return customFields;
    }

    public List<CustomField> getPreviewField(T entity)
    {
        List<CustomField> customFields = this.getCustomFields(entity);
        customFields = Linq4j.asEnumerable(customFields).where(a -> a.getMeta().isImport()).orderBy(a -> a.getRank()).toList();
        return customFields;
    }


    /**
     * 获取泛型T的类型
     *
     * @return
     */
    public Class getMyClass()
    {
        Type type = getClass().getGenericSuperclass();
        if (type instanceof ParameterizedType)
        {
            Type[] ptype = ((ParameterizedType) type).getActualTypeArguments();
            return (Class) ptype[0];
        } else
        {
            return Object.class;
        }
    }

    /**
     * 获取类型T的实例
     *
     * @return
     * @throws IllegalAccessException
     * @throws InstantiationException
     */
    public T getTInstance() throws IllegalAccessException, InstantiationException
    {
        return (T) this.getMyClass().newInstance();
    }

    @SuppressWarnings("unchecked")
    public List<CustomField> getCustomFields(T entity)
    {
        List<CustomField> customFields = new ArrayList<>();
        Class<T> entityClass = this.getMyClass();
        if (entityClass != null)
        {
            Field[] fields = entityClass.getDeclaredFields();
            for (Field f : fields)
            {
                CustomField sf = buildCustomField(f, entity);
                if (sf != null)
                    customFields.add(sf);
            }

            fields = entityClass.getSuperclass().getDeclaredFields();
            for (Field f : fields)
            {
                CustomField sf = buildCustomField(f, entity);
                if (sf != null)
                    customFields.add(sf);
            }

            Collections.sort(customFields, new Comparator<CustomField>()
            {
                @Override
                public int compare(CustomField s1, CustomField s2)
                {
                    return s1.getRank() - s2.getRank();
                }

            });
        }
        return customFields;
    }

    private CustomField buildCustomField(Field f, T entity)
    {
        FieldMeta meta = f.getAnnotation(FieldMeta.class);
        if (meta != null)
        {
            CustomField sf = new CustomField(meta, f);
            if (entity != null)
            {
                sf.setFieldValue("");
                f.setAccessible(true); //设置些属性是可以访问的
                Object val;//得到此属性的值
                try
                {
                    val = f.get(entity);
                    if (val != null)
                    {
                        sf.setFieldValue(val.toString());
                    }
                } catch (Exception e)
                {
                    e.printStackTrace();
                }
            }
            return sf;
        } else
        {
            return null;
        }
    }
}
