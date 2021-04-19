package com.platzi.javatests.movies.data;

import com.platzi.javatests.movies.model.Movie;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.core.io.ClassPathResource;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.jdbc.datasource.init.ScriptUtils;

import javax.sql.DataSource;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.*;
import java.util.stream.Collectors;

import static com.platzi.javatests.movies.model.Genre.ACTION;
import static com.platzi.javatests.movies.model.Genre.THRILLER;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class MovieRepositoryIntegrationTest {

    private MovieRepository movieRepository;
    private DataSource dataSource;

    @BeforeEach
    void setUp() throws SQLException {
        dataSource = new DriverManagerDataSource("jdbc:h2:mem:test;MODE=MYSQL", "sa", "sa");
        ScriptUtils.executeSqlScript(dataSource.getConnection(), new ClassPathResource("sql-scripts/test-data.sql"));
        JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
        movieRepository = new MovieRepositoryJdbc(jdbcTemplate);
    }

    @Test
    void load_all_movies() {
        Collection<Movie> movies = movieRepository.findAll();

        assertEquals(Arrays.asList(
                new Movie(1, "Dark Night", 152, ACTION, "Christopher Nolan"),
                new Movie(2, "Memento", 113, THRILLER, "Christopher Nolan"),
                new Movie(3, "Matrix", 136, ACTION, "Hermanas Wachowski")), movies);
    }

    @Test
    void load_movie_by_id() {
        Movie movie = movieRepository.findById(2);

        assertEquals(new Movie(2, "Memento", 113, THRILLER, "Christopher Nolan"), movie);
    }

    @Test
    void insert_a_movie() {
        movieRepository.saveOrUpdate(new Movie("Super 8", 112, THRILLER, "J. J. Abrams"));

        Movie movieFromDb = movieRepository.findById(4);

        assertEquals(movieFromDb, new Movie(4, "Super 8", 112, THRILLER, "J. J. Abrams"));
    }

    @Test
    void return_movies_by_name() {
        Collection<Movie> movies = movieRepository.findByName("M");

        assertEquals(Arrays.asList(
                new Movie(2, "Memento", 113, THRILLER, "Christopher Nolan"),
                new Movie(3, "Matrix", 136, ACTION, "Hermanas Wachowski")), movies);

        movies = movieRepository.findByName("T");

        assertEquals(Arrays.asList(
                new Movie(1, "Dark Night", 152, ACTION, "Christopher Nolan"),
                new Movie(2, "Memento", 113, THRILLER, "Christopher Nolan"),
                new Movie(3, "Matrix", 136, ACTION, "Hermanas Wachowski")), movies);

        movies = movieRepository.findByName("G");

        assertEquals(Arrays.asList(new Movie(1, "Dark Night", 152, ACTION, "Christopher Nolan")), movies);
    }

    @Test
    void return_zero_movies_by_name_when_movies_were_not_found() {
        Collection<Movie> movies = movieRepository.findByName("Z");

        assertEquals(new ArrayList<>(), movies);
    }

    @Test
    void return_movies_by_director() {
        Collection<Movie> movies = movieRepository.findByDirector("Christopher");

        assertEquals(Arrays.asList(
                new Movie(1, "Dark Night", 152, ACTION, "Christopher Nolan"),
                new Movie(2, "Memento", 113, THRILLER, "Christopher Nolan")), movies);
    }

    @Test
    void return_zero_movies_by_director_when_movies_were_not_found() {
        Collection<Movie> movies = movieRepository.findByDirector("Tarantino");

        assertEquals(new ArrayList<>(), movies);
    }

    @Test
    void throw_illegal_argument_exception_when_given_minutes_are_lower_or_equal_than_zero() {
        assertThrows(IllegalArgumentException.class, () -> movieRepository.findByMovieTemplate(new Movie(null, null, 0, null, null)));
    }

    @Test
    void return_movies_by_template_when_is_not_null() {
        Collection<Movie> moviesByTemplate = movieRepository.findByMovieTemplate(new Movie(1, null, null, null, null));

        Collection<Integer> moviesIds = moviesByTemplate.stream().map(Movie::getId).collect(Collectors.toList());

        assertEquals(Collections.singletonList(1), moviesIds);
    }

    @AfterEach
    void tearDown() throws SQLException {
        final Statement statement = dataSource.getConnection().createStatement();
        statement.execute("DROP ALL objects DELETE files");
    }
}