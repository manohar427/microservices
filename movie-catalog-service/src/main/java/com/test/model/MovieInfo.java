package com.test.model;

public class MovieInfo {
    private String title;
    private String overview;
    private String id;

    public MovieInfo() {
    }

    public MovieInfo(String title, String overview, String id) {
        this.title = title;
        this.overview = overview;
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getOverview() {
        return overview;
    }

    public void setOverview(String overview) {
        this.overview = overview;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "MovieInfo{" +
                "title='" + title + '\'' +
                ", overview='" + overview + '\'' +
                ", id='" + id + '\'' +
                '}';
    }
}
