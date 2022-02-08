package com.nocdy.hospital.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.nocdy.hospital.service.DoctorService;
import entites.CommonResult;
import entites.Doctor;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.time.LocalTime;
import java.util.Calendar;
import java.util.List;

/**
 * @author Nocdy
 * @date 2021年 09月10日 16:42:31
 */
@RestController
public class ManagementController {

    @Resource
    RedisTemplate redisTemplate;

    @Resource
    private DoctorService doctorService;

    @GetMapping(value = {"/refresh", "/"})
    public CommonResult getDoctor(){
        Calendar calendar=Calendar.getInstance();
        LocalTime time=LocalTime.now();
        int day=calendar.get(Calendar.DAY_OF_WEEK)-1;
        QueryWrapper<Doctor> queryWrapper=new QueryWrapper<>();
        queryWrapper
                .eq("work_day",day)
                .lt("work_star_time",time)
                .gt("work_end_time",time);
        List<Doctor> doctorList=doctorService.list(queryWrapper);
        redisTemplate.opsForValue().set("doctor",doctorList);
        return  null;

    }


}
