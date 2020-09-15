package sample.model;


import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import static javax.persistence.GenerationType.IDENTITY;


/**
 * покупатель
 */
@Entity
@NamedQueries({
        @NamedQuery(name = Customer.FIND_ALL, query = "select c from Customer c"),
        @NamedQuery(name = Customer.FIND_ALL_WITH_PURCHASES ,
                query = "select distinct c from Customer c " +
                        "left join fetch c.purchases pu " +
                        "left join fetch c.products pr"),
        @NamedQuery(name = Customer.FIND_CUSTOMER_BY_ID ,
                query = "select distinct c from Customer c " +
                        "left join fetch c.purchases p " +
                        "left join fetch c.products pro " +
                        "where c.id=:id")
})
public class Customer implements Serializable {

    public static final String FIND_ALL = "Customer.findAll";
    public static final String FIND_CUSTOMER_BY_ID="Customer.findById";
    public static final String FIND_ALL_WITH_PURCHASES = "Customer.findAllWithPurchases";

    @Id
    @GeneratedValue(strategy = IDENTITY)
    @Column(name = "ID")
    private Long id;

    @Column(name = "FIRST_NAME")
    private String firstName;

    @Column(name = "LAST_NAME")
    private String lastName;


    @Temporal(TemporalType.DATE)
    @Column(name = "BIRTH_DATE")
    private Date birthDate;


    @OneToMany(mappedBy = "customer",
            cascade = CascadeType.ALL, orphanRemoval = true)
    private Set<Purchases> purchases = new HashSet<>();


    @ManyToMany
    @JoinTable(name = "customer_product",
            joinColumns = @JoinColumn(name = "CUSTOMER_ID"),
            inverseJoinColumns = @JoinColumn(name = "PRODUCT_ID"))
    private Set<Product> products = new HashSet<>();


    public boolean addPurchases(Purchases purchases) {
        purchases.setCustomer(this);
        return getPurchases().add(purchases);
    }


    public void deletePurchases(Purchases purchases) {
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
