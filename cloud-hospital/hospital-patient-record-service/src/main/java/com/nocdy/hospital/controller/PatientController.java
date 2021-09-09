package com.nocdy.hospital.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.nocdy.hospital.service.PatientService;
import entites.CommonResult;
import entites.Patient;
import entites.StatusCode;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * @author Nocdy
 * @date 2021年 09月08日 12:38:37
 */
@RestController
@Slf4j
@RefreshScope
public class PatientController {
    @Resource
    private PatientService patientService;

    @GetMapping(value = "/index/{id}")
    public CommonResult index(@PathVariable("id") Integer id){
        Patient patientUser=patientService.getById(id);
        if(patientUser==null){
            return new CommonResult<>(StatusCode.Status.REQUEST.getCode(),
                    StatusCode.Status.REQUEST.getMessage(),id);
        }
        else {
            return new CommonResult<>(StatusCode.Status.SUCCESS.getCode(),
                    StatusCode.Status.SUCCESS.getMessage(),patientUser);
        }
    }

    @PostMapping(value = "/index/{id}")
    public CommonResult record(@RequestBody Patient patient,
                               @PathVariable("id") Integer id){
        patient.setId(id);
        QueryWrapper<Patient> queryWrapper=new QueryWrapper<>();
        queryWrapper
                .eq("identity_num",patient.getIdentityNum())
                .eq("name",patient.getName());
        if(patientService.getOne(queryWrapper)!=null){
            return new CommonResult<>(StatusCode.Status.ERROR.getCode(),
                    StatusCode.Status.ERROR.getMessage(),null);
        }
        else{
            patientService.save(patient);
            return new CommonResult<>(StatusCode.Status.SUCCESS.getCode(),
                    StatusCode.Status.SUCCESS.getMessage(),patient);
        }
    }


}
