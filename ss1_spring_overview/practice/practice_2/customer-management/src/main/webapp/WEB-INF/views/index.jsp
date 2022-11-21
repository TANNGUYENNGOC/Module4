<%--
  Created by IntelliJ IDEA.
  User: DELL
  Date: 11/18/2022
  Time: 11:54 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Calculator</title>
</head>
<body>
<%--<form action="/calculator" method="post">--%>
<%--    <input type="number" placeholder="input a" name="a">--%>
<%--    <select name="math">--%>
<%--        <option value="addition">+</option>--%>
<%--        <option value="subtraction">-</option>--%>
<%--        <option value="multiplication">*</option>--%>
<%--        <option value="division">/</option>--%>
<%--    </select>--%>
<%--    <input type="number" placeholder="input b" name="b">--%>
<%--    <button type="submit">Enter</button>--%>
<%--</form>--%>
<form action="/calculator" method="post">
    <table>
        <tr>
            <td><input type="number" placeholder="input a" name="a"></td>
            <td><input type="number" placeholder="input b" name="b"></td>
        </tr>
    </table>
    <table>
        <tr>
<%--            input button ko dc--%>
<%--            input submit dc--%>
            <td><button name="math"  value="addition">+</button></td>
            <td><button name="math"  value="subtraction">-</button></td>
            <td><button name="math"  value="multiplication">*</button></td>
            <td><button name="math"  value="division">/</button></td>
        </tr>
    </table>
</form>
<p>Result: ${result}</p>
</body>
</html>
