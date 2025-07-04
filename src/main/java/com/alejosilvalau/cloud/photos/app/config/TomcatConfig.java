package com.alejosilvalau.cloud.photos.app.config;

import org.springframework.boot.web.embedded.tomcat.TomcatServletWebServerFactory;
import org.springframework.boot.web.server.WebServerFactoryCustomizer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class TomcatConfig {

    @Bean
    public WebServerFactoryCustomizer<TomcatServletWebServerFactory> tomcatCustomizer() {
        return (factory) -> {
            factory.addConnectorCustomizers(connector -> {
                connector.setProperty("relaxedQueryChars", "|{}[]");
                connector.setProperty("relaxedPathChars", "|{}[]");
                connector.setMaxParameterCount(1000);
                
                // Reduce timeout for malformed requests
                connector.setProperty("connectionTimeout", "5000");
                
                // This might help with SSL/TLS handshake attempts
                connector.setProperty("rejectIllegalHeader", "true");
            });
        };
    }
}