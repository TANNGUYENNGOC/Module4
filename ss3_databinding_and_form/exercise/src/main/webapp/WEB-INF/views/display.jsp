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
<p>Languages: ${languages}</p>
<p>Page Size: ${pageSize}</p>
<span>Spams filter:</span><c:if test="${spamsFilter==true}"><span>Enable spams filter</span></c:if>
<p>Signature: ${signature}</p>
</body>
</html>
