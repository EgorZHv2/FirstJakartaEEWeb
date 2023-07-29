<%--
  Created by IntelliJ IDEA.
  User: Егор
  Date: 27.07.2023
  Time: 14:36
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    Object attribute = request.getAttribute("hasNullFields");
    boolean hasNullFields = attribute == null ? false : (Boolean) attribute;
%>
<html>
<head>
    <title>Добавление пользователя</title>
    <meta charset="UTF-8">
    <link rel="stylesheet" href="wwwroot/lib/bootstrap-5.0.2-dist/css/bootstrap.min.css">
    <link rel="stylesheet" href="wwwroot/css/style.css">
    <script src="wwwroot/lib/bootstrap-5.0.2-dist/js/bootstrap.bundle.min.js"></script>
</head>
<body>
<header class="w-100">
    <h2 class="text-center">Добавление юзера</h2>
</header>
<div class="container w-75">
    <form method="post" action="/web/add-user">

        <div>
            <div class="form-floating mb-3">
                <input class="form-control" name="firstname" id="firstname" placeholder="Имя" type="text">
                <label for="firstname">Имя</label>
            </div>
            <div class="form-floating mb-3">
                <input class="form-control" name="lastname" id="lastname" placeholder="Фамилия" type="text">
                <label for="lastname">Фамилия</label>
            </div>
            <div class="form-floating mb-3">
                <input class="form-control" name="age" id="age" placeholder="Возраст" type="text">
                <label for="age">Возраст</label>
            </div>
            <%
                if(hasNullFields){
            %>
            <div>
                <h3 style="text-align: center; color: darkred">Заполните все поля!</h3>
            </div>
            <%
                }
            %>

            <div class="d-flex">
                <input class="w-25 mx-auto" type="submit" value="Создать">
            </div>
        </div>
    </form>
</div>
</body>
</html>
