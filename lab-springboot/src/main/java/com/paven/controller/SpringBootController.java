package com.paven.controller;

import com.alibaba.fastjson.JSON;
import com.fasterxml.jackson.annotation.JsonAlias;
import com.google.common.collect.Lists;
import com.paven.configuration.LabProperties;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.checkerframework.checker.units.qual.K;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.redis.core.*;
import org.springframework.data.redis.serializer.RedisSerializer;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.util.List;

/**
 * @author cpw
 */
@Slf4j
@RestController
@RequiredArgsConstructor
public class SpringBootController {

    @Value("${spring.profiles}")
    private String profiles;

    @Value("${lab.required_str}")
    private String str;

    private final LabProperties labProperties;

    private final RedisTemplate redisTemplate;

    private final StringRedisTemplate stringRedisTemplate;

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

    @RequestMapping("/advice")
    public String testControllerAdvice() {
//        int i = 1 / 0;
        int[] nums = {1, 2, 3,};
        System.out.println(nums[5]);
        return profiles;
    }

    @RequestMapping("/cache/all")
    public Object cacheAll(String match) {
        List<String> keys = Lists.newArrayList();
        try {
            ScanOptions scanOptions = ScanOptions.scanOptions().match(match).count(100).build();
            RedisSerializer<String> redisSerializer = (RedisSerializer<String>) stringRedisTemplate.getKeySerializer();
            Cursor<String> cursor = (Cursor<String>) stringRedisTemplate.executeWithStickyConnection((RedisCallback) redisConnection -> new ConvertingCursor<>(redisConnection.scan(scanOptions), redisSerializer::deserialize));
            while (cursor.hasNext()) {
                keys.add(cursor.next());
            }
            cursor.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return keys;
    }

    @RequestMapping("/cache/add")
    public String cacheAdd(String key, String value) {
        stringRedisTemplate.opsForValue().set(key, value);
        return "cacheAdd";
    }

    @RequestMapping("/cache/get")
    public String cacheGet(String key) {
        Object o = stringRedisTemplate.opsForValue().get(key);
        return JSON.toJSONString(o);
    }
}
