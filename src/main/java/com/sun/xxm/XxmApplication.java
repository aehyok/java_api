package com.sun.xxm;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan(value = "com.sun.xxm.mapper")
public class XxmApplication {

	public static void main(String[] args) {
		SpringApplication.run(XxmApplication.class, args);
	}
}
