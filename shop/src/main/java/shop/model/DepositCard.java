package shop.model;


import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Entity(name = "depcard")
public class DepositCard {

    @Id
    @GeneratedValue
    protected Long id;

    @NotNull
    @ManyToOne(fetch = FetchType.LAZY)
    protected Customer customer;


    public DepositCard(@NotNull Customer customer) {
        this.customer = customer;
        customer.getCards().add(this);
    }


    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }
}
