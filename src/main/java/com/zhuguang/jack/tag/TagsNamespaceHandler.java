package com.zhuguang.jack.tag;

import org.springframework.beans.factory.xml.NamespaceHandlerSupport;

public class TagsNamespaceHandler extends NamespaceHandlerSupport {
    
    public void init() {
        this.registerBeanDefinitionParser("mongo",
                new MongoBeanDifinitionParser());
        this.registerBeanDefinitionParser("redis",
                new RedisBeanDifinitionParser());
    }
}
