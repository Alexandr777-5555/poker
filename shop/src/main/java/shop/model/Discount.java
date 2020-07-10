package shop.model;


import javax.persistence.*;

/**
 *
 * скидка для покупателя
 *
 */

@Entity
@org.hibernate.annotations.Immutable
public class Discount {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;


    @ManyToOne(optional = false , fetch = FetchType.LAZY)
    @JoinColumn(name = "Customer_id")
    protected Customer customer;


    public long getId() {
        return id;
    }


    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }
}
