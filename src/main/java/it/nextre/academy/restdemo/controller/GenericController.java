package it.nextre.academy.restdemo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class GenericController {

    @GetMapping({"/","/index","/home"})
    public String getHomePage(Model model){
        //model.addAttribute("titolo", "Movie List");
        return "index";
    }


}//end class
