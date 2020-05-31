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
}
