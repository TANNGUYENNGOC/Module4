<%--
  Created by IntelliJ IDEA.
  User: DELL
  Date: 11/18/2022
  Time: 2:27 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<form action="/convert-to-vnd" method="post">
    <input type="number" name="input" placeholder="Nhap USD">
    <button type="submit">to VND</button>
</form>
<p>Result: ${result}</p>
</body>
</html>
