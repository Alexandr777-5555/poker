package sample.model;

import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

/**
 * класс покупки
 *
 */
public class Purchases {




    @ManyToOne
    @JoinColumn(name = "CUSTOMER_ID")
    private Customer customer;


    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }
}
