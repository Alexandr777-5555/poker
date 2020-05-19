package shop.service;

import shop.domain.products.*;
import shop.domain.ShoppingCart;

import java.util.ArrayList;
import java.util.GregorianCalendar;
import java.util.List;
import java.util.Objects;

public class ShoppingCartServiceImpl implements ShoppingCartService {

    private List<ShoppingCart> shoppingCarts;

    public ShoppingCartServiceImpl() {
        shoppingCarts = new ArrayList<>();

        shoppingCarts.add(new ShoppingCart("Alexander",
                FactoryProduct.create("молоко", 22.35),
                new GregorianCalendar(2020, 20, 14).getTime()));

        shoppingCarts.add(new ShoppingCart("Natalia",
                FactoryProduct.create("масло", 45),
                new GregorianCalendar(2020, 20, 14).getTime()));


        shoppingCarts.add(new ShoppingCart("Alexander",
                FactoryProduct.create("хлеб", 20.11),
                new GregorianCalendar(2020, 20, 15).getTime()));
    }

    @Override
    public List<ShoppingCart> query(String owner) {
        if (owner==null){
            throw new IllegalArgumentException("this null");
        }
        List<ShoppingCart> result = new ArrayList<>();
        for (ShoppingCart cart : shoppingCarts) {
            if (cart.getOwner().equals(owner)) {
                result.add(cart);
            }
        }
        return result;

    }

    @Override
    public double totalValue(String owner) {
        if (owner==null){
            throw new IllegalArgumentException("this null");
        }
        double amount=0;
        for (ShoppingCart cart:shoppingCarts){
            if(cart.getOwner().equals(owner)){
               amount+=cart.getProduct().getPrice();
            }
        }
        return amount;
    }


}
