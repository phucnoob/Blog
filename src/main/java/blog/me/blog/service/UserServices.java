package blog.me.blog.service;

import blog.me.blog.models.User;

public interface UserServices {
    User get(int user_id);
    boolean create(User user);
     int authenticate(String username, String password);
    boolean delete();
    boolean update(int user_id, User newUser );
}
