package com.base_java.baselts.controller;

import com.base_java.baselts.service.impl.BaseRedisService;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/redis")
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
@Slf4j
public class RedisController {
    BaseRedisService<String,String,String>baseRedisService;
    @PostMapping
    public String set(){
       baseRedisService.set("xinchao","hungday");
       return "ok";
    }
}
