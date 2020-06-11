package shop.web.controllers;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
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

    @GetMapping
    public String defaultForm(Model model) {
        List<Customer> list = service.list();
        log.info("size " + list.size());
        model.addAttribute("customers", list);
        return "listCustomer";
    }


    @DeleteMapping("/{customerId}")
    //@RequestMapping(method = RequestMethod.DELETE)
    public String delete(@PathVariable("customerId") long id) {
        log.info("customer id " + id);
        service.remove(id);
        //return "redirect:/listCustomer";
        return "listCustomer";
    }


}
