package com.test.web;

import java.util.Map;

import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MyController {


    @RequestMapping("/")
    public String hello( @RequestHeader Map<String, String> headers ) {
        System.out.println( "In GET API in test application, heasers are " + headers );
        return "Hello ";
    }

}
