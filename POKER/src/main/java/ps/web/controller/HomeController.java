package ps.web.controller;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import ps.model.Table;

import java.util.concurrent.Callable;

@Controller
public class HomeController {

    private final Logger log = LoggerFactory.getLogger(this.getClass());

    @Autowired
    @Lazy
    private Table table;

    @GetMapping(value = "/")
    public String home() {
        return "home"; //
    }


    @PostMapping(params = "action-button")
    public Callable<String> doIt() {
        log.info("задача создана");
        return () -> {
            // Delayer.randomDelay();
            table.game();
            return "home";
        };
    }


}
