package com.zhuguang.jack.springconfig;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.beans.factory.config.PropertyPlaceholderConfigurer;

import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

public class LoadProperties extends PropertyPlaceholderConfigurer {
    
    private static Map<String, String> proMap = new HashMap<String, String>();
    
    @Override
    protected void processProperties(
            ConfigurableListableBeanFactory beanFactoryToProcess,
            Properties props) throws BeansException {
        super.processProperties(beanFactoryToProcess, props);
        
        if (props != null) {
            for (Object key : props.keySet()) {
                String keyStr = key.toString();
                String value = props.getProperty(keyStr);
                proMap.put(keyStr, value);
            }
        }
    }
    
    public static String getValue(String key) {
        return proMap.get(key);
    }
}
