package it.nextre.academy.restdemo.repository;

import it.nextre.academy.restdemo.entity.Movie;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Repository
public interface MovieRepository extends JpaRepository<Movie, Integer> {

    //List<Movie> findByTitle(String title);
    List<Movie> findByTitleContaining(String title);
    List<Movie> findByYear(int year);
    List<Movie> findByDirectorContains(String director);


    @Query(value="select IF(max(mID) is null, 0,max(mID)) from movie", nativeQuery = true)
    Integer trovaMaxID();


    @Modifying //abilito la scrittura su db, di default le query sono read-only
    @Transactional
    @Query(value="UPDATE movie set mid= :idNuovo, title= :titolo, year= :anno, director= :regista where mid= :idVecchio", nativeQuery = true)
    int updateId(int idVecchio, int idNuovo, String titolo, int anno, String regista);
}
