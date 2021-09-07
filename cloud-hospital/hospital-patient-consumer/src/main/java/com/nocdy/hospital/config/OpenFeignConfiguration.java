package com.nocdy.hospital.config;

import feign.Logger;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * OpenFeign配置类
 *
 * @author Nocdy
 * @date 2021年 09月07日 15:54:48
 */
@Configuration
public class OpenFeignConfiguration {

    @Bean
    Logger.Level feignLoggerLevel(){
        return Logger.Level.FULL;
    }
}
