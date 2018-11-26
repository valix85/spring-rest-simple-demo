package it.nextre.academy.restdemo.repository;


import it.nextre.academy.restdemo.entity.Vaccinazione;
import org.springframework.data.jpa.repository.JpaRepository;

public interface VaccinazioneRepository extends JpaRepository<Vaccinazione,Long> {
}
