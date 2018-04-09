<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%--
  Created by IntelliJ IDEA.
  User: yafei.hou
  Date: 2017/11/27
  Time: 8:57
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page isELIgnored="false" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
用户名：${requestScope.user.userName}<br>
生日 ：${requestScope.user.birthday} <br>
信誉度：${requestScope.user.credit}<br>
资产 ：${requestScope.user.capital}<br>
消费 ：${requestScope.user.consumption}<br>


<form:form modelAttribute="user" method="post" action="">
    <table>
        <tr>
            <td><label>用户名：</label></td>
            <td><form:input path="userName"/></td>
        </tr>
        <tr>
            <td><label>生日</label></td>
            <td><form:input path="birthday"/></td>
        </tr>
        <tr>
            <td><label>信用度：</label></td>
            <td><form:input path="credit"/></td>
        </tr>
        <tr>
            <td><label>资产</label></td>
            <td><form:input path="capital"/></td>
        </tr>
        <tr>
            <td><label>消费</label></td>
            <td><form:input path="consumption"/></td>
        </tr>
    </table>
</form:form>

</body>
</html>
