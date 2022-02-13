package blog.me.blog.controller.post;

import blog.me.blog.Message;
import blog.me.blog.models.Post;
import blog.me.blog.service.PostServices;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet( name = "post_delete", value = "/post/delete/*")
public class PostDelete extends HttpServlet {

    PostServices services;
    @Override
    public void init() throws ServletException {
        services = new PostServices();
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            int post_id = get_post_id(request);
            Post post = services.get(post_id);
            if (post == null) {
                response.sendError(404, "The post is not exists ");
            } else {
                request.setAttribute("post", post);
                request.getRequestDispatcher("/views/posts/post_delete.jsp").forward(request, response);
            }
        } catch (NumberFormatException e) {
            response.setStatus(404);
            e.printStackTrace();
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            int post_id = get_post_id(request);
            boolean result = services.delete(post_id);
            if (result) {
                Message.send(request, "Post has been deleted!!", "success");
                response.sendRedirect("/home");
            } else {
                Message.send(request, "Something worng happened!!", "warning");
            }
        } catch (NumberFormatException e) {
            response.setStatus(404);
            e.printStackTrace();
        }
    }


    public int get_post_id(HttpServletRequest request) {
        String[] text = request.getRequestURI().split("/");
        int post_id = Integer.parseInt(text[text.length - 1]);

        return post_id;
    }
}
