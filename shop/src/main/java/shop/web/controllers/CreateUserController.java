package shop.web.controllers;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.support.SessionStatus;
import shop.domain.Customer;
import shop.domain.CustomerValidator;
import shop.service.CustomerService;

@Controller
@RequestMapping("/createUser")
@SessionAttributes("customer")
public class CreateUserController {

    private final Logger log = LoggerFactory.getLogger(this.getClass());

    private final CustomerService customerService;

    public CreateUserController(CustomerService customerService) {
        this.customerService = customerService;
    }

    @Autowired
    private CustomerValidator validator;


    @GetMapping
    public void setupForm(Model model) {
        Customer customer = new Customer();
        model.addAttribute("customer", customer);
    }


    @InitBinder
    public void initBuilder(WebDataBinder binder) {
        binder.setValidator(validator);
    }


    @RequestMapping(method = RequestMethod.POST)
    public String submitForm(
            @ModelAttribute("customer") @Validated Customer customer,
            BindingResult result, SessionStatus status) {
        if (result.hasErrors()) {
            return "createUser";
        }
        customerService.save(customer);
        log.info("save customer : " + customer.getFirstName());
        status.setComplete();
        return "createUserSuccess";
    }

}
