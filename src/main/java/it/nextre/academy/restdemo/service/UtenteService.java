package it.nextre.academy.restdemo.service;

import it.nextre.academy.restdemo.entity.Utente;

public interface UtenteService {

    Utente findUserByEmail(String email);
    void salvaUtente(Utente utente);

}
