package it.nextre.academy.restdemo.repository;


import it.nextre.academy.restdemo.entity.Persona;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface PersonaRepository extends JpaRepository<Persona, Long> {

    @Query(value = "select IF(MAX(id) is null,0,MAX(id)) from persona", nativeQuery = true)
    int findByMidMax();

}// end class
