package com.uplight.starter;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.web.client.RestTemplate;

import io.opentelemetry.api.logs.GlobalLoggerProvider;
import io.opentelemetry.exporter.otlp.logs.OtlpGrpcLogRecordExporter;
import io.opentelemetry.sdk.logs.SdkLoggerProvider;
import io.opentelemetry.sdk.logs.export.LogRecordExporter;
import io.opentelemetry.sdk.logs.export.SimpleLogRecordProcessor;

@ComponentScan(basePackages = {
    "com.uplight.web", "com.uplight.service", "com.uplight.aspect"
})
@SpringBootApplication
public class ApplicationStarter {
    public static void main( String[] args ) {
        System.out.println( "Starting spring boot application" );

        LogRecordExporter otlpGrpcLogRecordExporter = OtlpGrpcLogRecordExporter.builder().setEndpoint( "http://otel-collector:4317" ).build();
        SdkLoggerProvider sdkLoggerProvider = SdkLoggerProvider.builder().addLogRecordProcessor( SimpleLogRecordProcessor.create( otlpGrpcLogRecordExporter ) ).build();
        GlobalLoggerProvider.set( sdkLoggerProvider );

        SpringApplication.run( ApplicationStarter.class, args );
    }

    @Bean
    public RestTemplate restTemplate() {
        return new RestTemplate();
    }

    // @Bean
    // public B3Propagator b3Propagator() {
    // return B3Propagator.injectingMultiHeaders();
    // }
    //
    // @Bean
    // public W3CBaggagePropagator b3Propagator() {
    // return W3CBaggagePropagator.getInstance();
    // }


    // @Bean
    // PropagationFactorySupplier myPropagationFactorySupplier() {
    // return () -> B3Propagation.newFactoryBuilder().injectFormat( B3Propagation.Format.MULTI ).build();
    // }


    // @Bean
    // ScopeDecorator mdcScopeDecorator() {
    // return MDCScopeDecorator.newBuilder().clear().add( SingleCorrelationField.newBuilder( countryCodeField() ).flushOnUpdate().build() ).build();
    // }
}

