package shop.config;


import org.hibernate.cfg.AvailableSettings;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseBuilder;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseType;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.JpaVendorAdapter;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.PlatformTransactionManager;

import javax.persistence.EntityManagerFactory;
import javax.sql.DataSource;
import java.util.Properties;

@Configuration
public class JpaConfig {

//    @Bean
//    public CustomerRepository jpaCustomerRepository(EntityManagerFactory emf) {
//        return new JpaCustomerRepo(emf);
//    }

//    @Bean
//    public LocalEntityManagerFactoryBean emf() {
//        LocalEntityManagerFactoryBean bean = new LocalEntityManagerFactoryBean();
//        bean.setPersistenceUnitName("jparepo");
//        bean.setDataSource(dataSource);
//        bean.setJpaVendorAdapter(jpaVendorAdapter());
//
//        return bean;
//    }

//    @Bean
//    public LocalContainerEntityManagerFactoryBean
//    emf(DataSource dataSource) {
//        LocalContainerEntityManagerFactoryBean emf =
//                new LocalContainerEntityManagerFactoryBean();
//      //  emf.setPersistenceUnitName("jparepo");
//        emf.setDataSource(dataSource);
//        emf.setJpaVendorAdapter(jpaVendorAdapter());
//        return emf;
//    }
//
//    private JpaVendorAdapter jpaVendorAdapter() {
//        HibernateJpaVendorAdapter jpaVendorAdapter = new HibernateJpaVendorAdapter();
//        jpaVendorAdapter.setShowSql(true);
//        jpaVendorAdapter.setGenerateDdl(true);
//        jpaVendorAdapter.setDatabasePlatform(PostgreSQL95Dialect.class.getName());
//        return jpaVendorAdapter;
//    }
//
//
//    @Bean
//    public DataSource dataSource() {
//        HikariDataSource dataSource = new HikariDataSource();
//       // dataSource.setUsername("postgres");
//        dataSource.setUsername("");
//        dataSource.setPassword("777");
//        dataSource.setJdbcUrl("jdbc:postgresql://localhost:5432/shop");
//        dataSource.setMinimumIdle(2);
//        dataSource.setMaximumPoolSize(5);
//        return dataSource;
//    }
//
//
//    @Bean
//    public JpaTransactionManager transactionManager(EntityManagerFactory emf) {
//        return new JpaTransactionManager(emf);
//    }


    @Bean
    public DataSource dataSource(){
        EmbeddedDatabaseBuilder builder = new EmbeddedDatabaseBuilder()
                .setType(EmbeddedDatabaseType.H2);//in-memory
       // builder.addScript("schema.sql");
       // builder.addScript("data.sql");
        return builder.build();
    }


    @Bean
    public JpaVendorAdapter jpaVendorAdapter() {
        HibernateJpaVendorAdapter bean = new HibernateJpaVendorAdapter();
        bean.setDatabase(org.springframework.orm.jpa.vendor.Database.H2);
        bean.setGenerateDdl(true);
        return bean;
    }

    @Bean
    public LocalContainerEntityManagerFactoryBean entityManagerFactory(
            DataSource dataSource, JpaVendorAdapter jpaVendorAdapter) {
        LocalContainerEntityManagerFactoryBean bean = new LocalContainerEntityManagerFactoryBean();
        bean.setDataSource(dataSource);
        bean.setJpaVendorAdapter(jpaVendorAdapter);
        bean.setPackagesToScan("shop");
        Properties props = new Properties();
        props.setProperty("dialect",
                "org.hibernate.dialect.H2Dialect");
        props.setProperty(AvailableSettings.SHOW_SQL, String.valueOf(true));
        props.setProperty(AvailableSettings.HBM2DDL_AUTO, "update");
        bean.setJpaProperties(props);
        return bean;
    }

    @Bean
    public PlatformTransactionManager transactionManager(EntityManagerFactory entityManagerFactory) {
        JpaTransactionManager transactionManager = new JpaTransactionManager();
        transactionManager.setEntityManagerFactory(entityManagerFactory);
        return transactionManager;
    }

}
