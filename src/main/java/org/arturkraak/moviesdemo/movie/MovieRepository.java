package org.arturkraak.moviesdemo.movie;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MovieRepository extends JpaRepository<Movie, Integer>, JpaSpecificationExecutor<Movie> {
    // https://stackoverflow.com/a/21461715
    @Query("SELECT m FROM Movie m WHERE UPPER(m.title) LIKE CONCAT('%',UPPER(:title),'%')")
    List<Movie> findMovieByTitle(@Param("title") String title);

    @Query("SELECT m FROM Movie m WHERE UPPER(m.title) LIKE CONCAT('%',UPPER(:title),'%') AND UPPER(m.genres) LIKE CONCAT('%',UPPER(:genre),'%')")
    List<Movie> findMovieByGenre(@Param("title") String title, @Param("genre") String genre);
}
