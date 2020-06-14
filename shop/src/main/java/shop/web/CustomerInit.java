package shop.web;


import org.springframework.stereotype.Component;
import shop.domain.Customer;
import shop.service.CustomerService;

import javax.annotation.PostConstruct;

@Component
public class CustomerInit {

    private final CustomerService service;

    public CustomerInit(CustomerService service) {
        this.service = service;
    }

    @PostConstruct
    public void setup() {
        Customer customer = new Customer();
       // customer.setId(1);
        customer.setFirstName("Alex");
        customer.setLastName("Avd");
        service.save(customer);

        customer=new Customer();
       // customer.setId(2);
        customer.setFirstName("AAA");
        customer.setLastName("BBB");
        service.save(customer);
    }
}
