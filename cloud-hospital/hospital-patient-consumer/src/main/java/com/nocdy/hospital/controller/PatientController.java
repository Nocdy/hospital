package com.nocdy.hospital.controller;

import com.nocdy.hospital.service.UserFeignService;
import entites.CommonResult;
import entites.User;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @author Nocdy
 * @date 2021年 09月07日 16:01:06
 */
@RestController
@Slf4j
public class PatientController {

    @Resource
    private UserFeignService userFeignService;

    @PostMapping(value = "/login")
    public CommonResult patientLogin(@RequestBody User user){
       return userFeignService.userLogin(user);
    }

    @PostMapping(value = "/registry")
    public  CommonResult patientRegistry(@RequestBody User user){
        return  userFeignService.userRegistry(user);
    }

}
