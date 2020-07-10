package shop.model;


import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;


/**
 * покупатель
 */
@Entity
public class Customer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToMany
    protected Set<DepositCard> cards = new HashSet<DepositCard>();


    /**
     * имя
     */
    @NotNull
    @Size(min = 3 ,
            max = 7 ,
            message = "firstName is required"
    )
    private String firstName;

    /**
     * фамилия
     */
    private String lastName;


    /**
     * дата рождения
     */
    @NotNull
    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
    private LocalDate dateOfBirth;


    public void addCard(DepositCard card) throws Exception {
        if (card == null) {
            throw new NullPointerException("can't add null card");
        }
        if(cards.contains(card)){
            throw new Exception("card exists");
        }

        cards.add(card);
        card.setCustomer(this);
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

    public LocalDate getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(LocalDate dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public Set<DepositCard> getCards() {
        return cards;
    }

    public void setCards(Set<DepositCard> cards) {
        this.cards = cards;
    }


}