<%--
  Created by IntelliJ IDEA.
  User: micha
  Date: 08.09.2023
  Time: 12:47
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>dodawanie</title>
</head>
<body>
<form action="/books/add" method="post">
    <p>isbn</p>
    <input type="text" name="isbn"><br>
    <p>title</p>
    <input name="title" type="text"><br>
    <p>publisher</p>
    <input type="text" name="publisher">
    <p>type</p>
    <input name="type" type="text"> <br>
    <p>author</p>
    <input type="text" name="author"> <br>

    <button type="submit">wyslij</button>
</form>
</body>
</html>
