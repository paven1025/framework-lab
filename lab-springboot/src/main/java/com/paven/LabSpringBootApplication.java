package com.paven;

import com.paven.configuration.LabProperties;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;

/**
 * @author cpw
 */
@SpringBootApplication
@EnableConfigurationProperties(LabProperties.class)
public class LabSpringBootApplication {

    public static void main(String[] args) {
        SpringApplication.run(LabSpringBootApplication.class, args);
    }
}
