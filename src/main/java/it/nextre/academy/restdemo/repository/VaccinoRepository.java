package it.nextre.academy.restdemo.repository;


import it.nextre.academy.restdemo.entity.Vaccino;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface VaccinoRepository extends JpaRepository<Vaccino,Long> {
}
