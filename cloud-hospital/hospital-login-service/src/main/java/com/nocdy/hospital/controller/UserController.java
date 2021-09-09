package com.nocdy.hospital.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.nocdy.hospital.service.UserService;
import entites.CommonResult;
import entites.StatusCode;
import entites.User;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * 登录与注册控制器
 *
 * @author Nocdy
 * @date 2021年 09月07日 12:57:36
 */
@RestController
@Slf4j
@RefreshScope
public class UserController {

    @Resource
    private UserService userService;

    @PostMapping("/login")
    public CommonResult userLogin(@RequestBody User user){
        QueryWrapper<User> queryWrapper=new QueryWrapper<>();
        queryWrapper
                .eq("name",user.getName());
        User getUser=userService.getOne(queryWrapper);
        if(getUser==null){
           return new CommonResult<>(StatusCode.Status.ERROR.getCode(),
                   StatusCode.Status.ERROR.getMessage(),
                   null);
        }
        else{
            if(getUser.getPassword().equals(user.getPassword())){
                return new CommonResult<User>(StatusCode.Status.SUCCESS.getCode(),
                        StatusCode.Status.SUCCESS.getMessage(),
                        getUser);
            }
            else {
                return new CommonResult<>(StatusCode.Status.ERROR.getCode(),
                        StatusCode.Status.ERROR.getMessage(),
                        null);
            }
        }

    }


    @PostMapping(value = "/registry")
    public CommonResult userRegistry(@RequestBody User user){
        QueryWrapper<User> queryWrapper=new QueryWrapper<>();
        queryWrapper
                .select("id")
                .eq("name",user.getName());
       if(userService.getOne(queryWrapper)!=null){
           return new CommonResult<>(StatusCode.Status.ERROR.getCode(),
                   StatusCode.Status.ERROR.getMessage(),
                   null);
       }
       else{
           userService.save(user);
           return new CommonResult<>(StatusCode.Status.SUCCESS.getCode(),
                   StatusCode.Status.SUCCESS.getMessage(),
                   user.getName());
       }
    }


}
