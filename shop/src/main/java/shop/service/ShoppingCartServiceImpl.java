package shop.service;

import shop.domain.Product;
import shop.domain.ShoppingCart;

import java.util.ArrayList;
import java.util.GregorianCalendar;
import java.util.List;

public class ShoppingCartServiceImpl implements ShoppingCartService {

    private List<ShoppingCart> shoppingCarts;

    public ShoppingCartServiceImpl() {
        shoppingCarts=new ArrayList<>();

        shoppingCarts.add(new ShoppingCart("Alexander" ,
                new Product("Молоко" , 22.35) ,
                new GregorianCalendar(2020 , 20 ,14 ).getTime()));

        shoppingCarts.add(new ShoppingCart("Natalia" ,
                new Product("Food" , 45) ,
                new GregorianCalendar(2020 , 20 ,14 ).getTime()));


        shoppingCarts.add(new ShoppingCart("Alexander" ,
                new Product("Хлеб" , 20.11) ,
                new GregorianCalendar(2020 , 20 ,15 ).getTime()));
    }

    @Override
    public List<ShoppingCart> query(String owner) {
        List<ShoppingCart> result=new ArrayList<>();
        for(ShoppingCart cart:shoppingCarts){
            if(cart.getOwner().equals(owner)){
                result.add(cart);
            }
        }
        return result;
    }





}
