package spring_boot_sample.controller;


import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@EnableAutoConfiguration
public class NameController {


    @GetMapping("/")
    public String defaultForm(){
        return "Hello Alexander";
    }




}
