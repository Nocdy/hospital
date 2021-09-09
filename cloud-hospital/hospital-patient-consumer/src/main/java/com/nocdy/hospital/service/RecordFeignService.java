package com.nocdy.hospital.service;

import com.nocdy.hospital.config.OpenFeignConfiguration;
import entites.CommonResult;
import entites.Patient;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

/**
 * @author Nocdy
 * @date 2021年 09月08日 15:32:19
 */
@Component
@FeignClient(value = "hospital-patient-record-service",configuration = OpenFeignConfiguration.class)
public interface RecordFeignService {


    /**
     *病人主页
     * @param id
     * @return 返回json结果
     */
    @GetMapping(value = "/index/{id}")
    CommonResult index(@PathVariable("id") Integer id);

    /**
     * 病人创建诊疗卡
     * @param patient 诊疗卡信息
     * @return 返回json业务结果
     */
    @PostMapping(value = "/index/{id}")
    CommonResult record(@RequestBody Patient patient, @PathVariable("id") Integer id);

}
