package shop.domain.products;

public class FactoryProduct {

    public static Product create(String name, double price) {
        if (name.equals("молоко")) {
            return new Milk(name, price);
        }
        if (name.equals("масло")) {
            return new Butter(name, price);
        }
        if(name.equals("хлеб")){
            return new Bread(name,price);
        }
            throw new IllegalArgumentException("no product");
    }


}
