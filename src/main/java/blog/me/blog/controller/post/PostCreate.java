package blog.me.blog.controller.post;

import blog.me.blog.Message;
import blog.me.blog.service.PostServices;
import blog.me.blog.service.internal.PostServicesImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet( name = "post-create", value = "/post/new")
public class PostCreate extends HttpServlet {
    PostServices services;
    @Override
    public void init() throws ServletException {
        services = new PostServicesImpl();
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getRequestDispatcher("/views/posts/post_create.jsp").forward( request,response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("INFO: " + request.getRequestURI());
        request.setCharacterEncoding("utf-8");
        HttpSession session = request.getSession();
        int user_id = Integer.parseInt((String)session.getAttribute("login_id"));
        String title = request.getParameter("title");
        String content = request.getParameter("content");

        boolean result = services.create(user_id, title, content);
        String message, tag;
        if (result) {
            message = "Post has been created !!";
            tag = "success";
        } else {
            message = "Something went wrong, please try again";
            tag = "error";
        }
        // Send the flash message
        Message.send(request, message, tag);

        response.sendRedirect("/home");

    }
}
