<%@ page contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%
    String path = request.getContextPath();
%>
<html>
<head>
    <title>springMVC注解说明</title>
</head>
<body>
<h1>springMVC注解说明</h1>

<br><br>
<a href="api/testServletApi?username=tz&age=18">testServletApi</a>

<br><br>
<form action="api/testPOJO" method="post">
    username :<input type="text" name="username"/>
    <br>
    password :<input type="password" name="password"/>
    <br>
    email :<input type="text" name="email"/>
    <br>
    age :<input type="text" name="age"/>
    <br>
    province :<input type="text" name="address.province"/>
    <br>
    city :<input type="text" name="address.city"/>
    <br>
    <input type="submit" name="提交"/>
    <br>
</form>

<br><br>
<a href="api/testCookieValue">testCookieValue</a>

<br><br>
<a href="api/testRequestHeader">testRequestHeader</a>

<br><br>
<a href="api/testRequestParam?username=tz">testRequestParam</a>

<br><br>
<a href="api/testPathVariable/admin">testPathVariable</a>

<br><br>
<a href="api/testHeader">testHeader</a>

<br><br>
<a href="api/testParams?username=tz&age=21">testParams</a>

<br><br>
<form action="api/testMethod" method="post">
    <input type="submit" value="提交"/>
</form>

<br><br>
<a href="api/testAntPath/sgdsfgdfg/abc">testAntPath</a>

<br><br>
<a href="<%=path %>/api/testRequestMapping">testRequestMappingWithPath</a>

<br><br>
<a href="api/testRequestMapping">testRequestMapping</a>

</body>
</html>