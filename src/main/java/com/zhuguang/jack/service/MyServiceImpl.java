package com.zhuguang.jack.service;

import com.zhuguang.jack.bean.ConsultConfigArea;
import com.zhuguang.jack.bean.ConsultContent;
import com.zhuguang.jack.bean.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.Map;

@Service("myServiceImpl")
public class MyServiceImpl implements MyService {

    @Autowired
    JdbcTemplate jdbcTemplate;

    @Autowired
    @Qualifier("annotationServiceImpl")
    MyService myService;

    public String doSomething(String param) {
        System.out.println("===================targetClass doSomething=================");
        return "===================targetClass doSomething=================";
    }

    @Override
    public String throwTest(String param) {
        throw new RuntimeException("异常=================");
    }

    @Override
    public List<ConsultContent> queryContent(Map param) {
        return null;
    }

    @Override
    public int saveArea(ConsultConfigArea area) {
        return 0;
    }

    @Transactional(propagation = Propagation.REQUIRED,isolation = Isolation.READ_COMMITTED)
    @Override
    public void saveTest(String param) {
        try {
            String sql = "insert into test(num) values (?)";
            int count = jdbcTemplate.update(sql, new Object[]{param});
            myService.saveTest1(param);
        }catch (Exception e) {
            e.printStackTrace();
            //必须要往上抛
            throw e;
        }
    }

    @Override
    public void saveTest1(String param) {
    }

    @Override
    public void queryAllTest() {
        String testsql = "select * from test";
        System.out.println("=============test================");
        jdbcTemplate.query(testsql, new RowMapper<Map>() {
            @Override
            public Map mapRow(ResultSet rs, int rowNum) throws SQLException {
                System.out.println(rs.getString("num"));
                return null;
            }
        });
        String testsql1 = "select * from test1";
        System.out.println("=============test1================");
        jdbcTemplate.query(testsql1, new RowMapper<Map>() {
            @Override
            public Map mapRow(ResultSet rs, int rowNum) throws SQLException {
                System.out.println(rs.getString("num"));
                return null;
            }
        });
    }

    @Override
    public User queryUser(User user) {
        return null;
    }
}
