package shop.model;


import javax.persistence.Entity;
import javax.persistence.Id;




@org.hibernate.annotations.Synchronize({"Customer", "Discount"})
@Entity
public class CustomerDiscountSummary {

    @Id
    private Long id;







}
