<%@ page import="core.application.interfaces.IUserService" %>
<%@ page import="jakarta.inject.Inject" %>
<%@ page import="core.application.services.UserService" %>
<%@ page import="java.util.UUID" %>
<%@ page import="core.application.interfaces.IUserRepository" %>
<%@ page import="persistance.repositories.UserRepository" %><%--
  Created by IntelliJ IDEA.
  User: Егор
  Date: 29.07.2023
  Time: 14:22
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%

    IUserRepository userRepository = new UserRepository();
    Object userId = request.getParameter("userid");
    if (userId != null) {
        userRepository.delete(UUID.fromString((String)userId));
    }
    response.sendRedirect("/web");
%>
