package shop.service;

import shop.domain.ShoppingCart;

import java.time.LocalDate;
import java.util.List;

public interface ShoppingCartService {

    List<ShoppingCart> query(String owner);

    /**
     * общая сумма покупок по карте
     * @param owner
     * @return
     */
    double totalValue(String owner);

    /**
     *  список корзины покупок по дате
     * @param date
     * @return
     */
    List<ShoppingCart> findByDate(LocalDate date);






}
