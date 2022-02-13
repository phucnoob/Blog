package blog.me.blog.controller.post;

import blog.me.blog.Message;
import blog.me.blog.models.Post;
import blog.me.blog.models.User;
import blog.me.blog.service.PostServices;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet(name = "post_update", value = "/post/update/*")
public class PostUpdate extends HttpServlet {
    PostServices services ;
    @Override
    public void init() throws ServletException {
        services = new PostServices();
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try{
            String[] text = request.getRequestURI().split("/");
            // Hardcode is bad!!
            int post_id = Integer.parseInt(text[text.length - 1]);
            HttpSession session = request.getSession();
            Post post = services.get(post_id);
            int user_id = Integer.parseInt((String) session.getAttribute("login_id"));
            if (post == null) {
                response.sendError(404, "Post is not exists");
            } else if (post.getAuthor().getUser_id() != user_id) {
                response.sendError(403, "You dont have pers to update this");
            }
            else {
                post.setPost_id(post_id);
                request.setAttribute("post", post);
                request.getRequestDispatcher("/views/posts/post_update.jsp").forward(request, response);
            }
        } catch (NumberFormatException e) {
//            e.printStackTrace();
            response.sendError(404, "Post is not exists");
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String title = request.getParameter("title");
        String content = request.getParameter("content");
        int post_id = Integer.parseInt(request.getParameter("id"));

        boolean result = services.update(post_id, title, content);
        String message, tag;
        if (result) {
            message = "Post have been updated";
            tag = "success";
        } else {
            message = "Something happen!!!";
            tag = "error";
        }

        Message.send(request, message, tag);

        response.sendRedirect("/home");
    }
}
