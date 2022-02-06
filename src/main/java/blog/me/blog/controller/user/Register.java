package blog.me.blog.controller.user;

import blog.me.blog.models.User;
import blog.me.blog.service.UserServices;
import blog.me.blog.service.internal.UserServicesImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet( name = "register", value = "/register" )
public class Register extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        request.setAttribute("title", "Register");

        request.getRequestDispatcher("/views/users/register.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String username = request.getParameter("username");
        String email = request.getParameter("email");
        String password = request.getParameter("password");

        UserServices userServices = new UserServicesImpl();
        User user = new User(username, email, password);

        boolean result = userServices.create(user);
        String message, tag;
        if (result) {
            message = "Account for " + username + " is created. You can now login";
            tag = "success";
        } else {
            message = "User created failed";
            tag = "error";
        }

        HttpSession session = request.getSession();
        session.setAttribute("message", message);
        session.setAttribute("tag", tag);
        response.sendRedirect("/login");
    }
}
