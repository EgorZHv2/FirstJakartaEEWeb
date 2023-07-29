package servlets;

import java.io.*;
import java.util.UUID;

import core.application.interfaces.IUserService;
import core.application.services.UserService;
import jakarta.faces.annotation.RequestMap;
import jakarta.inject.Inject;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;
import jakarta.ws.rs.Path;

@WebServlet(name = "helloServlet", value = "/hello-servlet")
public class HelloServlet extends HttpServlet {
    @Inject
    private IUserService userService;
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        var users = userService.GetAll();
        request.setAttribute("users", users);
        getServletContext().getRequestDispatcher("/index.jsp").forward(request, response);
    }
    @Override
    public void doDelete(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

}