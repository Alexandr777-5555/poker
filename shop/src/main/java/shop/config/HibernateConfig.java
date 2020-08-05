package shop.config;


import org.hibernate.SessionFactory;
import org.hibernate.cfg.AvailableSettings;
import org.hibernate.dialect.PostgreSQL95Dialect;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.hibernate5.HibernateTransactionManager;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import shop.repo.CustomRepo;
import shop.repo.hibernate.HibernateCustomerRepo;

import javax.sql.DataSource;
import java.util.Properties;

@EnableTransactionManagement
@Configuration
public class HibernateConfig {

    @Bean("hibCustomer")
    CustomRepo customerRepository(SessionFactory sessionFactory) {
        return new HibernateCustomerRepo(sessionFactory);
    }

    @Bean
    public HibernateTransactionManager transactionManager(SessionFactory sessionFactory) {
        return new HibernateTransactionManager(sessionFactory);
    }

    @Bean
    public LocalSessionFactoryBean sessionFactory() {
        LocalSessionFactoryBean sessionFactoryBean = new LocalSessionFactoryBean();
        sessionFactoryBean.setDataSource(dataSource());
        sessionFactoryBean.setPackagesToScan(new String[]{"shop.model"});
        Properties props = new Properties();
        props.setProperty(AvailableSettings.DIALECT, PostgreSQL95Dialect.class.getName());
        props.setProperty(AvailableSettings.SHOW_SQL, String.valueOf(true));
        props.setProperty(AvailableSettings.HBM2DDL_AUTO, "update");
        sessionFactoryBean.setHibernateProperties(props);
        return sessionFactoryBean;
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


}
