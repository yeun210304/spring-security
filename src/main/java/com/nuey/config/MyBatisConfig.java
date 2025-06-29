package com.nuey.config;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@MapperScan("com.nuey.mapper")
public class MyBatisConfig {	}
