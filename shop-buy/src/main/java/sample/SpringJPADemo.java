package sample;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import sample.config.JpaConfig;
import sample.model.Customer;
import sample.service.CustomerService;

import java.util.List;

public class SpringJPADemo {

    public static void main(String[] args) {

        ApplicationContext context=new AnnotationConfigApplicationContext(JpaConfig.class);

        CustomerService customerService =  context.getBean(CustomerService.class);

        List<Customer> customers = customerService.findAll();
        for(Customer customer : customers) {
            System.out.println(customer);
        }


    }
}
