<%--
  Created by IntelliJ IDEA.
  User: yafei.hou
  Date: 2018/2/26
  Time: 20:27
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page isELIgnored="false" %>
<%@ taglib  uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
  <head>
    <title>ServletContext</title>
  </head>
  <body>
  <ul>
      <c:forEach items="${student}" var="st">
          <li>${st.key}:${st.value}</li>
      </c:forEach>
  </ul>
  </body>
</html>
