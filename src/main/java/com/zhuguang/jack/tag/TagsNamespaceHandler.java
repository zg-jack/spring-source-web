package com.zhuguang.jack.tag;

import org.springframework.beans.factory.config.BeanDefinitionHolder;
import org.springframework.beans.factory.xml.NamespaceHandlerSupport;
import org.springframework.beans.factory.xml.ParserContext;
import org.w3c.dom.Node;

public class TagsNamespaceHandler extends NamespaceHandlerSupport {
    
    public void init() {
        this.registerBeanDefinitionParser("mongo",
                new MongoBeanDifinitionParser());
        this.registerBeanDefinitionParser("redis",
                new RedisBeanDifinitionParser());
    }

    @Override
    public BeanDefinitionHolder decorate(Node node, BeanDefinitionHolder definition, ParserContext parserContext) {
        return super.decorate(node, definition, parserContext);
    }
}
