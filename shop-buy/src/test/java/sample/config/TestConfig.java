package sample.config;


import org.hibernate.SessionFactory;
import org.hibernate.cfg.AvailableSettings;
import org.hibernate.dialect.PostgreSQL95Dialect;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.hibernate5.HibernateTransactionManager;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import org.springframework.orm.jpa.JpaVendorAdapter;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import sample.repository.CustomerRepository;
import sample.repository.impl.CustomerRepositoryImpl;
import sample.service.CustomerService;
import sample.service.impl.CustomerServiceImpl;

import javax.sql.DataSource;
import java.util.Properties;

@Profile("test")
@Configuration
@ComponentScan
public class TestConfig {


    @Bean
    CustomerRepository customerRepository() {
        return new CustomerRepositoryImpl();
    }


    @Bean
    CustomerService customerService() {
        return new CustomerServiceImpl(customerRepository());
    }


    @Bean
    public DataSource dataSource() {
        DriverManagerDataSource dataSource = new DriverManagerDataSource();
        dataSource.setDriverClassName(org.postgresql.Driver.class.getName());
        dataSource.setUrl("jdbc:postgresql://localhost:5432/samples");
        dataSource.setUsername("postgres");
        dataSource.setPassword("777");
        return dataSource;
    }

    @Bean
    public JpaVendorAdapter jpaVendorAdapter() {
        return new HibernateJpaVendorAdapter();
    }

    @Bean
    public LocalSessionFactoryBean sessionFactory() {
        LocalSessionFactoryBean sessionFactoryBean = new LocalSessionFactoryBean();
        sessionFactoryBean.setDataSource(dataSource());
        sessionFactoryBean.setPackagesToScan(new String[]{"sample.model"});
        Properties props = new Properties();
        props.setProperty(AvailableSettings.DIALECT, PostgreSQL95Dialect.class.getName());
        props.setProperty(AvailableSettings.SHOW_SQL, String.valueOf(true));
        props.setProperty(AvailableSettings.HBM2DDL_AUTO, "create-drop");
        // props.setProperty(AvailableSettings.HBM2DDL_AUTO, "update");
        //  props.setProperty(AvailableSettings.HBM2DDL_AUTO, "create");
        sessionFactoryBean.setHibernateProperties(props);
        return sessionFactoryBean;
    }

    @Bean
    public HibernateTransactionManager transactionManager(SessionFactory sessionFactory) {
        return new HibernateTransactionManager(sessionFactory);
    }


}
