package shop.service.config;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import shop.service.ShoppingCartService;
import shop.service.ShoppingCartServiceImpl;

@Configuration
public class ServiceConfigure {

    @Bean
    public ShoppingCartService cartService(){
        return new ShoppingCartServiceImpl();
    }


    
}
