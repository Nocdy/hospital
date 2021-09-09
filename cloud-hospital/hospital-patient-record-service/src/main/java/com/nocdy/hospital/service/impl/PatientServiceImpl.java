package com.nocdy.hospital.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.nocdy.hospital.dao.PatientMapper;
import com.nocdy.hospital.service.PatientService;
import entites.Patient;
import org.springframework.stereotype.Service;

/**
 * @author Nocdy
 * @date 2021年 09月08日 12:37:40
 */
@Service
public class PatientServiceImpl extends ServiceImpl<PatientMapper, Patient> implements PatientService {
}
