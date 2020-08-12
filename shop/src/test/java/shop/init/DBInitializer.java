package shop.init;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import shop.model.Customer;
import shop.repo.CustomerRepository;

import javax.annotation.PostConstruct;
import java.time.LocalDate;

public class DBInitializer {

    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private CustomerRepository repository;


    @PostConstruct
    public void initDB() {
        logger.info("Starting database initialization...");

        Customer customer=new Customer();
        customer.setFirstName("Alexander");
        customer.setLastName("AVDEEV");
        customer.setDateOfBirth(LocalDate.of(1982, 6, 23));
        repository.create(customer);

        customer=new Customer();
        customer.setFirstName("Natalia");
        customer.setLastName("My");
        customer.setDateOfBirth(LocalDate.of(2020, 1, 13));
        repository.create(customer);

        customer=new Customer();
        customer.setFirstName("Elena");
        customer.setLastName("Kus");
        customer.setDateOfBirth(LocalDate.of(2020, 8, 11));
        repository.create(customer);


        logger.info("Database initialization finished.");

    }

}
