package blog.me.blog.dao;

import blog.me.blog.models.Post;
import blog.me.blog.models.User;

import java.sql.*;

public class UserDao {
    final static String username = "root";
    final static String password = "laplace";
    final static String url = "jdbc:mysql://127.0.0.1:3306/blog_database";
    public User get(int user_id) {
        String SQL = "SELECT * FROM users WHERE user_id = ?;";
        try (Connection conn = DriverManager.getConnection(url, username, password);
             PreparedStatement st = conn.prepareStatement(SQL);) {
            st.setString(1, String.valueOf(user_id));

            ResultSet result = st.executeQuery();

            if(result.next()) {
                String username = result.getString("username");
                String password = result.getString("password");
                String avatar = result.getString("avatar");
                String email = result.getString("email");

                User user = new User(username, email, password, avatar);
                user.setUser_id(user_id);
                return user;
            }
        } catch (SQLException e) {
            System.err.format("SQL State: %s\n%s", e.getSQLState(), e.getMessage());
        }

        return null;
    }

    public User get(String _username ) {
        String SQL = "SELECT * FROM users WHERE username = ?;";

        try (Connection conn = DriverManager.getConnection(url, username, password);
             PreparedStatement st = conn.prepareStatement(SQL);) {
            st.setString(1, String.valueOf(_username));

            ResultSet result = st.executeQuery();

            if(result.next()) {
                int user_id = result.getInt("user_id");
                String username = result.getString("username");
                String password = result.getString("password");
                String avatar = result.getString("avatar");
                String email = result.getString("email");

                User user =  new User(username, email , password, avatar);
                user.setUser_id(user_id);
                return user;
            }
        } catch (SQLException e) {
            System.err.format("SQL State: %s\n%s", e.getSQLState(), e.getMessage());
        }

        return null;
    }

    public boolean create(User user) {
        String SQL = "INSERT INTO users(username, password, avatar, email) VALUES(?,?,?,?);";
        try (Connection conn = DriverManager.getConnection(url, username, password);
             PreparedStatement st = conn.prepareStatement(SQL);) {
            st.setString(1, String.valueOf(user.getUsername()));
            st.setString(2, String.valueOf(user.getPassword()));
            st.setString(3, String.valueOf(user.getAvatar()));
            st.setString(4, String.valueOf(user.getEmail()));

            boolean result = st.executeUpdate() > 0;

            if (result) {
                System.out.println("User created");
            } else {
                System.out.println("...");
            }

            return result;
        } catch (SQLException e) {
            System.err.format("SQL State: %s\n%s", e.getSQLState(), e.getMessage());
        }

        return false;
    }

    public int authenticate(String _username, String _password) {
        String SQL = "SELECT user_id ,username, password FROM users WHERE username = ? AND password = ?;";

        try (Connection conn = DriverManager.getConnection(url, username, password);
             PreparedStatement st = conn.prepareStatement(SQL);) {
            st.setString(1, String.valueOf(_username));
            st.setString(2, String.valueOf(_password));

            ResultSet resultSet = st.executeQuery();
            int result = 0;
            if (resultSet.next()) {
                result = resultSet.getInt("user_id");
            }

            if (result > 0) {
                System.out.println("User " + _username + " login");
            } else {
                System.out.println("Error");
            }

            return result;
        } catch (SQLException e) {
            System.err.format("SQL State: %s\n%s", e.getSQLState(), e.getMessage());
        }

        return 0;
    }


    public boolean update(int user_id, User newUser) {
        String SQL = "UPDATE users SET username = ?, email = ?, avatar = ? WHERE user_id = ?;";
        try (Connection conn = DriverManager.getConnection(url, username, password);
             PreparedStatement st = conn.prepareStatement(SQL);) {
            st.setString(1, String.valueOf(newUser.getUsername()));
            st.setString(2, String.valueOf(newUser.getEmail()));
            st.setString(3, String.valueOf(newUser.getAvatar()));
            st.setString(4, String.valueOf(user_id));

            return st.executeUpdate() > 0;
        } catch (SQLException e) {
            System.err.format("SQL State: %s\n%s", e.getSQLState(), e.getMessage());
        }

        return false;
    }
}
