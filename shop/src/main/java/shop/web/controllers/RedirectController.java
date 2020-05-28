package shop.web.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class RedirectController {


    @RequestMapping(value = "/*", method = RequestMethod.GET)
    public void getPages()
            throws Exception {
        throw new Exception();
    }



}
