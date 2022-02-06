package blog.me.blog.controller.user;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "logout", value = "/logout")
public class Logout extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("User " + request.getSession().getAttribute("is_login") + " log out");
        request.getSession().removeAttribute("is_login");
        request.getSession().removeAttribute("login_id");
        request.getRequestDispatcher("/views/users/logout.jsp").forward(request, response);
    }
}
