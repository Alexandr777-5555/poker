package shop.web.controllers;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import shop.domain.Customer;
import shop.service.CustomerService;

import java.util.List;

@Controller
@RequestMapping("/listCustomer")
public class CustomerController {

    private final Logger log = LoggerFactory.getLogger(this.getClass());

    private final CustomerService service;

    public CustomerController(CustomerService service) {
        this.service = service;
    }


//    @GetMapping
//    public void setupForm(){
//
//    }

    @GetMapping
    public String defaultForm(Model model) {
        List<Customer> list=service.list();
        log.info("size " + list.size());
        model.addAttribute("customers" , list);
        return "listCustomer";
    }







}
