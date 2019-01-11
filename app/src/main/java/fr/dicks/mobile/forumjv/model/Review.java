package fr.dicks.mobile.forumjv.model;

import java.util.Date;

import fr.dicks.mobile.forumjv.ui.activities.MainActivity;

public class Review {

    private int id;
    private String comment;
    private Double rating;
    private int gameId;
    private int userId;
    private Date date;

    public Review(int _id, String _comment, Double _rating, int _gameId, int _userId, String _date) {
        this.id = _id;
        this.comment = _comment;
        this.rating = _rating;
        this.gameId = _gameId;
        this.userId = _userId;
        this.date = MainActivity.stringToDate(_date);
    }

    public int getId() {
        return id;
    }

    public String getComment() {
        return comment;
    }

    public Double getRating() {
        return rating;
    }

    public int getGameId() {
        return gameId;
    }

    public int getUserId() {
        return userId;
    }

    public Date getDate() {
        return date;
    }
}
