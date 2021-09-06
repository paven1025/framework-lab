package com.paven.controller;

import com.paven.configuration.LabProperties;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
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

    @Value("${lab.required_str}")
    private String str;

    @Autowired
    private LabProperties labProperties;

    @RequestMapping("/hello")
    public String hello() {
        return "hello";
    }

    @RequestMapping("/profiles")
    public String profiles() {
        System.out.println(labProperties.getRequiredStr());
        return profiles;
    }
}
