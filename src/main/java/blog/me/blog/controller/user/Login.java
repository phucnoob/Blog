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

@WebServlet(name = "login", value = "/login")
public class Login extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setAttribute("title", "Login");
        request.getRequestDispatcher("/views/users/login.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String username = request.getParameter("username");
        String password = request.getParameter("password");

        UserServices userServices = new UserServicesImpl();

        int result = userServices.authenticate(username, password);
        String message, tag, is_login, login_id;
        if (result > 0) {
            message = "Account " + username + " has login successfully !!";
            tag = "success";
            is_login = username;
            login_id = String.valueOf(result);
        } else {
            message = "Username or password is incorrect.";
            tag = "error";
            is_login = null;
            login_id = null;
        }

        HttpSession session = request.getSession();
        session.setAttribute("message", message);
        session.setAttribute("tag", tag);
        session.setAttribute("is_login", is_login);
        session.setAttribute("login_id", login_id);

        String next = request.getParameter("next");
        if ( next != null && !next.isBlank()) {
            response.sendRedirect(next);
        } else {
            response.sendRedirect("/home");
        }

    }
}
