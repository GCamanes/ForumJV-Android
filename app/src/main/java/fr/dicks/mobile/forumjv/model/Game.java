package fr.dicks.mobile.forumjv.model;

import java.util.List;

public class Game {

    private int id;
    private String title;
    private String description;
    private double rating;
    private List<String> creators;
    private List<String> platforms;

    public Game(int _id, String _title, String _description, double _rating) {
        this.id = _id;
        this.title = _title;
        this.description = _description;
        this.rating = _rating;
    }

    public void addCreator(String _creator) {
        this.creators.add(_creator);
    }

    public void addPlatform(String _platform) {
        this.platforms.add(_platform);
    }

    public void setRating(double _rating) {
        this.rating = _rating;
    }

    public int getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getDescription() {
        return description;
    }

    public double getRating() {
        return rating;
    }

    public List<String> getCreators() {
        return creators;
    }

    public List<String> getPlatforms() {
        return platforms;
    }
}
