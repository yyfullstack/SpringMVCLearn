package com.ycsoft.controller.support.editor;


import com.ycsoft.model.PhoneNumberModel;
import org.springframework.util.StringUtils;

import java.beans.PropertyEditorSupport;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by yong on 2017/1/10 0010.
 */
public class PhoneNumberEditor extends PropertyEditorSupport {
    Pattern pattern = Pattern.compile("^(\\d{3,4})-(\\d{7,8})$");

    @Override
    public void setAsText(String text) throws IllegalArgumentException {

        if (text == null || !StringUtils.hasLength(text)) {
            //如果没值，设值为null
            setValue(null);
        }
        Matcher matcher = pattern.matcher(text);
        if (matcher.matches()) {
            PhoneNumberModel phoneNumber = new PhoneNumberModel();
            phoneNumber.setAreaCode(matcher.group(1));
            phoneNumber.setPhoneNumber(matcher.group(2));
            setValue(phoneNumber);
        } else {
            throw new IllegalArgumentException(String.format("类型转换失败，需要格式[010-12345678]，但格式是[%s]", text));
        }
    }

    @Override
    public String getAsText() {
        PhoneNumberModel phoneNumber = (PhoneNumberModel) getValue();
        return phoneNumber == null ? "" : phoneNumber.getAreaCode() + "-" + phoneNumber.getPhoneNumber();
    }
}
