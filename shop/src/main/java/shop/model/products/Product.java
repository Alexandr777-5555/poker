package shop.model.products;

/**
 *
 * продукт
 *
 */

public abstract class Product {

    /**
     * название
     */
    private String name;

    /**
     * цена
     */
    private double price;

    public Product() {
    }

    public Product(String name, double price) {
        this.name = name;
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return name;
    }


}
