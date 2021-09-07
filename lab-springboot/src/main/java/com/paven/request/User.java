package com.paven.request;

import lombok.Data;

/**
 * @author cpw
 * @date 2021/9/7 4:37 下午
 */
@Data
public class User {

    private String userId;

    private String userName;

    private Integer age;

    private String[] teleList;

}
