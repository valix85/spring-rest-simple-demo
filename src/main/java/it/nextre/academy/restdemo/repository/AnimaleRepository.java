package it.nextre.academy.restdemo.repository;


import it.nextre.academy.restdemo.entity.Animale;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AnimaleRepository extends JpaRepository<Animale,Long> {
}
