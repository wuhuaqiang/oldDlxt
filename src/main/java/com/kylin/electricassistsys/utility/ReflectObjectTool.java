package com.kylin.electricassistsys.utility;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;

/**
 * Created by Threecolors on 2018/1/14.
 */
public class ReflectObjectTool
{
    /**
     * 根据属性名获取属性值
     *
     * @param fieldName
     * @param object
     * @return
     */
    public static String getFieldValueByFieldName(String fieldName, Object object)
    {
        Class<?> clazz = object.getClass();
        for (; clazz != Object.class; clazz = clazz.getSuperclass())
        {
            try {
                Field field = clazz.getDeclaredField(fieldName);
                String fldtype = field.getType().getSimpleName();
                String getMetName = pareGetName(field.getName());
                Method method = clazz.getMethod(getMetName, clazz);
                Object obj = method.invoke(object, new Object[]{});
                if(null != obj){
                    if(fldtype.equals("Date")){
                        return fmlDate((Date)object);
                    }
                    return  String.valueOf(object);
                }
            } catch (Exception e) {
            }
        }

        return  null;
    }


    /**
     * 取出bean 属性和值
     * @param obj
     * @return
     * @throws Exception
     */
    public static Map<Object,Object> getFileValue(Object obj) throws Exception{
        Map<Object, Object> map = new HashMap<Object, Object>();
        Class<?> cls = obj.getClass();
        Method methods[] = cls.getDeclaredMethods();
        Field fields[] = cls.getDeclaredFields();

        for(Field field:fields){
            String fldtype = field.getType().getSimpleName();
            String getMetName = pareGetName(field.getName());
            String result ="";
            if(!checkMethod(methods,getMetName)){
                continue;
            }
            Method method = cls.getMethod(getMetName, cls);
            Object object = method.invoke(obj, new Object[]{});
            if(null != object){
                if(fldtype.equals("Date")){
                    result = fmlDate((Date)object);
                }
                result = String.valueOf(object);
            }
            map.put(field.getName(), result);
        }

        return map;
    }

    /**
     * 设置bean 属性值
     * @param map
     * @param bean
     * @throws Exception
     */
    public static void setFieldValue(Map<String, Object> map, Object bean) throws NoSuchMethodException, InvocationTargetException, IllegalAccessException
    {
        Class<?> cls = bean.getClass();
        Method methods[] = cls.getDeclaredMethods();
        Field fields[] = cls.getDeclaredFields();

        for(Field field:fields){
            String fldtype = field.getType().getSimpleName();
            String fldSetName = field.getName();
            String setMethod = pareSetName(fldSetName);
            if(!checkMethod(methods, setMethod)){
                continue;
            }
            Object value = map.get(fldSetName);
            Method method = cls.getMethod(setMethod, field.getType());
            if(null != value){
                if("String".equals(fldtype)){
                    method.invoke(bean, value.toString());
                }else if("Double".equals(fldtype)){
                    method.invoke(bean, (Double)value);
                }else if("float".equals(fldtype)){
                    method.invoke(bean, Float.parseFloat(value.toString()));
                }else if("int".equals(fldtype)){
                    int val = Integer.valueOf((String)value);
                    method.invoke(bean, val);
                }
            }
        }
    }

    /**
     * 拼接某属性get 方法
     * @param fldname
     * @return
     */
    public static String pareGetName(String fldname){
        if(null == fldname || "".equals(fldname)){
            return null;
        }
        String pro = "get"+fldname.substring(0,1).toUpperCase()+fldname.substring(1);
        return pro;
    }

    /**
     * 拼接某属性set 方法
     * @param fldname
     * @return
     */
    public static String pareSetName(String fldname){
        if(null == fldname || "".equals(fldname)){
            return null;
        }
        String pro = "set"+fldname.substring(0,1).toUpperCase()+fldname.substring(1);
        return pro;
    }

    /**
     * 判断该方法是否存在
     * @param methods
     * @param met
     * @return
     */
    public static boolean checkMethod(Method methods[],String met){
        if(null != methods ){
            for(Method method:methods){
                if(met.equals(method.getName())){
                    return true;
                }
            }
        }
        return false;
    }

    /**
     * 把date 类转换成string
     * @param date
     * @return
     */
    public static String fmlDate(Date date){
        if(null != date){
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss", Locale.US);
            return sdf.format(date);
        }
        return null;
    }
}
