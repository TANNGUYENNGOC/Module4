<%--
  Created by IntelliJ IDEA.
  User: DELL
  Date: 11/22/2022
  Time: 12:03 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<p>${languages}</p>
<p>${pageSize}</p>
<c:if test="${spamsFilter==true}"><p>Enable spams filter</p></c:if>
<p>${signature}</p>
</body>
</html>
