package shop.web.controllers;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
@RequestMapping("/all_reports")
public class AllReportController {


    @GetMapping
    public void setupForm() {

    }

}
