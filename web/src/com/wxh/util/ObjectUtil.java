/**
 * wxh Inc.
 * Copyright (c) 2016-2017 All Rights Reserved.
 */
package com.wxh.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * 对象工具类
 * @author wxh
 * @version $Id: ObjectUtil.java, v 0.1 2017年9月15日 下午3:44:47 wxh Exp $
 */
public class ObjectUtil {

    /**
     * 强制私有化，防止被实例化
     */
    private ObjectUtil() {

    }

    /**
     * 这是一个泛型方法
     * 将对象类型转换泛型(各种类型：List Map Object)
     * <T> 泛型方法，必须这样书写
     * @param object 需要转换的实参
     * @return 泛型:可以接受任何类型
     * 泛型指定的不同类型来控制形参具体限制的类型
     * 泛型类：类名称 <泛型标识：可以随便写任意标识号，标识指定的泛型的类型>,比如：List<String>/List<Integer>
     * 泛型通配符?,代表是类型实参，而不是形参 Class<?> clazz
     * 泛型类，是在实例化类的时候指明泛型的具体类型；泛型方法，是在调用方法的时候指明泛型的具体类型 
     * 泛型方法：<T> T methodName(Class<T> clazz){}
     * <T>:表示是泛型方法，T表示返回类型为泛型，methodName为方法名，clazz为方法参数
     */
    public static <T> T typeCastConversion(Object object) {
        return object == null ? null : (T) object;
    }

    /**
     * 将对象转换成对应的类型(String Integer etc.)
     * @param object 对象
     * @param entityClass 类类型(Long String etc.)
     * @return T  泛型类型
     * @throws ParseException 日期解析异常
     */
    public static <T> T objectToType(Object object, Class entityClass) throws ParseException {
        if (object == null) {
            return null;
        }
        /**
         * 适配不同类型,jdk1.7支持字符串类型
         * Object toString方法有弊端，Object有可能为Null
         * (String)Object,必须要判断Object instanceof String
         * String.valueOf(Object),无需关心上面的问题
         */
        String tempStr = String.valueOf(object);
        switch (entityClass.getName()) {
            case "java.lang.String":
                return typeCastConversion(tempStr);
            case "java.lang.Long":
                return typeCastConversion(Long.parseLong(tempStr));
            case "java.lang.Integer":
                return typeCastConversion(Integer.parseInt(tempStr));
            case "java.lang.Short":
                return typeCastConversion(Short.parseShort(tempStr));
            case "java.lang.Byte":
                return typeCastConversion(Byte.parseByte(tempStr));
            case "java.lang.Double":
                return typeCastConversion(Double.parseDouble(tempStr));
            case "java.lang.Float":
                return typeCastConversion(Float.parseFloat(tempStr));
            case "java.util.Date":
                SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
                return typeCastConversion(sdf.parse(tempStr));
            default:
                return null;
        }
    }

    /**
     * 将对象转成Long类型
     * @param object 对象
     * @param entityClass 类类型
     * @return Long 包装Long类型
     * @throws ParseException 日期解析异常
     */
    public static Long objectToLong(Object object, Class entityClass) throws ParseException {
        return objectToType(object, entityClass);
    }

    /**
     * 将对象转成Date类型
     * @param object 对象
     * @param entityClass 类类型
     * @return Long 包装Long类型
     * @throws ParseException 日期解析异常
     */
    public static Date objectToDate(Object object, Class entityClass) throws ParseException {
        return objectToType(object, entityClass);
    }
}
