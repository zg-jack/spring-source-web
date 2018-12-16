package com.zhuguang.jack.tag;

import org.springframework.beans.factory.support.BeanDefinitionBuilder;
import org.springframework.beans.factory.xml.AbstractSingleBeanDefinitionParser;
import org.w3c.dom.Element;

import redis.clients.jedis.Jedis;

public class RedisBeanDifinitionParser extends
        AbstractSingleBeanDefinitionParser {
    
    protected Class<?> getBeanClass(Element element) {
        return Jedis.class;
    }
    
    protected void doParse(Element element, BeanDefinitionBuilder builder) {
        String ip = element.getAttribute("ip");
        String port = element.getAttribute("port");
        
        builder.addConstructorArgValue(ip);
        builder.addConstructorArgValue(Integer.parseInt(port));
    }
    
}
