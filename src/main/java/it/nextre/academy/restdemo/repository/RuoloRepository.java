package it.nextre.academy.restdemo.repository;

import it.nextre.academy.restdemo.entity.Ruolo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RuoloRepository extends JpaRepository<Ruolo, Integer> {
    Ruolo findByRuolo(String ruolo);
}
