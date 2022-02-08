package com.nocdy.hospital.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.nocdy.hospital.service.UserFeignService;
import entites.CommonResult;
import entites.User;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

/**
 * @author Nocdy
 * @date 2021年 09月10日 12:52:33
 */
@RestController
@RequestMapping(value = "/doctor")
public class DoctorController {

    @Resource
    private UserFeignService userFeignService;

    @PostMapping(value = "/login")
    public CommonResult login(@RequestBody User user,
                              HttpSession session){
        CommonResult<User> commonResult= userFeignService.userLogin(user);
        ObjectMapper objectMapper = new ObjectMapper();
        User person = objectMapper.convertValue(commonResult.getData(), User.class);
        session.setAttribute("User",person);
        return  commonResult;
    }





}
