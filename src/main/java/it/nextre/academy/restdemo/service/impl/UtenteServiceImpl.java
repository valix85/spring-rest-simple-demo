package it.nextre.academy.restdemo.service.impl;

import it.nextre.academy.restdemo.entity.Ruolo;
import it.nextre.academy.restdemo.entity.Utente;
import it.nextre.academy.restdemo.repository.RuoloRepository;
import it.nextre.academy.restdemo.repository.UtenteRepository;
import it.nextre.academy.restdemo.service.UtenteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.HashSet;

@Service
public class UtenteServiceImpl implements UtenteService {

    @Autowired
    private UtenteRepository utenteRepository;
    @Autowired
    private RuoloRepository ruoloRepository;
    @Autowired
    private PasswordEncoder bCryptPasswordEncoder;

    @Override
    public Utente findUserByEmail(String email) {
        return utenteRepository.findByEmail(email);
    }

    @Override
    public void salvaUtente(Utente utente) {
        utente.setPassword(bCryptPasswordEncoder.encode(utente.getPassword()));
        utente.setActive(1);
        //caricati su db col file data.sql ad ogni avvio
        Ruolo utenteRuolo = ruoloRepository.findByRuolo("BASIC");
        utente.setRoles(new HashSet<Ruolo>(Arrays.asList(utenteRuolo)));
        utenteRepository.save(utente);

    }
}//end class
