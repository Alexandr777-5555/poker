package shop.model;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

/**
 * цена за единицу товара
 */
@Entity
public class Cost implements Serializable {

    @Id
    @Column(name = "COST_ID")
    private String noNumber;


    @ManyToMany
    @JoinTable(name = "product_cost",
            joinColumns = @JoinColumn(name = "COST_ID"),
            inverseJoinColumns = @JoinColumn(name = "ITEM_ID"))
    private Set<Item> items = new HashSet<>();


    @NotNull
    private double price;

    @Column(updatable = false)
    //  @Temporal(TemporalType.DATE) // что бы дата преобразовалсь в SQL , дает возможность
    // получить доступ
    @org.hibernate.annotations.CreationTimestamp
    private Date createdOn;


    public String getNoNumber() {
        return noNumber;
    }

    public void setNoNumber(String noNumber) {
        this.noNumber = noNumber;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public Date getCreatedOn() {
        return createdOn;
    }

    public Set<Item> getItems() {
        return items;
    }

    public void setItems(Set<Item> items) {
        this.items = items;
    }
}
