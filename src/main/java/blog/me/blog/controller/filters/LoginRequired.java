package blog.me.blog.controller.filters;

import blog.me.blog.Message;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebFilter(urlPatterns = {"/profile", "/post/*"})
public class LoginRequired extends HttpFilter {
    @Override
    protected void doFilter(HttpServletRequest request, HttpServletResponse response, FilterChain chain) throws IOException, ServletException {
        boolean is_login = request.getSession().getAttribute("is_login") != null;
        boolean is_login_request = request.getRequestURI().equals("/login");

        if(is_login && is_login_request) {
            request.getRequestDispatcher("/home").forward(request, response);
        } else if (is_login_request || is_login) {
            chain.doFilter(request, response);
        } else {
            request.setAttribute("next", request.getRequestURI());
            String message, tag;
            message = "Please login to continue";
            tag = "info";
            Message.send(request, message, tag);

            request.getRequestDispatcher("/login")
                    .forward(request, response);
        }
    }
}
