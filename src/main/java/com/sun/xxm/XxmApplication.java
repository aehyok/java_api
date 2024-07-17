package com.sun.xxm;

import com.mybatisflex.core.audit.AuditManager;
import com.mybatisflex.core.audit.ConsoleMessageCollector;
import com.mybatisflex.core.audit.MessageCollector;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@SpringBootApplication
@EnableTransactionManagement
@MapperScan(value = "com.sun.xxm.mapper")
public class XxmApplication {

	public static void main(String[] args) {
		AuditManager.setAuditEnable(true);

		//设置 SQL 审计收集器
		MessageCollector collector = new ConsoleMessageCollector();
		AuditManager.setMessageCollector(collector);

		SpringApplication.run(XxmApplication.class, args);
	}
}
