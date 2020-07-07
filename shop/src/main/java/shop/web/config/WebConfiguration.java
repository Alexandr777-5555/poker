package shop.web.config;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ViewResolverRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.view.InternalResourceViewResolver;
import org.springframework.web.servlet.view.JstlView;
import org.springframework.web.servlet.view.tiles3.TilesConfigurer;
import org.springframework.web.servlet.view.tiles3.TilesViewResolver;

@Configuration
@EnableWebMvc
@ComponentScan("shop")
public class WebConfiguration  implements WebMvcConfigurer {

   // @Bean
    public ViewResolver internalResourceViewResolver() {
        InternalResourceViewResolver viewResolver = new InternalResourceViewResolver();
        viewResolver.setPrefix("/WEB-INF/jsp/");
        viewResolver.setSuffix(".jsp");
        viewResolver.setOrder(2);
        return viewResolver;
    }

//    @Bean
//    public ViewResolver internalResourceViewResolverTiles() {
//        InternalResourceViewResolver viewResolver = new InternalResourceViewResolver();
//       // viewResolver.setViewClass(JstlView.class);
//        viewResolver.setPrefix("/WEB-INF/views/tiles/pages/");
//     //   viewResolver.setPrefix("/WEB-INF/views/tiles/");
//        viewResolver.setSuffix(".jsp");
//     //   viewResolver.setOrder(1);
//        return viewResolver;
//    }

    @Override
    public void configureViewResolvers(ViewResolverRegistry registry) {
        TilesViewResolver viewResolver = new TilesViewResolver();
        registry.viewResolver(viewResolver);
        InternalResourceViewResolver bean = new InternalResourceViewResolver();
        bean.setViewClass(JstlView.class);
        bean.setPrefix("/WEB-INF/views/tiles/pages/");
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



}
