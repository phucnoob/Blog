package blog.me.blog.dao;

import blog.me.blog.models.Post;
import blog.me.blog.models.User;
import blog.me.blog.service.UserServices;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;
import java.sql.*;
import java.util.Collections;
import java.util.List;

public class PostDao extends BaseDao {
    final static String user = "root";
    final static String password = "laplace";
    final static String url = "jdbc:mysql://127.0.0.1:3306/blog_database";

    public Post get(int post_id) {
        String SQL = "SELECT * FROM posts WHERE  post_id = ?;";
        try (Connection conn = getConnection();
             PreparedStatement st = conn.prepareStatement(SQL);) {
            st.setInt(1, post_id);

            ResultSet result = st.executeQuery();

            if(result.next()) {
                String title = result.getString("title");
                String content = result.getString("content");
                Timestamp date_posted = result.getTimestamp("date_posted");
                int user_id = result.getInt("user_id");
                User author = new UserServices().get(user_id);
                Post post = new Post(title, content, date_posted.toLocalDateTime(), author);
                post.setPost_id(post_id);
                return post;
            }
        } catch (SQLException e) {
            System.err.format("SQL State: %s\n%s", e.getSQLState(), e.getMessage());
        }

        return null;
    }

    public List<Post> get_all()  {

        String SQL = "SELECT * FROM posts ORDER BY date_posted DESC ;";

        List<Post> posts = new java.util.ArrayList<>(Collections.emptyList());


        try (Connection conn = getConnection();
             PreparedStatement st = conn.prepareStatement(SQL);) {

            ResultSet result = st.executeQuery();

            while (result.next()) {
                int id = result.getInt("post_id");
                String title = result.getString("title");
                String content = result.getString("content");
                Timestamp date_posted = result.getTimestamp("date_posted");
                int user_id = result.getInt("user_id");
                User author = new UserServices().get(user_id);

                Post post = new Post(title, content, date_posted.toLocalDateTime(), author);
                post.setPost_id(id);
                posts.add(post);
            }
        } catch (SQLException e) {
            System.err.format("SQL State: %s\n%s", e.getSQLState(), e.getMessage());
        }

        return posts;
    }

    public boolean create(int user_id, String title, String content) {
        String SQL = "INSERT INTO posts(user_id, title, content) VALUES (?,?,?);";

        try (Connection conn = getConnection();
             PreparedStatement st = conn.prepareStatement(SQL);) {
            st.setInt(1, user_id);
            st.setString(2, title);
            st.setString(3, content);
            int result = st.executeUpdate();
            if (result >= 1) {
                System.out.println("INFO: Post " + title + " created");
                return true;
            }
        } catch (SQLException e) {
            System.err.format("SQL State: %s\n%s", e.getSQLState(), e.getMessage());
        }

        return false;
    }

    public boolean update(int post_id, String title, String content) {
        String SQL = "UPDATE posts SET title = ? , content = ? WHERE post_id = ?;";

        try (Connection conn = getConnection();
             PreparedStatement st = conn.prepareStatement(SQL);) {
            st.setInt(3, post_id);
            st.setString(1, title);
            st.setString(2, content);
            int result = st.executeUpdate();
            if (result >= 1) {
                System.out.println("INFO: Post " + title + " updated");
                return true;
            }
        } catch (SQLException e) {
            System.err.format("SQL State: %s\n%s", e.getSQLState(), e.getMessage());
        }

        return false;
    }

    public boolean delete(int post_id) {

        String SQL = "DELETE FROM posts WHERE post_id = ?;";
        boolean result = false;
        try ( Connection conn = getConnection();
            PreparedStatement st = conn.prepareStatement(SQL);){

            st.setInt(1, post_id);
            result = st.executeUpdate() > 0;

        } catch (SQLException e) {
            System.err.format("SQL State: %s\n%s", e.getSQLState(), e.getMessage());
        }

        return result;
    }
}
