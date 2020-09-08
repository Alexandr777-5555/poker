package sample.view;


import java.io.Serializable;

public class CustomerSummary implements Serializable {

    private String firstName;
    private String lastName;
    private String productId;

    public CustomerSummary(String firstName, String lastName, String productId) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.productId = productId;
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

    public String getProductId() {
        return productId;
    }

    public void setProductId(String productId) {
        this.productId = productId;
    }

    @Override
    public String toString() {
        return "CustomerSummary{" +
                "firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", productId='" + productId + '\'' +
                '}';
    }
}
