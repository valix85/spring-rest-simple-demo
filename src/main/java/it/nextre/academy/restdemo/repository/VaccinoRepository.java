package it.nextre.academy.restdemo.repository;


import it.nextre.academy.restdemo.entity.Vaccino;
import org.springframework.data.jpa.repository.JpaRepository;

public interface VaccinoRepository extends JpaRepository<Vaccino,Long> {
}
