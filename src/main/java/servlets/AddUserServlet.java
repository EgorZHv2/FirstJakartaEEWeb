package servlets;

import core.application.interfaces.IUserService;
import jakarta.inject.Inject;
import jakarta.servlet.*;
import jakarta.servlet.annotation.*;
import jakarta.servlet.http.*;
import core.domain.entities.User;

import java.io.IOException;

@WebServlet(name = "AddUserServlet", value = "/add-user")
public class AddUserServlet extends HttpServlet {
    @Inject
    IUserService userService;
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        var firstName = request.getParameter("firstname");
        var lastName = request.getParameter("lastname");
        var ageStr = request.getParameter("age");
        if (firstName.isBlank() || lastName.isBlank() || ageStr.isBlank()) {
             request.setAttribute("hasNullFields",true);
             doGet(request,response);
             return;
        }
        Integer age = Integer.valueOf(ageStr);
        userService.Create(new User(firstName, lastName, age));
        response.sendRedirect("/web/hello-servlet");
    }
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getRequestDispatcher("/pages/AddUserPage.jsp").forward(request,response);
    }

}