package it.nextre.academy.restdemo.service;

import it.nextre.academy.restdemo.entity.Movie;
import it.nextre.academy.restdemo.exception.MovieException;
import org.springframework.stereotype.Service;

import java.util.List;


public interface MovieService {
    List<Movie> getAll();
    List<Movie> getTitle(String titolo);
    List<Movie> getYear(int year);
    List<Movie> getDirector(String name);
    Movie getByID(int id);

    Movie addMovie(Movie movie) throws MovieException;

    Movie updateMovie(Movie movie) throws MovieException;
    Movie updateMovie(int oldMID, Movie movie) throws MovieException;

    boolean deleteById(Integer mid);
}
