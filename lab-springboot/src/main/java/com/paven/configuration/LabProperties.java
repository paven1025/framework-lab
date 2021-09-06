package com.paven.configuration;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;

/**
 * @author cpw
 * @date 2021/9/6 5:34 下午
 */
@Data
@ConfigurationProperties(value = "lab")
public class LabProperties {

    private boolean enable;

}
