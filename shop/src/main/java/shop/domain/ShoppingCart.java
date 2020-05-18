package shop.domain;


import shop.domain.products.Product;

import java.util.Date;

/***
 *
 * корзина покупок
 *
 */

public class ShoppingCart {


    private String owner;
    private Product product;
    private Date date;

    public ShoppingCart() {
    }

    public ShoppingCart(String owner, Product product, Date date) {
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

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }


}
