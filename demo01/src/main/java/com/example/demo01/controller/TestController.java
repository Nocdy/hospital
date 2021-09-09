package com.example.demo01.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpSession;

/**
 * @author Nocdy
 * @date 2021年 09月08日 20:47:53
 */
@RestController
@Slf4j
public class TestController {


    @GetMapping(value = "get")
    public Object get(HttpSession session){
        return session.getId();
    }


}
