<%@ page contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<html>
<head>
    <title>模型视图详解</title>
</head>
<body>
<h1>模型视图详解</h1>

<a href="testRedirectURL">testRedirectURL</a>
<br><br>

<a href="testRedirect">testRedirect</a>
<br><br>

<br>
<form action="admin/testModelAttribute" method="post">
    <input type="text" name="id" value="1"/>
    <br>
    username : <input type="text" name="username" value="AndyLou"/>
    <br>
    email : <input type="text" name="email" value="AndyLou@tz.com"/>
    <br>
    age : <input type="text" name="age" value="56"/>
    <br>
    <input type="submit" value="提交"/>
</form>

<hr>
<br><br>
<a href="admin/testSessionAttributes">testSessionAttributes</a>

<br><br>
<a href="admin/testModel">testModel</a>

<br><br>
<a href="admin/testMap">testMap</a>

<br><br>
<a href="admin/testModelAndView">testModelAndView</a>

</body>
</html>