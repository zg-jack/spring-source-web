package com.zhuguang.jack.typeConverter;

import org.springframework.core.convert.converter.Converter;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class StringToDateConverter implements Converter<String, Date> {

    private String datePattern;

    public void setDatePattern(String datePattern)
    {
        this.datePattern = datePattern;
    }

    @Override
    public Date convert(String source) {
        SimpleDateFormat sf = new SimpleDateFormat(this.datePattern);
        try {
            Date d = sf.parse(source);
            return d;
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return null;
    }
}
