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
密码 ：${requestScope.user.password} <br>


<form:form modelAttribute="user" method="post" action="">
    <table>
        <tr>
            <td><label>用户名：</label></td>
            <td>welcome <form:input path="userName"/>!!!!</td>
        </tr>
        <tr>
            <td><label>密码：</label></td>
            <td>welcome <form:input path="password"/>!!!!</td>
        </tr>
    </table>
</form:form>

</body>
</html>
