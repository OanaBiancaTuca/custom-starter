package dev.customstarter.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.bind.DefaultValue;

@ConfigurationProperties(prefix = "hello-service") // Binds properties prefixed with "hello-service" to this class
public record HelloServiceCustomProperties(@DefaultValue("8081")
                                           //default value of port =8081 if is not provided
                                           String port) {
}
