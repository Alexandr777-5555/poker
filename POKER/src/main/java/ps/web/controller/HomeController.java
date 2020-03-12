package ps.web.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import ps.service.Game;

@Controller
public class HomeController {

    @Autowired
    @Lazy
    private Game game;

    @GetMapping(value = "/")
    public String home() {
        return "home"; //
    }


    @PostMapping(value ="generate")
    public String doIt(){
      //  game.play();
        System.out.println("тута");
        return "redirect:/";
    }




}
