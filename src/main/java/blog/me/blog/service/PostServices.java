package blog.me.blog.service;

import blog.me.blog.models.Post;
import blog.me.blog.models.User;

import java.util.List;

public interface PostServices {
    Post get(int post_id);
    Post get_user_post(int user_id);
    List<Post> get_all();
    List<Post> get_user_post_all(int user_id);
    User get_author();
    boolean create(int user_id, String title, String content);
    boolean delete();
    boolean update(int post_id, String title, String content);
}
