package com.platzi.javatests.movies.data;

import com.platzi.javatests.movies.model.Genre;
import com.platzi.javatests.movies.model.Movie;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.stream.Collectors;

public class MovieRepositoryJdbc implements MovieRepository {

    private static final RowMapper<Movie> movieMapper = (resultSet, i) -> new Movie(
            resultSet.getInt("id"),
            resultSet.getString("name"),
            resultSet.getInt("minutes"),
            Genre.valueOf(resultSet.getString("genre")),
            resultSet.getString("director")
    );
    private final JdbcTemplate jdbcTemplate;

    public MovieRepositoryJdbc(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public Movie findById(long id) {
        Object[] args = {id};
        return jdbcTemplate.queryForObject("SELECT * FROM movies WHERE id = ?", args, movieMapper);
    }

    @Override
    public Collection<Movie> findAll() {
        return jdbcTemplate.query("SELECT * FROM movies", movieMapper);
    }

    @Override
    public void saveOrUpdate(Movie movie) {
        jdbcTemplate.update("INSERT INTO movies (name, minutes, genre, director) VALUES (?, ?, ?, ?)",
                movie.getName(), movie.getMinutes(), movie.getGenre().toString(), movie.getDirector());
    }

    @Override
    public Collection<Movie> findByName(String name) {
        return findAll().stream()
                .filter(movie -> movie.getName().toLowerCase().contains(name.toLowerCase()))
                .collect(Collectors.toList());
    }

    @Override
    public Collection<Movie> findByDirector(String name) {
        return findAll().stream()
                .filter(movie -> movie.getDirector().toLowerCase().contains(name.toLowerCase()))
                .collect(Collectors.toList());
    }

    @Override
    public Collection<Movie> findByMovieTemplate(Movie template) {
        if (template.getMinutes() <= 0) {
            throw new IllegalArgumentException("El valor de los minutos debe ser mayor a cero");
        }

        if (template.getId() != null) {
            return Collections.singletonList(findById(template.getId()));
        }

        return new ArrayList<>();
    }
}
