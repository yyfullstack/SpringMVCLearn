package com.ycsoft.web.controller.support.formatter;

import com.ycsoft.model.PhoneNumberModel;
import org.springframework.format.AnnotationFormatterFactory;
import org.springframework.format.Parser;
import org.springframework.format.Printer;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by yong on 2017/1/19 0019.
 */
//①指定可以解析/格式化的字段注解类型
public class PhoneNumberFormatAnnotationFormatterFactory implements AnnotationFormatterFactory<PhoneNumber> {

    private final Set<Class<?>> fieldTypes;
    private final PhoneNumberFormatter formatter;

    public PhoneNumberFormatAnnotationFormatterFactory() {
        Set<Class<?>> set = new HashSet<Class<?>>();
        set.add(PhoneNumberModel.class);
        this.fieldTypes = set;
        this.formatter = new PhoneNumberFormatter(); //此处使用之前定义的Formatter实现
    }

    //②指定可以被解析/格式化的字段类型集合
    public Set<Class<?>> getFieldTypes() {
        return fieldTypes;
    }

    //③根据注解信息和字段类型获取解析器
    public Printer<?> getPrinter(PhoneNumber annotation, Class<?> fieldType) {
        return formatter;
    }

    //④根据注解信息和字段类型获取格式化器
    public Parser<?> getParser(PhoneNumber annotation, Class<?> fieldType) {
        return formatter;
    }
}
