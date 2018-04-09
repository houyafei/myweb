<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
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
登录名：${requestScope.user.loginName}
生日 ：<fmt:formatDate value="${requestScope.user.birthday}" pattern="yyyy年MM月dd日"/><br>
</body>
</html>
