package se.lexicon.mattias.thymeleaf_demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class Homepage {

    @RequestMapping(path = "", method = RequestMethod.GET) //Default values
    public String index(){
        return "Index.html";
    }

    @RequestMapping(path = "/welcome",method = RequestMethod.GET)
    // @GetMapping("/welcome") is the same thing
    public String anotherWelcomeMessage(){
        return "welcome";
    }

}
