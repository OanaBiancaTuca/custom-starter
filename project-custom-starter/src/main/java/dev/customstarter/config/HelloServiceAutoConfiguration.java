package dev.customstarter.config;

import dev.customstarter.service.HelloService;
import dev.customstarter.service.HelloServiceImpl;
import lombok.extern.java.Log;
import org.springframework.boot.autoconfigure.AutoConfiguration;
import org.springframework.boot.autoconfigure.condition.ConditionalOnClass;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.boot.web.embedded.tomcat.TomcatServletWebServerFactory;
import org.springframework.boot.web.server.WebServerFactoryCustomizer;
import org.springframework.boot.web.servlet.server.ConfigurableServletWebServerFactory;
import org.springframework.context.annotation.Bean;

@AutoConfiguration
@EnableConfigurationProperties(HelloServiceCustomProperties.class)
@ConditionalOnClass(HelloService.class) //configuration is activated only if HelloService class is present
@Log
public class HelloServiceAutoConfiguration {
    private HelloServiceCustomProperties properties;

    public HelloServiceAutoConfiguration(HelloServiceCustomProperties properties) {
        log.info("Configuring starter with properties: " + properties);
        this.properties = properties;
    }


    @Bean
    @ConditionalOnMissingBean(HelloService.class)
    //ensures that this bean will only be created if no other HelloService bean is defined.
    public HelloService helloService() {
        return new HelloServiceImpl();
    }



    // Customizes - set the port based on properties
    @Bean
    public WebServerFactoryCustomizer<ConfigurableServletWebServerFactory> webServerFactoryCustomizer() {
        return factory -> factory.setPort(Integer.parseInt(properties.port()));
    }


}
