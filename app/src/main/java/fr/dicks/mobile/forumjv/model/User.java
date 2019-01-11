package fr.dicks.mobile.forumjv.model;

public class User {

    private int id;
    private String nickname;
    private String password;
    private String mail;
    private String imageUrl;

    public User(int _id, String _nickname, String _password, String _mail) {
        this.id = _id;
        this.nickname = _nickname;
        this.password = _password;
        this.mail = _mail;
    }

    public void setMail(String _mail) {
        this.mail = _mail;
    }

    public void setImageUrl(String _url) {
        this.imageUrl = _url;
    }

    public int getId() {
        return id;
    }

    public String getNickname() {
        return nickname;
    }

    public String getPassword() {
        return password;
    }

    public String getMail() {
        return mail;
    }

    public String getImageUrl() {
        return imageUrl;
    }
}
