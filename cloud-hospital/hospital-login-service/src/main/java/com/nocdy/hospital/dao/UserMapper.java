package com.nocdy.hospital.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import entites.User;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.cloud.context.config.annotation.RefreshScope;

/**
 * 用户数据持久层
 *
 * @author Nocdy
 * @date 2021年 09月07日 13:13:58
 */
@RefreshScope
@Mapper
public interface UserMapper extends BaseMapper<User> {
}
