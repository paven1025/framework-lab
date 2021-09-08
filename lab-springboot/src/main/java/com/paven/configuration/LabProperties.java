package com.paven.configuration;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.validation.annotation.Validated;

import javax.validation.constraints.NotNull;

/**
 * 第三方配置类
 *
 * @author cpw
 * @date 2021/9/6 5:34 下午
 */
@Data
@Configuration
@ConfigurationProperties(value = "lab")
@Validated
public class LabProperties {

    private boolean enable;

    @NotNull
    private String requiredStr;
}
