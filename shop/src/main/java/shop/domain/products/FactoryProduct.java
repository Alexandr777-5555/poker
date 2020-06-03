package shop.domain.products;

public class FactoryProduct {

    public static Product create(String name, double price) {
        if (name.equals("milk")) {
            return new Milk(name, price);
        }
        if (name.equals("butter")) {
            return new Butter(name, price);
        }
        if(name.equals("bread")){
            return new Bread(name,price);
        }
            throw new IllegalArgumentException("no product");
    }


}
