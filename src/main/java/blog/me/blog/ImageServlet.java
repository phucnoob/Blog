package blog.me.blog;

import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.net.URL;

@WebServlet( urlPatterns = {"/image"})
public class ImageServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String path = request.getParameter("image");
        response.setContentType("image/jpeg");
        ServletOutputStream out = response.getOutputStream();

        File f = new File(path);

        if (!f.exists())
            response.setStatus(404);

        FileInputStream fin = new FileInputStream(f);
        BufferedInputStream bin = new BufferedInputStream(fin);
        BufferedOutputStream bout = new BufferedOutputStream(out);
        int ch =0;
        while((ch=bin.read())!=-1){
            bout.write(ch);
        }
        bin.close();
        fin.close();
        bout.close();
        out.close();
    }
}
