package shop.web.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import shop.web.PDFInterceptor;
import shop.web.TimeInterceptor;


@Configuration
public class InterceptConfig implements WebMvcConfigurer {


    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(timeInterceptor());
        registry.addInterceptor(pdfInterceptor())
                .addPathPatterns("/report*");

    }

    @Bean
    public TimeInterceptor timeInterceptor() {
        return new TimeInterceptor();
    }

    @Bean
    public PDFInterceptor pdfInterceptor() {
        return new PDFInterceptor();
    }

}
