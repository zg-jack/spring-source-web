package com.zhuguang.jack.typeConverter;

import com.zhuguang.jack.bean.ConsultRecord;
import org.springframework.core.convert.converter.Converter;

public class StringToObjectConverter implements Converter<String,ConsultRecord> {
    @Override
    public ConsultRecord convert(String source) {
        System.out.println("==============StringToObjectConverter");
        ConsultRecord record = new ConsultRecord();
        record.setName(source);
        return record;
    }
}
