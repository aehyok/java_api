package com.sun.xxm.utils.authentication;

import cn.hutool.jwt.JWT;
import cn.hutool.jwt.JWTUtil;
import com.sun.xxm.utils.ApiException;
import com.sun.xxm.utils.ResultCodeEnum;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.HandlerInterceptor;

import java.lang.reflect.Method;

public class TokenValidationInterceptor implements HandlerInterceptor {


    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        if (handler instanceof HandlerMethod) {
            HandlerMethod handlerMethod = (HandlerMethod) handler;
            Method method = handlerMethod.getMethod();

            if (method.isAnnotationPresent(AllowAnonymous.class) ||
                    method.getDeclaringClass().isAnnotationPresent(AllowAnonymous.class)) {
                return true; // 跳过 token 验证
            }
        }

        String token = request.getHeader("Authorization");

        if (token == null) {
            throw new ApiException(ResultCodeEnum.Unauthorized);
        }

        if(token.startsWith("Bearer")){
            token = token.substring(7);
        }
        // 执行正常的 token 验证逻辑
        var obj = JWTUtil.parseToken(token);
//
//        throw new ApiException(ResultCodeEnum.Unauthorized);
        return true;
    }
}
