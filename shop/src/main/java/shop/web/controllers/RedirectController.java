package shop.web.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class RedirectController {


    @RequestMapping(value = "/*", method = RequestMethod.GET)
    public void getPages() throws Exception {
        throw new Exception();
    }



}
