package library.movie.Movies;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class MovieRepository {

    @Autowired
    JdbcTemplate jdbcTemplate;
    public List<Movie> getAll(){


        return jdbcTemplate.query( "SELECT id, name, rating FROM movie", BeanPropertyRowMapper.newInstance(Movie.class));

    }
    public  Movie getbyId(int id)
    {

       return jdbcTemplate.queryForObject( "SELECT Id, name rating FROM movie WHERE id = ?", BeanPropertyRowMapper.newInstance(Movie.class), id);
    }
}
