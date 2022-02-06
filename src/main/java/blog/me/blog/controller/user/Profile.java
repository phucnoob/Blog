package blog.me.blog.controller.user;

import blog.me.blog.models.User;
import blog.me.blog.service.internal.UserServicesImpl;
import com.mysql.cj.x.protobuf.MysqlxDatatypes;
import org.imgscalr.Scalr;

import javax.imageio.ImageIO;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.UUID;

@WebServlet(name = "profile", value = "/profile")
@MultipartConfig
public class Profile extends HttpServlet {


    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setAttribute("title", "Profile");
        UserServicesImpl userServices = new UserServicesImpl();
        HttpSession session = request.getSession();

        User user = userServices.get(Integer.parseInt((String) session.getAttribute("login_id")));
        request.setAttribute("user", user);

        request.getRequestDispatcher("/views/users/profile.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // get update info from the form
        String username = request.getParameter("username");
        String email = request.getParameter("email");
        int user_id = Integer.parseInt(request.getParameter("user_id"));

        System.out.println(user_id + username + email);
//         create a temp user
        User newUser = new UserServicesImpl().get(user_id);
        newUser.setUsername(username);
        newUser.setEmail(email);

        // get the avatar image
        Part filePart = request.getPart("image");
        String fileName = Paths.get(filePart.getSubmittedFileName()).getFileName().toString(); // MSIE fix.
        String fileName_ = UUID.randomUUID().toString();
        InputStream fileContent = filePart.getInputStream();

        // user update avatar
        if ( !(fileName.isEmpty() || fileName.isBlank()) ) {
            Path dest = Paths.get("/home/laplace/Downloads/uploads/profile_pics", fileName_);

            // if the image is larger than 125px, resize it
            BufferedImage image = ImageIO.read(fileContent);
            BufferedImage resized = Scalr.resize(image, 250);

            ImageIO.write(resized, "jpg", dest.toFile());
            // if upload success, update the avatar, if the avatar is not default, delete it
            if (!newUser.getAvatar().equals(User.DEFAULT)) {
                Files.delete(Paths.get(newUser.getAvatar()));
            }
            newUser.setAvatar("/home/laplace/Downloads/uploads/profile_pics" + "/" + fileName_);
        }

        // make changes to database
        boolean result = new UserServicesImpl().update(user_id, newUser);

        String message, tag;
        if (result) {
            message = "Profile " + username + " has been updated successfully !!";
            tag = "info";

        } else {
            message = "Something wrong happen.";
            tag = "error";
        }

        HttpSession session = request.getSession();
        session.setAttribute("message", message);
        session.setAttribute("tag", tag);

        response.sendRedirect("/profile");
    }
}
