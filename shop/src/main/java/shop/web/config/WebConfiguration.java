package shop.web.config;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.ViewResolverRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.view.InternalResourceViewResolver;
import org.springframework.web.servlet.view.JstlView;
import org.springframework.web.servlet.view.tiles3.TilesConfigurer;
import org.springframework.web.servlet.view.tiles3.TilesViewResolver;

@Configuration
@EnableWebMvc
@ComponentScan(basePackages = {"shop.config" , "shop.repo"
        , "shop.service.impl", "shop.web.controllers" , "shop.model" } )
public class WebConfiguration  implements WebMvcConfigurer {

    @Override
    public void configureViewResolvers(ViewResolverRegistry registry) {
        TilesViewResolver viewResolver = new TilesViewResolver();
        registry.viewResolver(viewResolver);
        InternalResourceViewResolver bean = new InternalResourceViewResolver();
        bean.setViewClass(JstlView.class);
        bean.setPrefix("/WEB-INF/views/tiles/pages/");
        bean.setPrefix("/WEB-INF/jsp/");
        bean.setSuffix(".jsp");
        registry.viewResolver(bean);
    }

    @Bean
    public TilesConfigurer tilesConfigurer() {
        TilesConfigurer tilesConfigurer = new TilesConfigurer();
         tilesConfigurer.setDefinitions(new String[] { "/WEB-INF/views/tiles/tiles.xml" });
        tilesConfigurer.setCheckRefresh(true);
        return tilesConfigurer;
    }


    @Override
    public void addViewControllers(ViewControllerRegistry registry) {
     registry.addViewController("/").setViewName("hello");
     registry.addViewController("/listCustomer").setViewName("listCustomer");
    }
}
