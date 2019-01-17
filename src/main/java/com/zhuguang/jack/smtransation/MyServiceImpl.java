package com.zhuguang.jack.smtransation;

import com.zhuguang.jack.bean.ConsultConfigArea;
import com.zhuguang.jack.dao.CommonMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.TransactionDefinition;
import org.springframework.transaction.TransactionStatus;

public class MyServiceImpl implements MyService {

    private TransactionDefinition txDefinition;

    private PlatformTransactionManager txManager;

    @Autowired
    CommonMapper commonMapper;

    @Override
    public int saveArea(ConsultConfigArea area) {
        TransactionStatus transaction = txManager.getTransaction(txDefinition);
        try {
            transaction.createSavepoint();
            commonMapper.saveArea(area);
            txManager.commit(transaction);
        } catch (Exception e) {
            txManager.rollback(transaction);
        }
        return 0;
    }
}
