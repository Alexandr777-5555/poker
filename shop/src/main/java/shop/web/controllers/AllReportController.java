package shop.web.controllers;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import shop.domain.Customer;
import shop.service.ShoppingCartService;
import shop.web.view.PdfReport;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
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


    @PostMapping()
    public String showPDF(@RequestParam("bydate") String date) {
        log.info("showPDF " + date);
        return "report";
    }


   // @RequestMapping(value = "/rep", method = RequestMethod.GET)
    @RequestMapping(value = "/" , method = RequestMethod.GET)
    public ModelAndView list(HttpServletRequest request, HttpServletResponse response) {
        String typeReport = request.getParameter("bydate");
        List<Customer> list = new ArrayList<>();
        list.add(new Customer());
        list.add(new Customer());
        list.add(new Customer());
        if (typeReport != null) {
            log.info("not null");
            return new ModelAndView("report", "customers" , list );
        }
        return new ModelAndView("report", "customers" , list );
    }

}
