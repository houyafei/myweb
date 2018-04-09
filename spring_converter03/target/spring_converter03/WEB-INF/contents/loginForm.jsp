<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%--
  Created by IntelliJ IDEA.
  User: yafei.hou
  Date: 2017/11/27
  Time: 8:39
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h3>Login page</h3>

<form:form action="login" method="post" modelAttribute="user">
    <table>
        <tr>
            <td><label>用户名：</label></td>
            <td><form:input path="userName"/></td>
            <td><form:errors path="userName" cssStyle="color: crimson"/> </td>
        </tr>
        <tr>
            <td><label>密码</label></td>
            <td><form:input path="password"/></td>
            <td><form:errors path="password" cssStyle="color: red"/> </td>
        </tr>
        <tr>
            <td><input type="submit" value="Submit"></td>
        </tr>
    </table>
</form:form>


</body>
</html>
