<%@ page import="core.domain.entities.User" %>
<%@ page import="java.util.Objects" %>
<%@ page import="java.util.List" %>
<%@ page import="java.util.Iterator" %>
<%@ page import="java.util.Collection" %><%@ page import="java.util.*" %>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%
    ArrayList<User> users = new ArrayList<>();
    users = (ArrayList<User>) request.getAttribute("users");
%>
<%!
   String wrapToTd(Object value)
   {
       return "<td>" + value.toString() + "</td>";

   }
%>
<!DOCTYPE html>
<html>
<head>
    <title>JSP - Hello World</title>
    <link rel="stylesheet" href="wwwroot/lib/bootstrap-5.0.2-dist/css/bootstrap.min.css">
    <link rel="stylesheet" href="wwwroot/css/style.css">
    <script src="wwwroot/lib/bootstrap-5.0.2-dist/js/bootstrap.bundle.min.js"></script>
</head>
<body>
<header class="w-100">
    <h2 class="text-center">Страница с юзерами</h2>
</header>
<section class="w-100" id="usersTable">
    <div class="container w-75 mx-auto">
        <table class="table table-bordered">
            <thead>
            <tr>
                <th scope="col">#</th>
                <th scope="col">Имя</th>
                <th scope="col">Фамилия</th>
                <th scope="col">Возраст</th>
                <th scope="col">Удалить</th>
            </tr>
            </thead>
            <tbody>
            <%

                if(users != null && !users.isEmpty()) {
                    int i = 1;
                    for (User u : users) {
                        out.print("<tr>" + wrapToTd(i)
                                + wrapToTd(u.getFirstName())
                                + wrapToTd(u.getLastName())
                                + wrapToTd(u.getAge())
                                +wrapToTd("<a href=\"/web/pages/DeleteUserPage.jsp?userid="+u.getId()+"\">Удалить</a>" )
                                + "</tr>");
                    }
                }
            %>
            </tbody>
        </table>
    </div>
    <div class="w-100">
        <div class="mx-auto" style="text-align: center">
            <a class="redirectHrefButton" href="/web/add-user">Добавить юзера</a>
        </div>
    </div>

</section>
</body>
