package shop.web.controllers.tlles;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/")
public class HelloController {


    @GetMapping
   // @RequestMapping(value = { "/" }, method = RequestMethod.GET)
    public String setupForm() {
        return "hello";
    }



}
