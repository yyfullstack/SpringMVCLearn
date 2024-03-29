package com.ycsoft.annotation;

import java.lang.reflect.Method;

/**
 * Created by yong on 2016/12/28 0028.
 */
public class TestTool {
    public static void main(String[] args) {
        //①得到ForumService对应的Class对象
        Class clazz = ForumService.class;
        //②得到ForumSerivce对应的Method数组
        Method[] methods = clazz.getDeclaredMethods();
        System.out.println("方法数量：" + methods.length);

        for (Method method : methods) {
            //③获取方法上所标注的注解对象
            NeedTest nt = method.getAnnotation(NeedTest.class);
            if (nt != null) {
                if (nt.value()) {
                    System.out.println(method.getName() + "()需要测试");
                } else {
                    System.out.println(method.getName() + "()不需要测试");
                }
            }
        }
    }
}
