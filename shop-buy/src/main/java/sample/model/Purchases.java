package sample.model;

import javax.persistence.*;
import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.Date;

import static javax.persistence.GenerationType.IDENTITY;

/**
 * класс покупки
 *
 */
@Entity
public class Purchases implements Serializable{

    @Id
    @GeneratedValue(strategy = IDENTITY)
    @Column(name = "ID")
    private Long id;

    @Temporal(TemporalType.DATE)
    @Column(name = "BUY_DATE")
    private Date buy;

    @ManyToOne
    @JoinColumn(name = "CUSTOMER_ID")
    private Customer customer;


    @Column(name = "PRODUCT")
    private String productId;

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Date getBuy() {
        return buy;
    }

    public void setBuy(Date buy) {
        this.buy = buy;
    }

    public String getProductId() {
        return productId;
    }

    public void setProductId(String productId) {
        this.productId = productId;
    }

    @Override
    public String toString() {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        return "Purchases{" +
                "id=" + id +
                ", buy date=" +  sdf.format(buy) +
                ", customer=" + customer.getFirstName() +
                '}';
    }
}
