package it.nextre.academy.restdemo.repository;

import it.nextre.academy.restdemo.entity.Utente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UtenteRepository extends JpaRepository<Utente,Integer> {
    Utente findByEmail(String email);
}//end class
