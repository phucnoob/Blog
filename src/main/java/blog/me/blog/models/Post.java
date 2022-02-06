package blog.me.blog.models;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Post {
    public static DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MMMM dd, yyyy");
    private int post_id;
    private int user_id;
    private String title;
    private String content;
    private LocalDateTime date_posted;

    private User author;

    public int getPost_id() {
        return post_id;
    }

    public void setPost_id(int post_id) {
        this.post_id = post_id;
    }

    public int getUser_id() {
        return user_id;
    }

    public void setUser_id(int user_id) {
        this.user_id = user_id;
    }

    public Post(String title, String content, User author) {
        this.title = title;
        this.content = content;
        this.author = author;
        this.date_posted = LocalDateTime.now();
    }

    public Post(String title, String content, LocalDateTime date_posted, User author) {
        this.title = title;
        this.content = content;
        this.author = author;
        this.date_posted = date_posted;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getDate_posted() {
        return date_posted.format(formatter);
    }

    public void setDate_posted(LocalDateTime date_posted) {
        this.date_posted = date_posted;
    }

    public User getAuthor() {
        return author;
    }

    public void setAuthor(User author) {
        this.author = author;
    }

    @Override
    public String toString() {
        return "Post{" +
                "title='" + title + '\'' +
                ", content='" + content + '\'' +
                ", author='" + author + '\'' +
                '}';
    }
}
