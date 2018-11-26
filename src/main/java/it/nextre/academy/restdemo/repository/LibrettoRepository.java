package it.nextre.academy.restdemo.repository;


import it.nextre.academy.restdemo.entity.Libretto;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LibrettoRepository extends JpaRepository<Libretto,Long> {
}
