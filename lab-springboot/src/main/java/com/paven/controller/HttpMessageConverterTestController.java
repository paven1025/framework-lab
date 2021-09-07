package com.paven.controller;

import com.paven.request.User;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author cpw
 * @date 2021/9/7 4:35 下午
 */
@Slf4j
@RestController
@RequiredArgsConstructor
public class HttpMessageConverterTestController {

    /**
     * HttpMessageConverters测试
     *
     * @param user
     * @return
     */
    @RequestMapping("/user")
    public User converter(@RequestBody User user) {
        return user;
    }
}
