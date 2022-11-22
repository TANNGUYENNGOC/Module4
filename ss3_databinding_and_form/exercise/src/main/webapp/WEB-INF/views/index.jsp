<%--
  Created by IntelliJ IDEA.
  User: DELL
  Date: 11/21/2022
  Time: 11:48 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>

<html>
<head>
    <title>Title</title>
</head>
<body>
<form:form method="POST" action="settings" modelAttribute="settings">
    <table>
        <tr>
            <td><form:label path="languages">Languages</form:label></td>
            <td><form:select path="languages" items="${languageList}"></form:select></td>
        </tr>
        <tr>
            <td>
                <form:label path="pageSize">Page Size:</form:label>
            </td>
            <td>
                <span>Show
                    <form:select path="pageSize" items="${pageSizeList}"></form:select>
                    emails per page
                </span>
            </td>
        </tr>
        <tr>
            <td>
                <form:label path="spamsFilter">Spams filter:</form:label>
            </td>
            <td>
                <span>
                    <form:checkbox path="spamsFilter" value="spamsFilter"/>
                    Enable spams filter</span>
            </td>
        </tr>
        <tr>
            <td>
                <form:label path="signature">Signature:</form:label>
            </td>
            <td>
                <form:input path="signature"></form:input>
            </td>
        </tr>
        <tr>
            <td></td>
            <td><form:button>Update</form:button></td>
        </tr>
    </table>
</form:form>
</body>
</html>
