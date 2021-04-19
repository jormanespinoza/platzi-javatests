package com.platzi.javatests.movies.service;

import com.platzi.javatests.movies.data.MovieRepository;
import com.platzi.javatests.movies.model.Genre;
import com.platzi.javatests.movies.model.Movie;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.Collection;

import static com.platzi.javatests.movies.model.Genre.*;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

class MovieServiceShould {

    private MovieService movieService;

    @BeforeEach
    void setUp() {
        MovieRepository movieRepository = mock(MovieRepository.class);
        movieService = new MovieService(movieRepository);
        when(movieRepository.findAll()).thenReturn(Arrays.asList(
                new Movie(1, "Dark Knight", 152, ACTION, "Christopher Nolan"),
                new Movie(2, "Memento", 113, THRILLER, "Christopher Nolan"),
                new Movie(3, "There's Something About Mary", 119, COMEDY, "Petter Farrely"),
                new Movie(4, "Super 8", 112, THRILLER, "J. J. Abrams"),
                new Movie(5, "Scream", 111, HORROR, "Wes Craven"),
                new Movie(6, "Home Alone", 103, COMEDY, "Chris Columbus"),
                new Movie(7, "Matrix", 136, ACTION, "Hermanas Wachowski")
        ));
    }

    @Test
    void return_movies_by_genre() {
        Collection<Movie> moviesByGenre = movieService.findMoviesByGenre(Genre.COMEDY);

        moviesByGenre.forEach(movie -> assertEquals(COMEDY, movie.getGenre()));
    }

    @Test
    void return_movies_by_length() {
        Collection<Movie> moviesByLength = movieService.findMoviesByLength(119);

        moviesByLength.forEach(movie -> assertTrue(movie.getMinutes() <= 119));
    }

    /*
        String name = null; // no queremos buscar por nombre
        Integer minutes = 150; // 2h 30m
        Genre genre = Genre.ACTION;
        Movie template = new Movie(name, minutes, genre);
        Collection<Movie> movies =
            movieService.findMoviesByTemplate(template);
        assertThat(getMovieIds(movies), is(Arrays.asList(7)) );
     */
}