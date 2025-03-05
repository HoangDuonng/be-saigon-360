package com.be_servicie.saigon_travel.be_service.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.ViewResolverRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.view.InternalResourceViewResolver;
import org.springframework.web.servlet.view.JstlView;

@Configuration
@EnableWebMvc
@EnableWebSecurity
public class AppConfig implements WebMvcConfigurer {

    @Bean
    public ViewResolver viewResolver() {
        final InternalResourceViewResolver bean = new InternalResourceViewResolver();
        bean.setViewClass(JstlView.class);
        bean.setPrefix("/WEB-INF/view/");
        bean.setSuffix(".jsp");
        return bean;
    }

    @Override
    public void configureViewResolvers(ViewResolverRegistry registry) {
        registry.viewResolver(viewResolver());
    }

    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("/css/**").addResourceLocations("/resources/css/");

        registry.addResourceHandler("/images/**")
                .addResourceLocations("classpath:/files/images/**");

        registry.addResourceHandler("/images/marketing/**")
                .addResourceLocations("classpath:/files/images/marketing/");

        registry.addResourceHandler("/images/sub_menu/**")
                .addResourceLocations("classpath:/files/images/sub_menu/");

        registry.addResourceHandler("/file_convert/**")
                .addResourceLocations("classpath:/files/file_convert/");

    }

    @Bean
    public RestTemplate restTemplate() {
        return new RestTemplate();
    }

}
