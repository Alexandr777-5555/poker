package shop.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import shop.model.ShoppingCart;
import shop.service.ShoppingCartService;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

@Service
public class ShoppingCartServiceImpl implements ShoppingCartService {

    @Autowired
    private List<ShoppingCart> shoppingCarts;

    @Override
    public List<ShoppingCart> query(String owner) {
        if (owner == null) {
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
        if (owner == null) {
            throw new IllegalArgumentException("this null");
        }
        double amount = 0;
        for (ShoppingCart cart : shoppingCarts) {
            if (cart.getOwner().equals(owner)) {
                amount += cart.getProduct().getPrice();
            }
        }
        return amount;
    }

    @Override
    public List<ShoppingCart> findByDate(LocalDate date) {
        return shoppingCarts
                .stream()
                .filter(cart -> Objects.equals(cart.getDate(), date))
                .collect(Collectors.toList());
    }

}
