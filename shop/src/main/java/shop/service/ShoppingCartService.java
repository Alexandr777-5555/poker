package shop.service;

import shop.domain.ShoppingCart;

import java.util.List;

public interface ShoppingCartService {

    List<ShoppingCart> query(String owner);



}
