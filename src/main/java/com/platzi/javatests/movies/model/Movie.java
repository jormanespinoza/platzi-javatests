package com.platzi.javatests.movies.model;

import java.util.Objects;

public class Movie {

    private final Integer id;
    private final String name;
    private final int minutes;
    private final Genre genre;
    private final String director;

    public Movie(String name, int minutes, Genre genre, String director) {
        this(null, name, minutes, genre, director);
    }

    public Movie(Integer id, String name, int minutes, Genre genre, String director) {
        this.id = id;
        this.name = name;
        this.minutes = minutes;
        this.genre = genre;
        this.director = director;
    }

    public Integer getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public int getMinutes() {
        return minutes;
    }

    public Genre getGenre() {
        return genre;
    }

    public String getDirector() {
        return director;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Movie)) return false;
        Movie movie = (Movie) o;
        return getMinutes() == movie.getMinutes() && Objects.equals(getId(), movie.getId()) && Objects.equals(getName(), movie.getName()) && getGenre() == movie.getGenre() && Objects.equals(getDirector(), movie.getDirector());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getName(), getMinutes(), getGenre(), getDirector());
    }
}
