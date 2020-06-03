package shop.web.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.view.ResourceBundleViewResolver;


@Configuration
public class ViewResolverConfig implements WebMvcConfigurer {







    @Bean
    public ViewResolver pdfViewResolver() {
        ResourceBundleViewResolver viewResolver = new ResourceBundleViewResolver();
        viewResolver.setOrder(0);
        viewResolver.setBasename("report");
        return viewResolver;
    }


}
