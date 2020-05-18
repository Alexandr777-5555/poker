package shop.service;

import shop.domain.products.Bread;
import shop.domain.products.Butter;
import shop.domain.products.Milk;
import shop.domain.products.Product;
import shop.domain.ShoppingCart;

import java.util.ArrayList;
import java.util.GregorianCalendar;
import java.util.List;

public class ShoppingCartServiceImpl implements ShoppingCartService {

    private List<ShoppingCart> shoppingCarts;

    public ShoppingCartServiceImpl() {
        shoppingCarts=new ArrayList<>();

        shoppingCarts.add(new ShoppingCart("Alexander" ,
                new Milk("Молоко" , 22.35) ,
                new GregorianCalendar(2020 , 20 ,14 ).getTime()));

        shoppingCarts.add(new ShoppingCart("Natalia" ,
                new Butter("Масло" , 45) ,
                new GregorianCalendar(2020 , 20 ,14 ).getTime()));


        shoppingCarts.add(new ShoppingCart("Alexander" ,
                new Bread("Хлеб" , 20.11) ,
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
