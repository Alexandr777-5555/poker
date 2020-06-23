package shop.config;


import org.hibernate.SessionFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseBuilder;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseType;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import shop.domain.Customer;
import shop.repo.CustomerRepository;
import shop.repo.hibernate.HibernateCustomerRepo;

import javax.sql.DataSource;
import java.util.Properties;

@Configuration
public class HibernateConfig {


    @Bean("hibCustomer")
    CustomerRepository customerRepository(SessionFactory sessionFactory) {
        return new HibernateCustomerRepo(sessionFactory);
    }


    @Bean
    public LocalSessionFactoryBean sessionFactory() {
        LocalSessionFactoryBean sessionFactoryBean = new LocalSessionFactoryBean();
        sessionFactoryBean.setDataSource(dataSource());
        sessionFactoryBean.setAnnotatedClasses(Customer.class);
        Properties props = new Properties();
        props.setProperty("dialect",
                "org.hibernate.dialect.H2Dialect");
        sessionFactoryBean.setHibernateProperties(props);

        return sessionFactoryBean;
    }


    @Bean
    public DataSource dataSource() {
        return new EmbeddedDatabaseBuilder()
                .setType(EmbeddedDatabaseType.H2)
                .setName("shop")
                .addScript("classpath:/schema.sql")
                .build();
    }

}
