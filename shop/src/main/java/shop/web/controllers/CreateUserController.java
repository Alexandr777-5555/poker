package shop.web.controllers;


import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.support.SessionStatus;
import shop.domain.Customer;

@Controller
@RequestMapping("/createUser")
public class CreateUserController {


    @GetMapping
    public void setupForm() {

    }


    @RequestMapping(method = RequestMethod.POST)
    public String submitForm(
            @ModelAttribute("customer") @Validated Customer customer,
            BindingResult result, SessionStatus status) {


        return "createUser";
    }


}
