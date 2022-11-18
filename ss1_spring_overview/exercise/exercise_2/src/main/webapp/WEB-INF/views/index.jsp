<%--
  Created by IntelliJ IDEA.
  User: DELL
  Date: 11/18/2022
  Time: 3:32 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<form action="/dictionary" method="post">
    <input type="text" name="inputSearch" placeholder="Input text">
    <button type="submit">Enter</button>
</form>
<p>Result: ${result}</p>
</body>
</html>
