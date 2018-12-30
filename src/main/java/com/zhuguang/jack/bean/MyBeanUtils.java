package com.zhuguang.jack.bean;

import java.beans.PropertyDescriptor;
import java.lang.reflect.Method;
import java.util.Map;

public class MyBeanUtils {
    public static Object getPropertyValue(String propertyName, Object bean) {
        Object propertyValue = null;
        try {
            PropertyDescriptor pd = new PropertyDescriptor(propertyName, bean.getClass());
            Method method = pd.getReadMethod();
            propertyValue = method.invoke(bean);
        } catch (Exception e) {
            e.printStackTrace();
        }

        return propertyValue;
    }

    public static void setProperty(Object bean, String name, Object value) {
        try {
            PropertyDescriptor pd = new PropertyDescriptor(name, bean.getClass());
            Method method = pd.getWriteMethod();
            method.invoke(bean, value);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static Object populate(Object bean, Map<String, Object> map) {
        if (map != null && map.size() > 0) {
            for (Map.Entry<String, Object> entry : map.entrySet()) {
                String propertyName = entry.getKey();
                Object propertyValue = entry.getValue();
                try {
                    PropertyDescriptor pd = new PropertyDescriptor(propertyName, bean.getClass());
                    Method method = pd.getWriteMethod();
                    method.invoke(bean, propertyValue);
                } catch (Exception e) {
                    throw new RuntimeException(e);
                }
            }
        }
        return bean;
    }
}
