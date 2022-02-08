package com.nocdy.hospital.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.nocdy.hospital.dao.RegisterMapper;
import com.nocdy.hospital.service.RegisterService;
import entites.Register;
import org.springframework.stereotype.Service;

/**
 * @author Nocdy
 * @date 2021年 09月10日 16:23:47
 */
@Service
public class RegisterServiceImpl extends ServiceImpl<RegisterMapper, Register> implements RegisterService {
}
