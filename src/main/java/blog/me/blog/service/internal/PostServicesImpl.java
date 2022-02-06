package blog.me.blog.service.internal;

import blog.me.blog.dao.PostDao;
import blog.me.blog.models.Post;
import blog.me.blog.models.User;
import blog.me.blog.service.PostServices;

import java.util.List;

public class PostServicesImpl implements PostServices {
    final static PostDao postDao = new PostDao();
    @Override
    public List<Post> get_user_post_all(int user_id) {
        return null;
    }

    @Override
    public List<Post> get_all() {
        return postDao.get_all();
    }

    @Override
    public Post get(int post_id) {
        return postDao.get(post_id);
    }

    @Override
    public Post get_user_post(int user_id) {
        return null;
    }

    @Override
    public User get_author() {
        return null;
    }

    @Override
    public boolean create(int user_id, String title, String content) {
        return postDao.create(user_id, title, content);
    }

    @Override
    public boolean delete() {
        return false;
    }

    @Override
    public boolean update(int post_id, String title, String content) {
        return postDao.update(post_id, title, content);
    }
}
