package com.nocdy.hospital.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.nocdy.hospital.service.RegisterService;
import entites.*;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

/**
 * @author Nocdy
 * @date 2021年 09月10日 16:20:15
 */
@RestController
@RequestMapping(value = "/hospital")
public class RegisterController {

    @Resource
    private RegisterService registerService;

    @Resource
    RedisTemplate redisTemplate;



    @PostMapping(value = "/register/{id}")
    public CommonResult register(@RequestBody RegisterUser registerUser,
                                 @PathVariable("id") Integer id) throws JsonProcessingException {
        ObjectMapper objectMapper=new ObjectMapper();
        Integer doctorId = 0;
        Integer office=0;
        List<Doctor> list=objectMapper.convertValue(redisTemplate.opsForValue().get("doctor"),
                new TypeReference<ArrayList<Doctor>>(){});
        for (Doctor doctor : list) {
            if (doctor.getName().equals(registerUser.getDoctorName())) {
                doctorId = doctor.getId();
                office=doctor.getOffice();
                break;
            }
        }
        if (doctorId ==0||office==0){
            return new CommonResult<>(StatusCode.Status.ERROR.getCode(),StatusCode.Status.ERROR.getMessage());
        }
        else{
            Calendar calendar=Calendar.getInstance();
            Register register=new Register();
            register.setDoctor(doctorId);
            register.setType(registerUser.getType());
            register.setPatient(id);
            register.setRegisterTime(calendar.getTime());
            register.setStatus(true);
            register.setOffice(office);
            registerService.save(register);
            return new CommonResult<>(StatusCode.Status.SUCCESS.getCode(), StatusCode.Status.SUCCESS.getMessage(),id);
        }
    }
}
