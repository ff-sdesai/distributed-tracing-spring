package com.uplight.aspect;

import javax.annotation.PostConstruct;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.sleuth.Tracer;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class TestApplicationAspect {

    @Autowired
    private Tracer tracer;


    @Pointcut("execution(* com.uplight.web..*(..)) ")
    private void anyWebService() {

    }

    @PostConstruct
    public void init() {
        System.out.println( "Initialization of TestApplicationAspect done----------------------------------------------------------" );
    }

    @Around("anyWebService()")
    public Object aroundAspect( final ProceedingJoinPoint joint )
        throws Throwable {
        System.out.println( "In TestApplicationAspect -> aroundAspect" );
        tracer.createBaggage( "serviceName", "spring-cloud-sleuth-otel-slf4j" );
        tracer.createBaggage( "testProperty", "test-property1" );
        return joint.proceed();
    }


}
