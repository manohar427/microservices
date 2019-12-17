package com.test.model;

public class MovieInfo {
    private String name;
    private String movieId;

    public MovieInfo() {
    }

    public MovieInfo(String name, String movieId) {
        this.name = name;
        this.movieId = movieId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getMovieId() {
        return movieId;
    }

    public void setMovieId(String movieId) {
        this.movieId = movieId;
    }

    @Override
    public String toString() {
        return "MovieInfo{" +
                "name='" + name + '\'' +
                ", movieId='" + movieId + '\'' +
                '}';
    }
}
