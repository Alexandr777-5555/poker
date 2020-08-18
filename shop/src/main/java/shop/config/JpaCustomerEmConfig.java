package shop.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.context.annotation.Profile;

@Configuration
@Profile("jpaCustomerEmRepository")
@Import(value = AppConfig.class)
public class JpaCustomerEmConfig {

}
