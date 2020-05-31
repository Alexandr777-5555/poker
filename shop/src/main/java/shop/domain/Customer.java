package shop.domain;


import javax.validation.constraints.NotNull;
import java.time.LocalDate;

public class Customer {

    /**
     * имя
     */
  private String firstName;

    /**
     * фамилия
     */
  private String lastName;


  /**
   * дата рождения
   */
  @NotNull
  private LocalDate dateOfBirth;




   




}
