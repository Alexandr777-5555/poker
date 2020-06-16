package shop.web.controllers;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import shop.domain.Customer;
import shop.domain.ShoppingCart;
import shop.service.ShoppingCartService;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;


@Controller
@RequestMapping("/all_reports")
public class AllReportController {

    private final Logger log = LoggerFactory.getLogger(this.getClass());

    private final ShoppingCartService cartService;

    public AllReportController(ShoppingCartService cartService) {
        this.cartService = cartService;
    }

    @GetMapping
    public void setupForm() {
    }

    @PostMapping
    public String submitForm(@RequestParam("bydate") String selectedDate, Model model) {
        log.info("method submitForm " + selectedDate);
        LocalDate localDate=LocalDate.parse(selectedDate);
        List<ShoppingCart> list = cartService.findByDate(localDate);
        if(list!=null){
            log.info("data ");
        }
        // model.addAttribute("shopcarts", list);
        return "report";
    }


}
