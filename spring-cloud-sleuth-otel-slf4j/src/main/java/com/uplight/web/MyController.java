package com.uplight.web;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.sleuth.Tracer;
import org.springframework.cloud.sleuth.annotation.SpanTag;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.uplight.service.TestService;

@RestController
public class MyController {

    @Autowired
    private Tracer tracer;

    @Autowired
    private TestService testService;

    private static final Logger LOGGER = LoggerFactory.getLogger( MyController.class );

    @RequestMapping("/")
    // @NewSpan
    public String hello( @RequestParam("testCount") @SpanTag(key = "testCount123") int testCount ) {
        System.out.println( "Inside hello method,testCount=" + testCount );
        testPrivateMethod( 1 );
        testService.test();
        return "Hello ";
    }

    private void testPrivateMethod( Integer count ) {
        // MDC.put( "serviceName", "spring-cloud-sleuth-otel-slf4j" );
        LOGGER.error( "Logging error using SLF4J LOGGER--------------------------------------------------------------------" );
        System.out.println( "In testPrivateMethod" );
    }
}
