package com.zhuguang.jack.typeConverter;

import com.zhuguang.jack.bean.ConsultConfigArea;
import com.zhuguang.jack.bean.ConsultRecord;

import java.util.Date;

public class TypeClass {
    public Date date;

    public ConsultRecord consultRecord;

    public ConsultConfigArea consultConfigArea;

    public ConsultConfigArea getConsultConfigArea() {
        return this.consultConfigArea;
    }

    public void setConsultConfigArea(ConsultConfigArea consultConfigArea) {
        this.consultConfigArea = consultConfigArea;
    }

    public ConsultRecord getConsultRecord() {
        return this.consultRecord;
    }

    public void setConsultRecord(ConsultRecord consultRecord) {
        this.consultRecord = consultRecord;
    }

    public Date getDate() {
        return this.date;
    }

    public void setDate(Date date) {
        this.date = date;
    }
}
