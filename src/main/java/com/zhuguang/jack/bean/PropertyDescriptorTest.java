package com.zhuguang.jack.bean;

import java.beans.*;
import java.lang.reflect.Method;
import java.lang.reflect.TypeVariable;

public class PropertyDescriptorTest {
    public static void main(String[] args) {
        try {
            BeanInfo beanInfo = Introspector.getBeanInfo(ConsultContent.class);
            PropertyDescriptor[] propertyDescriptors = beanInfo.getPropertyDescriptors();
            BeanDescriptor beanDescriptor = beanInfo.getBeanDescriptor();
            Class<?> beanClass = beanDescriptor.getBeanClass();
            Object obj = beanClass.newInstance();

            for (PropertyDescriptor propertyDescriptor : propertyDescriptors) {
                Method writeMethod = propertyDescriptor.getWriteMethod();
                System.out.println("writerMethod : " + writeMethod.getName());
                TypeVariable<Method>[] typeParameters = writeMethod.getTypeParameters();
                for (TypeVariable genericParameterType : typeParameters) {
                    System.out.println(genericParameterType.getName());
                }

                Method readMethod = propertyDescriptor.getReadMethod();
                String readmethodName = readMethod.getName();
                System.out.println("readMethod : " + readmethodName);

            }
        } catch (IntrospectionException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        }
    }
}
