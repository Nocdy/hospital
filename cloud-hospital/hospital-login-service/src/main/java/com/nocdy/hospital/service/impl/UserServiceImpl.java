package com.nocdy.hospital.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.nocdy.hospital.dao.UserMapper;
import com.nocdy.hospital.service.UserService;
import entites.User;
import org.springframework.stereotype.Service;

/**
 * @author Nocdy
 * @date 2021年 09月07日 13:12:34
 */
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements UserService {
}
