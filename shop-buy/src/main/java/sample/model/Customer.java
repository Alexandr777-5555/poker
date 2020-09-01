package sample.model;


import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;


/**
 * покупатель
 */
public class Customer implements Serializable {

    @Id
    @GeneratedValue
    private Long id;

    @Column(name = "FIRST_NAME")
    private String firstName;

    @Column(name = "LAST_NAME")
    private String lastName;


    @Temporal(TemporalType.DATE)
    @Column(name = "BIRTH_DATE")
    private Date birthDate;


    @OneToMany(mappedBy = "customer" ,
            cascade = CascadeType.ALL , orphanRemoval = true)
    private Set<Purchases> purchases = new HashSet<>();


    @ManyToMany
    @JoinTable(name = "customer_product" ,
    joinColumns = @JoinColumn(name = "CUSTOMER_ID"),
    inverseJoinColumns=@JoinColumn(name = "PRODUCT_ID"))
    private Set<Product> products=new HashSet<>();


    public boolean addPurchases(Purchases purchases){
        purchases.setCustomer(this);
        return getPurchases().add(purchases);
    }


    public void deletePurchases(Purchases purchases){
        getPurchases().remove(purchases);
    }


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public Date getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(Date birthDate) {
        this.birthDate = birthDate;
    }

    public Set<Purchases> getPurchases() {
        return purchases;
    }

    public void setPurchases(Set<Purchases> purchases) {
        this.purchases = purchases;
    }

    public Set<Product> getProducts() {
        return products;
    }

    public void setProducts(Set<Product> products) {
        this.products = products;
    }

    @Override
    public String toString() {
        return "Customer{" +
                "id=" + id +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", birthDate=" + birthDate +
                ", purchases=" + purchases +
                ", products=" + products +
                '}';
    }
}
