package shop.model;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

@Entity
@NamedQueries({
        @NamedQuery(name="Item.findAllWithCost" ,
                query = "select DISTINCT i from Item i " +
                        "left JOIN fetch  i.costs c")
})
public class Item implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private long id;


    @NotNull
    @Column(name = "ITEM_ID")
    private String noNumber;

    @NotNull
    private String name;

    @ManyToMany
    @JoinTable(name = "product_cost",
            joinColumns = @JoinColumn(name = "ITEM_ID"),
            inverseJoinColumns = @JoinColumn(name = "COST_ID"))
    private Set<Cost> costs = new HashSet<>();


    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }


    public String getNoNumber() {
        return noNumber;
    }

    public void setNoNumber(String noNumber) {
        this.noNumber = noNumber;
    }

    public Set<Cost> getCosts() {
        return costs;
    }

    public void setCosts(Set<Cost> costs) {
        this.costs = costs;
    }


    @Override
    public String toString() {
        return "Item{" +
                "id=" + id +
                ", noNumber='" + noNumber + '\'' +
                ", name='" + name + '\'' +
                '}';
    }
}
