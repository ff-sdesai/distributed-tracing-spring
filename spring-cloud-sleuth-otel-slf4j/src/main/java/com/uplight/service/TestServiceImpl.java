package com.uplight.service;

import java.util.Map;

import javax.annotation.PostConstruct;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.slf4j.MDC;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.sleuth.annotation.NewSpan;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import io.opentelemetry.api.baggage.Baggage;
import io.opentelemetry.api.baggage.BaggageEntry;

@Service
public class TestServiceImpl
    implements TestService {

    private static final Logger LOGGER = LoggerFactory.getLogger( TestServiceImpl.class );

    @Autowired
    private RestTemplate restTemplate;

    @PostConstruct
    public void init() {
        System.out.println( "TestServiceImpl initalized.........................................." );
    }

    @Override
    @NewSpan
    public void test() {
        Map<String, String> copyOfContextMap = MDC.getCopyOfContextMap();
        LOGGER.error( "copyOfContextMap=" + copyOfContextMap );
        Map<String, BaggageEntry> baggageAsMap = Baggage.current().asMap();
        System.out.println( "baggageAsMap=" + baggageAsMap );
        System.out.println( "calling another web application" );


        // ResponseEntity<String> responseEntity = restTemplate.getForEntity( "http://172.22.0.1:8282/", String.class );
        // System.out.println( "Response received=" + responseEntity.getBody() );
    }

}
