package blog.me.blog.service;

import blog.me.blog.dao.UserDao;
import blog.me.blog.models.User;

public class UserServices {
    final static UserDao userdao = new UserDao();

    public User get(int user_id) {
        return userdao.get(user_id);
    }

    public User get(String username) {
        return userdao.get(username);
    }

    public boolean create(User user) {
        return userdao.create(user);
    }

    public int authenticate(String username, String password) {
        return userdao.authenticate(username, password);
    }


    public boolean delete() {
        return false;
    }

    public boolean update(int user_id, User newUser ) {
        return userdao.update(user_id, newUser);
    }
}
