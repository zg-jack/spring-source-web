package com.zhuguang.jack.typeConverter;

import org.springframework.beans.PropertyEditorRegistrar;
import org.springframework.beans.PropertyEditorRegistry;

public class MyPropertyEditorRegistrar1 implements PropertyEditorRegistrar{
    Class<?> clazz;
    @Override
    public void registerCustomEditors(PropertyEditorRegistry registry) {
        registry.registerCustomEditor(clazz,new PropertyEditorTest());
    }
}
