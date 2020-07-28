package shop.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import shop.model.ShoppingCart;
import shop.model.products.FactoryProduct;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Configuration
public class ShoppingCartConfig {


    @Bean
    public List<ShoppingCart> shoppingCarts() {
        return new ArrayList<ShoppingCart>(Arrays.asList(pay1(), pay2(), pay3(), pay4()));
    }


    @Bean
    public ShoppingCart pay1() {
        return new ShoppingCart("Alexander",
                FactoryProduct.create("milk", 22.35),
                LocalDate.of(2020, 05, 2));
    }

    @Bean
    public ShoppingCart pay2() {
        return new ShoppingCart("Alexander",
                FactoryProduct.create("milk", 33.50),
                LocalDate.of(2020, 05, 2));
    }

    @Bean
    public ShoppingCart pay3() {
        return new ShoppingCart("Alexander",
                FactoryProduct.create("bread", 20.11),
                LocalDate.of(2020, 06, 3));
    }

    @Bean
    public ShoppingCart pay4() {

        return new ShoppingCart("Natalia",
                FactoryProduct.create("butter", 45),
                LocalDate.of(2020, 06, 2));
    }

}