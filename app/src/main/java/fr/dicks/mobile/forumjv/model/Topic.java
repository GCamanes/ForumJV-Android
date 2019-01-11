package fr.dicks.mobile.forumjv.model;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.Locale;

import fr.dicks.mobile.forumjv.ui.activities.MainActivity;

public class Topic {

    private int id;
    private String subject;
    private int gameId;
    private int userId;
    private Date date;
    private Date lastUpdate;

    public Topic(int _id, String _subject, int _gameId, int _userId, String _date) {
        this.id = _id;
        this.subject = _subject;
        this.gameId = _gameId;
        this.userId = _userId;
        this.date = MainActivity.stringToDate(_date);
    }

    public void setLastUpdate(Date lastUpdate) {
        this.lastUpdate = lastUpdate;
    }

    public int getId() {
        return id;
    }

    public String getSubject() {
        return subject;
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

    public Date getLastUpdate() {
        return lastUpdate;
    }
}
