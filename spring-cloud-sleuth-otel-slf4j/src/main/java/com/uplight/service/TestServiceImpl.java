package com.uplight.service;

import javax.annotation.PostConstruct;

import org.springframework.cloud.sleuth.annotation.NewSpan;
import org.springframework.stereotype.Service;

@Service
public class TestServiceImpl
    implements TestService {

    @PostConstruct
    public void init() {
        System.out.println( "TestServiceImpl initalized.........................................." );
    }

    @Override
    @NewSpan
    public void test() {
        System.out.println( "In test method" );

    }

}
