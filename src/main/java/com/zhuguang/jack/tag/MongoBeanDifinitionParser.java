package com.zhuguang.jack.tag;

import org.springframework.beans.factory.support.BeanDefinitionBuilder;
import org.springframework.beans.factory.xml.AbstractSingleBeanDefinitionParser;
import org.w3c.dom.Element;

import com.mongodb.MongoClient;

public class MongoBeanDifinitionParser extends
        AbstractSingleBeanDefinitionParser {
    
    protected String getParentName(Element element) {
        return super.getParentName(element);
    }
    
    protected Class<?> getBeanClass(Element element) {
        return MongoClient.class;
    }
    
    protected void doParse(Element element, BeanDefinitionBuilder builder) {
        String ip = element.getAttribute("ip");
        String port = element.getAttribute("port");
        
        builder.addConstructorArgValue(ip);
        builder.addConstructorArgValue(port);
    }
}
