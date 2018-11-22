package it.nextre.academy.restdemo.service.impl;

import it.nextre.academy.restdemo.entity.Movie;
import it.nextre.academy.restdemo.exception.MovieException;
import it.nextre.academy.restdemo.repository.MovieRepository;
import it.nextre.academy.restdemo.service.MovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import javax.transaction.Transactional;
import java.util.List;

@Service
public class MovieServiceImpl implements MovieService {

    @Autowired
    MovieRepository movieRepository;

    @Override
    public List<Movie> getAll() {
        return movieRepository.findAll();
    }

    @Override
    public List<Movie> getTitle(String titolo) {
        return movieRepository.findByTitleContaining(titolo);
    }

    @Override
    public Movie getByID(int id){
        return movieRepository.findById(id).orElse(new Movie());
    }

    @Override
    public List<Movie> getYear(int year) {
        return movieRepository.findByYear(year);
    }

    @Override
    public List<Movie> getDirector(String name) {
        return movieRepository.findByDirectorContains(name);
    }

    @Override
    @Transactional
    public Movie addMovie(Movie movie) throws MovieException {
        if (isValidMovie(movie)){
            int mid = 1+movieRepository.trovaMaxID();
            System.out.println("mID= " + mid);
            movie.setMID(mid);
            return movieRepository.save(movie);
        }else{
            throw new MovieException("Oggetto Movie non valido");
        }
    }


    private boolean isValidMovie(Movie movie){
        return (movie.getTitle() != null && movie.getTitle().length()>0);
    }









    @Override
    public Movie updateMovie(Movie movie) throws MovieException {
        if (isValidMovie(movie)){
            return movieRepository.save(movie);
        }else{
            throw new MovieException("Oggetto Movie non valido");
        }
    }



    @Override
    public Movie updateMovie(int oldMid, Movie movie) throws MovieException {
        if (isValidMovie(movie)){
            int row = movieRepository.updateId(oldMid, movie.getMID(), movie.getTitle(), movie.getYear(), movie.getDirector());
            if (row==1) {
                return movieRepository.findById(movie.getMID()).orElseThrow(MovieException::new);
            }
        }
        throw new MovieException("Oggetto Movie non valido");
    }


    @Override
    public boolean deleteById(Integer mid) {
        try {
            movieRepository.deleteById(mid);
        }catch(EmptyResultDataAccessException e){
            return false;
        }
        return !movieRepository.findById(mid).isPresent();
    }
}//end class
