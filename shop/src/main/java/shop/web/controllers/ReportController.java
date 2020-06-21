package shop.web.controllers;


import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import shop.domain.ShoppingCart;
import shop.service.ShoppingCartService;

import java.time.LocalDate;
import java.util.List;

@Controller
@RequestMapping("/report")
public class ReportController {

    private final ShoppingCartService cartService;

    public ReportController(ShoppingCartService cartService) {
        this.cartService = cartService;
    }


    @GetMapping
    public String report(
            @RequestParam(required = true, value = "date")
            @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate selectedDate,
            Model model) {
        List<ShoppingCart> list = cartService.findByDate(selectedDate);
        model.addAttribute("shopcarts", list);
        return "report";
    }






}
