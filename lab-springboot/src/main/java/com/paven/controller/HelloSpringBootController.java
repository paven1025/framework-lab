package com.paven.controller;

import com.paven.configuration.LabProperties;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author cpw
 */
@Slf4j
@RestController
@RequiredArgsConstructor
public class HelloSpringBootController {

    @Value("${spring.profiles}")
    private String profiles;

    @Value("${lab.required_str}")
    private String str;

    private final LabProperties labProperties;

    @RequestMapping("/hello")
    public String hello() {
        log.info("hello info");
        log.debug("hello debug");
        log.error("hello error");
        return "hello";
    }

    @RequestMapping("/profiles")
    public String profiles() {
        System.out.println(labProperties.getRequiredStr());
        return profiles;
    }
}
