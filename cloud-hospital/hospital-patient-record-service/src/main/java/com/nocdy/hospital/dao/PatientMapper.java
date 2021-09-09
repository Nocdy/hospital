package com.nocdy.hospital.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import entites.Patient;
import org.apache.ibatis.annotations.Mapper;

/**
 * 诊疗卡数据持久层
 *
 * @author Nocdy
 * @date 2021年 09月08日 12:35:43
 */
@Mapper
public interface PatientMapper extends BaseMapper<Patient> {
}
