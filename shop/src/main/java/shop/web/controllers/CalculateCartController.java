package shop.web.controllers;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import shop.service.ShoppingCartService;

@Controller
@RequestMapping("/calculateCart")
public class CalculateCartController {

    private final ShoppingCartService cartService;


    public CalculateCartController(ShoppingCartService cartService) {
        this.cartService = cartService;
    }

    @GetMapping
    public void defaultForm() {
    }


    @RequestMapping(method = RequestMethod.POST)
    public String submitForm(@RequestParam("calc") String owner, Model model) {
        double totalValue=0;
        if(owner!=null) {
             totalValue= cartService.totalValue(owner);
        }
        model.addAttribute("total" , totalValue);
        return "calculateCart";
    }



}


