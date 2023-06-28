package com.test.starter;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@ComponentScan(basePackages = {
    "com.test.web", "com.uplight.service", "com.uplight.aspect"
})
@SpringBootApplication
public class ApplicationStarter {
    public static void main( String[] args ) {
        System.out.println( "Starting spring boot application" );
        SpringApplication.run( ApplicationStarter.class, args );
    }


    // @Bean
    // @ConditionalOnMissingBean
    // OtlpHttpSpanExporter otlpHttpSpanExporter() {
    // OtlpHttpSpanExporterBuilder builder = OtlpHttpSpanExporter.builder().setEndpoint( "http://otel-collector:4317" );
    //
    // for( Entry<String, String> header : properties.getHeaders().entrySet() ) {
    // builder.addHeader( header.getKey(), header.getValue() );
    // }
    //
    // return builder.build();
    //
    // }

}

