package blog.me.blog.dao;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;

public class BaseDao {
    final static String username = "root";
    final static String password = "laplace";
    final static String url = "jdbc:mysql://127.0.0.1:3306/blog_database";
    public Connection getConnection() {
        Context context = null;
        try {
            context = new InitialContext();
            Context env = (Context) context.lookup("java:comp/env");
            DataSource ds = (DataSource) env.lookup("database");

            Connection conn = ds.getConnection();
            return conn;
        } catch (NamingException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            System.err.format("SQL State: %s\n%s", e.getSQLState(), e.getMessage());
        }

        return null;
    }
}
