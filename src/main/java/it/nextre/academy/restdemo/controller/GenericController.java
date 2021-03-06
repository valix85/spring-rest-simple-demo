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

    @GetMapping({"/","/index","/home"})
    public String getHomePage(Model model){
        List<String> listaNomi = new ArrayList<>(
                Arrays.asList("Valerio","Francesca","Simone")
        );
        model.addAttribute("vincitori",listaNomi);
        model.addAttribute("titolo", "Movie List");
        return "index";
    }


    /*
     * o definisco qui la rotta, ma essendo statica posso metterla come configurazione di MvcConfig
     */
    /*
    @GetMapping("/login")
    public String getLoginPage(){
        return "login";
    }
    */

}//end class
