package blog.me.blog.service;

import blog.me.blog.dao.PostDao;
import blog.me.blog.models.Post;
import blog.me.blog.models.User;

import java.util.List;

public class PostServices {
    final static PostDao postDao = new PostDao();
    public List<Post> get_user_post_all(int user_id) {
        return null;
    }

    public List<Post> get_all() {
        return postDao.get_all();
    }

    public Post get(int post_id) {
        return postDao.get(post_id);
    }


    public Post get_user_post(int user_id) {
        return null;
    }

    public User get_author() {
        return null;
    }

    public boolean create(int user_id, String title, String content) {
        return postDao.create(user_id, title, content);
    }

    public boolean delete(int post_id) {
        return postDao.delete(post_id);
    }

    public boolean update(int post_id, String title, String content) {
        return postDao.update(post_id, title, content);
    }
}
