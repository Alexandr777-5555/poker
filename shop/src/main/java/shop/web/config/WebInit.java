//package shop.web.config;
//
//import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;
//import shop.service.config.ServiceConfigure;
//
//public class WebInit extends AbstractAnnotationConfigDispatcherServletInitializer {
//
//
//    @Override
//    protected Class<?>[] getRootConfigClasses() {
//        return new Class[]{
//           // ServiceConfigure.class
//        };
//    }
//
//    @Override
//    protected Class<?>[] getServletConfigClasses() {
//        return new Class<?>[]{
//                WebConfiguration.class,
//                ServiceConfigure.class,
//                ViewResolverConfig.class,
//                InterceptConfig.class,
//                LocaleConfig.class
//                };
//    }
//
//    @Override
//    protected String[] getServletMappings() {
//        return new String[] {"/"};
//    }
//
//
//}
