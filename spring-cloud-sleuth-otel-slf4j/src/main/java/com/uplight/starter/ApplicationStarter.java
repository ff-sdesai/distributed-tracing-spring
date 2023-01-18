package com.uplight.starter;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@ComponentScan(basePackages = {
    "com.uplight.web", "com.uplight.service", "com.uplight.aspect"
})
@SpringBootApplication
public class ApplicationStarter {
    public static void main( String[] args ) {
        System.out.println( "Starting spring boot application" );
        SpringApplication.run( ApplicationStarter.class, args );
    }


    // @Bean
    // ScopeDecorator mdcScopeDecorator() {
    // return MDCScopeDecorator.newBuilder().clear().add( SingleCorrelationField.newBuilder( countryCodeField() ).flushOnUpdate().build() ).build();
    // }
}
