<%--
  Created by IntelliJ IDEA.
  User: LENOVO
  Date: 25/08/2025
  Time: 19:40
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Form Example</title>
</head>
<body>
<h1>HTML Form Example with File Upload</h1>
<form action="${pageContext.request.contextPath}/formServlet" method="post" enctype="multipart/form-data">
    Name: <input type="text" name="fullname"> <br> <br>
    Password: <input type="password" name="password"> <br> <br>
    Gender: <input type="radio" name="gender" value="male"> Male
    <input type="radio" name="gender" value="female"> Female <br> <br>
    Hobbies: <input type="checkbox" name="hobby" value="reading"> Reading
    <input type="checkbox" name="hobby" value="sports"> Sports
    <input type="checkbox" name="hobby" value="Music"> Music <br> <br>
    Country: <select name="country">
        <option value="Việt Nam">Vietnam</option>
    </select> <br> <br>
    Birth Date: <input type="date" name="birthdate"> <br> <br>
    Profile Picture: <input type="file" name="picture"> <br> <br>
    <input type="submit" value="Đăng ký">


</form>
</body>
</html>
