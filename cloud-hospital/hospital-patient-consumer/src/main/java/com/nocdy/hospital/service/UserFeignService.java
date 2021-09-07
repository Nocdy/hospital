package com.nocdy.hospital.service;

import com.nocdy.hospital.config.OpenFeignConfiguration;
import entites.CommonResult;
import entites.User;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

/**
 * 基于OpenFeign的登录与注册服务调用
 *
 * @author Nocdy
 * @date 2021年 09月07日 15:46:02
 */
@Component
@FeignClient(value = "hospital-login", configuration = OpenFeignConfiguration.class)
public interface UserFeignService {

    /**
     * 用户登录服务调用
     * @param user 表单提交内容
     *
     */
    @PostMapping("/login")
    CommonResult userLogin(@RequestBody User user);


    /**
     * 用户注册服务调用
     * @param user 表单提交内容
     *
     */
    @PostMapping(value = "/registry")
    CommonResult userRegistry(@RequestBody User user);
}
