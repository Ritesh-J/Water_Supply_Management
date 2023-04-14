//package com.demo.waterSupply.Config;
//
//import org.springframework.boot.convert.ApplicationConversionService;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.format.FormatterRegistry;
//import org.springframework.web.servlet.config.annotation.CorsRegistry;
//import org.springframework.web.servlet.config.annotation.EnableWebMvc;
//import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
//import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
//
//@Configuration
//@EnableWebMvc
//public class WebMvcConfig implements WebMvcConfigurer {
//
//
//    private static final String[] CLASSPATH_RESOURCE_LOCATIONS = {
//            "classpath:/META-INF/resources/", "classpath:/resources/",
//            "classpath:/static/", "classpath:/public/"
//    };
//
//    @Override
//    public void addResourceHandlers(ResourceHandlerRegistry registry) {
//        if(!registry.hasMappingForPattern("/**")){
//            registry.addResourceHandler("/**").addResourceLocations(CLASSPATH_RESOURCE_LOCATIONS);
//        }
//    }
//
//    @Override
//    public void addCorsMappings(CorsRegistry registry) {
//        registry.addMapping("/**").allowedOrigins("*").allowedMethods("*").allowedHeaders("*");
//    }
//
//    @Override
//    public void addFormatters(final FormatterRegistry registry) {
//        ApplicationConversionService.configure(registry);
//    }
//}
