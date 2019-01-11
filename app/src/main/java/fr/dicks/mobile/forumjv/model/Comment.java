package fr.dicks.mobile.forumjv.model;

import java.util.Date;

import fr.dicks.mobile.forumjv.ui.activities.MainActivity;

public class Comment {
    private int id;
    private String message;
    private int topicId;
    private int userId;
    private Date date;

    public Comment(int _id, String _message, int _topicId, int _userId, String _date) {
        this.id = _id;
        this.message = _message;
        this.topicId = _topicId;
        this.userId = _userId;
        this.date = MainActivity.stringToDate(_date);
    }

    public int getId() {
        return id;
    }

    public String getMessage() {
        return message;
    }

    public int getTopicId() {
        return topicId;
    }

    public int getUserId() {
        return userId;
    }

    public Date getDate() {
        return date;
    }
}
