package blog.me.blog.models;

import java.util.regex.Pattern;

public class User {
    final public static String DEFAULT = "/home/laplace/Downloads/uploads/default.jpg";
    private int user_id;
    private String username;
    private String password;
    private String avatar;
    private String email;

    public User(String username, String email, String password) {
        this(username,  email, password, DEFAULT);
    }

    public User(String username, String email, String password, String avatar) {
        setUsername(username);
        setEmail(email);
        setPassword(password);
        setAvatar(avatar);
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        String pattern = "^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%^&+=])(?=\\S+$).{8,}$";
        if (patternMatches(password, pattern)) {
            this.password = password;
        } else {
            System.out.println(password + " is not valid");
        }
    }

    public String getAvatar() {
        return avatar;
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        String pattern = "(?:[a-z0-9!#$%&'*+/=?^_`{|}~-]+(?:\\.[a-z0-9!#$%&'*+/=?^_`{|}~-]+)*|\"(?:[\\x01-\\x08\\x0b\\x0c\\x0e-\\x1f\\x21\\x23-\\x5b\\x5d-\\x7f]|\\\\[\\x01-\\x09\\x0b\\x0c\\x0e-\\x7f])*\")@(?:(?:[a-z0-9](?:[a-z0-9-]*[a-z0-9])?\\.)+[a-z0-9](?:[a-z0-9-]*[a-z0-9])?|\\[(?:(?:25[0-5]|2[0-4][0-9]|[01]?[0-9][0-9]?)\\.){3}(?:25[0-5]|2[0-4][0-9]|[01]?[0-9][0-9]?|[a-z0-9-]*[a-z0-9]:(?:[\\x01-\\x08\\x0b\\x0c\\x0e-\\x1f\\x21-\\x5a\\x53-\\x7f]|\\\\[\\x01-\\x09\\x0b\\x0c\\x0e-\\x7f])+)\\])";
        if (patternMatches(email, pattern)) {
            this.email = email;
        } else {
            System.out.println(email + " is not a valid email");
        }
    }

    public static boolean patternMatches(String emailAddress, String regexPattern) {
        return true;
//        return Pattern.compile(regexPattern)
//                .matcher(emailAddress)
//                .matches();
    }

    public int getUser_id() {
        return user_id;
    }

    public void setUser_id(int user_id) {
        this.user_id = user_id;
    }
}
