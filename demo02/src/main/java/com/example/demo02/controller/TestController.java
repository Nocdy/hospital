package com.example.demo02.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpSession;

/**
 * @author Nocdy
 * @date 2021年 09月08日 20:54:10
 */
@RestController
public class TestController {
    @GetMapping(value = "get")
    public Object get(HttpSession session){
        return session.getId();
    }

}
