package sample.model;


import javax.persistence.*;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

@Entity
public class Product implements Serializable {

    @Id
    @Column(name = "PRODUCT_ID")
    private String productId;

    @Column(name = "PRICE")
    private double price;

    @ManyToMany
    @JoinTable(name = "customer_product" ,
            joinColumns = @JoinColumn(name = "PRODUCT_ID"),
            inverseJoinColumns=@JoinColumn(name = "CUSTOMER_ID"))
    private Set<Customer> customers=new HashSet<>();

    public String getProductId() {
        return productId;
    }

    public void setProductId(String productId) {
        this.productId = productId;
    }

    public Set<Customer> getCustomers() {
        return customers;
    }

    public void setCustomers(Set<Customer> customers) {
        this.customers = customers;
    }


    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }
}
