package com.nocdy.hospital.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.nocdy.hospital.dao.DoctorMapper;
import com.nocdy.hospital.service.DoctorService;
import entites.Doctor;
import org.springframework.stereotype.Service;

/**
 * @author Nocdy
 * @date 2021年 09月10日 17:28:34
 */
@Service
public class DoctorServiceImpl extends ServiceImpl<DoctorMapper, Doctor> implements DoctorService {
}
