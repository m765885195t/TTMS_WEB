<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>ADDUSER</title>
</head>
<body>
<form action="/administrator" method="post">
    username:<input type="text" name="username"><br/>
    Password:<input type="password" name="pass"><br/>
    identity:<input type="text" name="identity"><br/>

    <%--隐藏域--%>
    <input type="hidden" name="method" value="addUser"><br/>

    <input type="submit" value="添加">
</form>
</body>
</html>
