package blog.me.blog;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

public class Message {
     public static void send(HttpServletRequest request, String message, String tag) {
          HttpSession session = request.getSession();
          session.setAttribute("message", message);
          session.setAttribute("tag", tag);
     }
}
