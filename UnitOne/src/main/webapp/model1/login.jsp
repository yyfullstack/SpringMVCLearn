<%@page import="com.ycsoft.chapter1.javabean.UserBean" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>登录</title>
</head>
<body>

<%-- 创建javabean --%>
<jsp:useBean id="user" class="com.ycsoft.chapter1.javabean.UserBean"/>
<%--1、收集参数 封装参数（比直接使用jsp，在这块是简单的） --%>
<jsp:setProperty name="user" property="*"/>

<%
    String submitFlag = request.getParameter("submitFlag");
    if ("login".equals(submitFlag)) {//登录
        //3调用javabean对象（业务方法）
        if (user.login()) {
            //4根据返回值选择下一个页面
            out.write("login success");
        } else {
            out.write("login fail");
        }
    } else {
%>
<form action="" method="post">
    <input type="hidden" name="submitFlag" value="login"/>

    username:<input type="text" name="username"/><br/>
    password:<input type="password" name="password"/><br/>
    <input type="submit" value="login"/>
</form>

<% } %>

</body>
</html>