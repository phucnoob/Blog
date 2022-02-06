package blog.me.blog.controller.post;

import blog.me.blog.models.Post;
import blog.me.blog.service.PostServices;
import blog.me.blog.service.internal.PostServicesImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "post_detail", value = "/post-detail")
public class PostDetail extends HttpServlet {
    PostServices services;
    @Override
    public void init() throws ServletException {
       services = new PostServicesImpl();
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            int post_id = Integer.parseInt(request.getParameter("id"));
            Post post = services.get(post_id);
            if (post == null) {
                response.sendError(404, "The post is not exsists ");
            } else {
                request.setAttribute("post", post);
                request.getRequestDispatcher("/views/posts/post_detail.jsp").forward(request, response);
            }
        } catch (NumberFormatException e) {
            e.printStackTrace();
            response.setStatus(404);
        }
    }
}
