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
<h3>测试表单格式化</h3>

<form action="testForm" method="post">
    <table>
        <tr>
            <td><label>用户名：</label></td>
            <td><input type="text" id="userName" name="userName"></td>
        </tr>
        <tr>
            <td><label>生日</label></td>
            <td><input type="text" id="birthday" name="birthday"></td>
        </tr>
        <tr>
            <td><label>信用度：</label></td>
            <td><input type="text" id="credit" name="credit"></td>
        </tr>
        <tr>
            <td><label>资产</label></td>
            <td><input type="text" id="capital" name="capital"></td>
        </tr>
        <tr>
            <td><label>消费</label></td>
            <td><input type="text" id="consumption" name="consumption"></td>
        </tr>
        <tr>
            <td><input type="submit" id="submit" value="登录"></td>
        </tr>
    </table>
</form>
</body>
</html>
