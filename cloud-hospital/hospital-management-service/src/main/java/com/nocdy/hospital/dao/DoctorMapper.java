package com.nocdy.hospital.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import entites.Doctor;
import org.apache.ibatis.annotations.Mapper;

/**
 * @author Nocdy
 * @date 2021年 09月10日 17:21:55
 */
@Mapper
public interface DoctorMapper extends BaseMapper<Doctor> {
}
