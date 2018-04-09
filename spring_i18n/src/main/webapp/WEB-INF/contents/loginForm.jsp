<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%--
  Created by IntelliJ IDEA.
  User: yafei.hou
  Date: 2017/11/22
  Time: 14:17
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>国际化</title>
</head>
<body>
<%--用户可以选择切换语言--%>
<a href="loginForm?request_locale=zh_CN">中文</a>
<a href="loginForm?request_locale=en_US">英文</a>
<br/>

<h3><spring:message code="title"/> </h3>

<form:form modelAttribute="user" method="post" action="login">
    <table>
        <tr>
            <td><spring:message code="loginname"/> </td>
            <td><form:input path="loginName"/></td>
        </tr>
        <tr>
            <td><spring:message code="password"/> </td>
            <td><form:input path="password" /> </td>
        </tr>
        <tr>
            <td><input type="submit" value="<spring:message code="submit"/>"></td>
        </tr>
    </table>
</form:form>
</body>
</html>
