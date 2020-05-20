package shop.web.controllers;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import shop.domain.ShoppingCart;
import shop.service.ShoppingCartService;

import java.util.Collections;
import java.util.List;

@Controller
@RequestMapping("/shopCart")
public class ShoppingCartController {

    private final ShoppingCartService cartService;

    public ShoppingCartController(ShoppingCartService cartService) {
        this.cartService = cartService;
    }


    @RequestMapping(method = RequestMethod.GET)
    public void defaultForm() {
    }

    @RequestMapping(method = RequestMethod.POST)
    public String submitForm(@RequestParam("owner") String owner, Model model) {
        List<ShoppingCart> cartList = Collections.emptyList();
        if (owner != null) {
            cartList = cartService.query(owner);
        }
        model.addAttribute("shopping", cartList);
        return "shopCart";
    }

}
