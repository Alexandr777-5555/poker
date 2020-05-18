package shop.service;

import org.junit.Before;
import org.junit.Test;
import shop.domain.ShoppingCart;

import java.util.List;

import static org.junit.Assert.*;

/**
 * тестируем функциональность класса {@link ShoppingCartServiceImpl}
 */

public class ShoppingCartServiceImplTest {

    private ShoppingCartService cartService;

    @Before
    public void setup(){
        cartService=new ShoppingCartServiceImpl();
    }

    @Test
    public void query() {
        List<ShoppingCart> alexander = cartService.query("Alexander");
        assertEquals(2 , alexander.size());
    }

}