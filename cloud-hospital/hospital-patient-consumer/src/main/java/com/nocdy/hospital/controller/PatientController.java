package com.nocdy.hospital.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.nocdy.hospital.service.RecordFeignService;
import com.nocdy.hospital.service.UserFeignService;
import entites.CommonResult;
import entites.Patient;
import entites.User;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

/**
 * @author Nocdy
 * @date 2021年 09月07日 16:01:06
 */
@RestController
@Slf4j
public class PatientController {


    @Resource
    private UserFeignService userFeignService;

    @Resource
    private RecordFeignService recordFeignService;

    @PostMapping(value = "/login")
    public CommonResult patientLogin(@RequestBody User user,
                                     HttpSession session){
       CommonResult<User> commonResult= userFeignService.userLogin(user);
        ObjectMapper objectMapper = new ObjectMapper();

        User person = objectMapper.convertValue(commonResult.getData(), User.class);
        session.setAttribute("User",person);
        return  commonResult;

    }

    @PostMapping(value = "/registry")
    public  CommonResult patientRegistry(@RequestBody User user){
        return  userFeignService.userRegistry(user);
    }

    @GetMapping(value = "/index")
    public  CommonResult patientIndex(HttpSession session){
       User user=(User)  session.getAttribute("User");
       return recordFeignService.index(user.getId());
    }

    @PostMapping(value = "/index")
    public CommonResult patientRecord(@RequestBody Patient patient,
                                      HttpSession session){
        User user=(User)  session.getAttribute("User");
        return recordFeignService.record(patient,user.getId());
    }


}
