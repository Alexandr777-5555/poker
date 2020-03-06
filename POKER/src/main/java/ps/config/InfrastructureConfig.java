package ps.config;


import org.hibernate.SessionFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseBuilder;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseType;
import org.springframework.orm.hibernate5.HibernateTransactionManager;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.sql.DataSource;
import java.util.Properties;

@Configuration
@EnableTransactionManagement // активизировать возможность управления транзакциями  фреймворка Spring посредством аннотации
public class InfrastructureConfig {


    @Bean
    public DataSource dataSource(){
        EmbeddedDatabaseBuilder builder = new EmbeddedDatabaseBuilder().setType(EmbeddedDatabaseType.H2);//in-memory
        builder.addScript("schema.sql");
      //  builder.addScript("data.sql");
        return builder.build();
    }


    /**
     *
     * @param dataSource
     * @return
     */
    @Bean
    public LocalSessionFactoryBean sessionFactory(DataSource dataSource) {
        //генерирует в приложении объект SessionFactory
        //в виде компонента с помощью класса LocalSessionFactoryBean фреймворка Spring
        LocalSessionFactoryBean sfb = new LocalSessionFactoryBean();
        //Метод этого компонента принимает на входе объект типа DataSource в качестве аргумента, который
        //определяет место и способ соединения с базой данных
        sfb.setDataSource(dataSource);
        //какой пакет просматривать
        sfb.setPackagesToScan(new String[] { "ps.model" });
        Properties props = new Properties();
        props.setProperty("dialect", "org.hibernate.dialect.H2Dialect");
        //задали свойство dialect компонента SessionFactory с помощью метода
        // setHibernateProperties для указания того,
        // с каким типом базы данных мы имеем дело в приложении
        sfb.setHibernateProperties(props);
        return sfb;
    }

    /**
     * реализация диспетчера транзакций
     * @param sessionFactory
     * @return
     */
    @Bean //implementation
    public PlatformTransactionManager transactionManager(SessionFactory sessionFactory){
        return new HibernateTransactionManager(sessionFactory);
    }



}
