package org.arturkraak.moviesdemo.movie;

import org.arturkraak.moviesdemo.model.Movie;
import org.springframework.data.repository.ListCrudRepository;

public interface MovieRepository extends ListCrudRepository<Movie,String> {
}
