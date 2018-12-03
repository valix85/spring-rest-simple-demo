package it.nextre.academy.restdemo.controller;

import it.nextre.academy.restdemo.RestDemoApplication;
import it.nextre.academy.restdemo.entity.Utente;
import it.nextre.academy.restdemo.service.UtenteService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;

@Controller
public class LoginController {

    private static final Logger logger = LogManager.getLogger(LoginController.class);

    @Autowired
    UtenteService utenteService;


    @GetMapping("/registration")
    public ModelAndView registration(){
        ModelAndView modelAndView = new ModelAndView();
        //Utente user = new Utente();
        //modelAndView.addObject("user", user);
        modelAndView.setViewName("registration");
        return modelAndView;
    }




    @PostMapping("/registration")
    public ModelAndView createNewUser(@Valid Utente user, BindingResult bindingResult) {
        logger.debug("Richiesta di registrazione");
        System.out.println(user);

        ModelAndView modelAndView = new ModelAndView();
        Utente userExists = utenteService.findUserByEmail(user.getEmail());
        if (userExists != null) {
            bindingResult
                    .rejectValue("email", "error.user",
                            "There is already a user registered with the email provided");
        }
        if (bindingResult.hasErrors()) {
            modelAndView.setViewName("registration");
        } else {
            utenteService.salvaUtente(user);
            modelAndView.addObject("successMessage", "User has been registered successfully");
            modelAndView.addObject("user", new Utente());
            modelAndView.setViewName("registration");

        }
        return modelAndView;
    }


}//end class
