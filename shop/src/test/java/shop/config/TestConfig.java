package shop.config;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.JpaVendorAdapter;
import org.springframework.orm.jpa.vendor.Database;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.PlatformTransactionManager;
import shop.init.DBInitializer;
import shop.repo.CustomerRepository;
import shop.repo.jpa.JpaCustomerEmRepository;
import shop.service.CustomerService;
import shop.service.impl.CustomerServiceImpl;

import javax.persistence.EntityManagerFactory;
import javax.sql.DataSource;

@Configuration
@ComponentScan
@Profile("test")
public class TestConfig {


    @Bean
    public CustomerRepository repository() {
        return new JpaCustomerEmRepository();
    }


    @Bean
    public DBInitializer dbInitializer() {
        return new DBInitializer();
    }


    @Bean
    public CustomerService service() {
        return new CustomerServiceImpl(repository());
    }

    @Bean
    public DataSource dataSource() {
        DriverManagerDataSource dataSource = new DriverManagerDataSource();
        dataSource.setDriverClassName(org.postgresql.Driver.class.getName());
        dataSource.setUrl("jdbc:postgresql://localhost:5432/shop");
        dataSource.setUsername("postgres");
        dataSource.setPassword("777");
        return dataSource;
    }

    @Bean
    public JpaVendorAdapter jpaVendorAdapter() {
        HibernateJpaVendorAdapter bean = new HibernateJpaVendorAdapter();
        bean.setDatabase(Database.POSTGRESQL);
        bean.setGenerateDdl(true);
        bean.setShowSql(true);

        return bean;
    }


    @Bean
    public PlatformTransactionManager transactionManager(EntityManagerFactory entityManagerFactory) {
        JpaTransactionManager transactionManager = new JpaTransactionManager();
        transactionManager.setEntityManagerFactory(entityManagerFactory);
        return transactionManager;
    }


}
