package com.paven.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author cpw
 */
@RestController
@RequiredArgsConstructor
public class HelloSpringBootController {

    @Value("${spring.profiles}")
    private String profiles;

    @RequestMapping("/hello")
    public String hello() {
        return "hello";
    }

    @RequestMapping("/profiles")
    public String profiles() {
        return profiles;
    }
}
