package it.nextre.academy.restdemo.controller;

import it.nextre.academy.restdemo.entity.Movie;
import it.nextre.academy.restdemo.service.MovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Controller
public class GenericController {

    @Autowired
    MovieService movieService;

    @GetMapping({"/","/index","/home"})
    public String getHomePage(Model model){
        List<String> listaNomi = new ArrayList<>(
                Arrays.asList("Valerio","Francesca","Simone")
        );
        model.addAttribute("vincitori",listaNomi);
        model.addAttribute("titolo", "Movie List");
        return "index";
    }


    @GetMapping("/site/elenco-film")
    public String getElencoFilm(Model model){
        List<Movie> movies = movieService.getAll();
        model.addAttribute("films", movies);
        model.addAttribute("titolo", "Elenco film");
        return "elenco";
    }

    /**
     * Solo per prova uso l'oggetto ModelAndView
     * */

    @GetMapping("/site/elenco-film2")
    public ModelAndView getElencoFilm2(){
        ModelAndView mav = new ModelAndView("elenco");
        List<Movie> movies = movieService.getAll();
        mav.addObject("films", movies);
        mav.addObject("titolo", "Elenco film");
        mav.setViewName("elenco"); //qua o nel costruttore
        return mav;
    }

}//end class
