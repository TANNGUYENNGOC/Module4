<%--
  Created by IntelliJ IDEA.
  User: DELL
  Date: 11/21/2022
  Time: 11:31 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h1>Choose seasoning for your Sandwich</h1>
<form method="post" action="/spice">
    <input name="Lettuce" type="checkbox" value="Lettuce"/>Lettuce
    <input name="Tomato" type="checkbox" value="Tomato"/>Tomato
    <input name="Mastard" type="checkbox" value="Mastard"/>Mastard
    <input name="Sprouts" type="checkbox" value="Sprouts"/>Sprouts
    <br>
    <button type="submit">Save</button>
</form>
<h2>Danh sách gia vị: <c:if test="${list!=null}">
    <c:forEach var="spice" items="${list}">
        <p>${spice}</p>
    </c:forEach>
</c:if>
</h2>
</body>
</html>
