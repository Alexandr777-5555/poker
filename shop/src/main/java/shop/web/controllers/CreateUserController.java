package shop.web.controllers;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.support.SessionStatus;
import shop.domain.Customer;

@Controller
@RequestMapping("/createUser")
@SessionAttributes("customer")
public class CreateUserController {


    @GetMapping
    public void setupForm(Model model) {
       Customer customer=new Customer();
       model.addAttribute("customer" , customer);
    }




    @RequestMapping(method = RequestMethod.POST)
    public String submitForm(
            @ModelAttribute("customer") @Validated Customer customer,
            BindingResult result, SessionStatus status) {


        return "createUser";
    }


}
