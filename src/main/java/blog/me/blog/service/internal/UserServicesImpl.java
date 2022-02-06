package blog.me.blog.service.internal;

import blog.me.blog.dao.UserDao;
import blog.me.blog.models.User;
import blog.me.blog.service.UserServices;

public class UserServicesImpl implements UserServices {
    final static UserDao userdao = new UserDao();
    @Override
    public User get(int user_id) {
        return userdao.get(user_id);
    }

    public User get(String username) {
        return userdao.get(username);
    }

    @Override
    public boolean create(User user) {
        return userdao.create(user);
    }

    public int authenticate(String username, String password) {
        return userdao.authenticate(username, password);
    }

    @Override
    public boolean delete() {
        return false;
    }

    @Override
    public boolean update(int user_id, User newUser ) {
        return userdao.update(user_id, newUser);
    }
}
