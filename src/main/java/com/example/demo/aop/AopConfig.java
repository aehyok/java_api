package com.example.demo.aop;

import com.example.demo.servcice.TestService;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;

import java.util.Arrays;

//所有控制器执行时先执行simpleAop方法
@Configuration
@Aspect
public class AopConfig {
    @Autowired
    private TestService testService;

    @Around("@within(org.springframework.stereotype.Controller)")
    public Object simpleAop(final ProceedingJoinPoint pjp) throws  Throwable{
        try{
            Object[] args=pjp.getArgs();
            System.out.println("args:"+ Arrays.asList(args));

            testService.operation(1,"2");

            //调用原有的方法
            Object o=pjp.proceed();
            System.out.println("return:"+o);
            return o;
        }catch (Throwable e){
            throw e;
        }
    }
}
