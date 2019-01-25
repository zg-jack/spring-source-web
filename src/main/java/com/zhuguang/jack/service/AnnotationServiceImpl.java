package com.zhuguang.jack.service;

import com.zhuguang.jack.annotation.TargetMethod;
import com.zhuguang.jack.bean.ConsultConfigArea;
import com.zhuguang.jack.bean.ConsultContent;
import com.zhuguang.jack.dao.CommonMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.DependsOn;
import org.springframework.context.annotation.Description;
import org.springframework.context.annotation.Lazy;
import org.springframework.context.annotation.Scope;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Map;

@Service("annotationServiceImpl")
@Scope(ConfigurableBeanFactory.SCOPE_PROTOTYPE)
@Lazy(false)
@Description("xx")
public class AnnotationServiceImpl implements MyService {

    @Autowired
    CommonMapper commonMapper;

    @Autowired
    JdbcTemplate jdbcTemplate;

    @TargetMethod(name = "Jack")
    @Override
    public String doSomething(String param) {
        System.out.println("==========AnnotationServiceImpl.doSomething");
        return "==========AnnotationServiceImpl.doSomething";
    }

    @Override
    public String throwTest(String param) {
        return null;
    }

    @Override
    public List<ConsultContent> queryContent(Map param) {
        return commonMapper.queryContent(param);
    }


    @Override
    public int saveArea(ConsultConfigArea area) {
        int count = commonMapper.saveArea(area);

        if(false)throw new RuntimeException("异常");
        return count;
    }

    @Override
    public void saveTest(String param) {
    }

    @Transactional(propagation = Propagation.REQUIRES_NEW,isolation = Isolation.READ_COMMITTED)
    @Override
    public void saveTest1(String param) {
        String sql = "insert into test1(num) values (?)";
        int count = jdbcTemplate.update(sql, new Object[]{param});
//        throw new RuntimeException("saveTest1 异常");
    }

    @Override
    public void queryAllTest() {

    }
}
