<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>JSP - Hello World</title>
</head>
<body>
<form action="${pageContext.request.contextPath}/uploadmulti" method="post" enctype="multipart/form-data">
    File #1: <input type="file" name="file"/> <br/><br/>
    File #2: <input type="file" name="file"/> <br/><br/>
    File #3: <input type="file" name="file"/> <br/><br/>
    File #4: <input type="file" name="file"/> <br/><br/>
    File #5: <input type="file" name="file"/> <br/><br/>
    <input type="submit" value="Upload"/>
    <input type="reset" value="Reset"/>
</form>
</body>
</html>