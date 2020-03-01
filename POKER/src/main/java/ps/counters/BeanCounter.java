package ps.counters;

import org.aspectj.lang.annotation.Aspect;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanFactoryPostProcessor;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


/**
 *
 * записывает количество компонентов, загруженных в фабрику компонентов.
 *
 */

public class BeanCounter implements BeanFactoryPostProcessor {

    private Logger LOGGER= LoggerFactory.getLogger(BeanCounter.class);

    @Override
    public void postProcessBeanFactory(ConfigurableListableBeanFactory factory) throws BeansException {

        LOGGER.info("Bean count " + factory.getBeanDefinitionCount() );


    }
}
