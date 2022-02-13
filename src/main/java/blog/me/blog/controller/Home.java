package blog.me.blog.controller;

import blog.me.blog.models.Post;
import blog.me.blog.service.PostServices;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;

@WebServlet( name = "home", value = "/home")
public class Home extends HttpServlet {
    List<Post> posts;

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        posts = new PostServices().get_all();
        request.setAttribute("title", "Home");
        request.setAttribute("posts", posts);
        request.getRequestDispatcher("/views/home.jsp").forward(request, response);
    }

}
