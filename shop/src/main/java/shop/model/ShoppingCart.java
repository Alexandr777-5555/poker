package shop.model;


import org.springframework.format.annotation.DateTimeFormat;
import shop.model.products.Product;

import java.time.LocalDate;

/***
 *
 * корзина покупок
 *
 */

public class ShoppingCart {


    private String owner;
    private Product product;
    @DateTimeFormat(pattern="yyyy-MM-dd")
    private LocalDate date;

    public ShoppingCart() {
    }

    public ShoppingCart(String owner, Product product, LocalDate date) {
        this.owner = owner;
        this.product = product;
        this.date = date;
    }


    public String getOwner() {
        return owner;
    }

    public void setOwner(String owner) {
        this.owner = owner;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }



}
