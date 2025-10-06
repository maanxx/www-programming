<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<%@ page import="com.fe.nguyenphanminhman_tuan5.model.Department" %>
<%@ page import="java.util.List" %>
<%--
  Created by IntelliJ IDEA.
  User: LENOVO
  Date: 23/09/2025
  Time: 19:46
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Employee Information</title>
</head>
<body>
<div class="container">
    <img src="${pageContext.request.contextPath}/images/HRbanner.jpg" height="200px"
         width="100%">

    <form action="${pageContext.request.contextPath}/employees" method="post">
        <input type="hidden" name="id" value="employee.id"/>
        Name: <input type="text" name="name"/><br/>
        Salary: <input type="text" name="salary"/><br/>
        Department:
        <select name="department">
            <c:forEach var="dep" items="${departments}">
                <option value="${dep.dept_id}">${dep.deptName}</option>
            </c:forEach>
        </select>

        <br/>
        <input type="submit" value="Save"/>
    </form>
</div>
</body>
</html>
