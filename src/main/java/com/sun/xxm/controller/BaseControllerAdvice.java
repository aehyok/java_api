package com.sun.xxm.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.mybatisflex.core.paginate.Page;
import com.sun.xxm.utils.ApiException;
import com.sun.xxm.utils.PageResultModel;
import com.sun.xxm.utils.ResultCodeEnum;
import com.sun.xxm.utils.ResultModel;
import org.springframework.core.MethodParameter;
import org.springframework.http.MediaType;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.server.ServerHttpRequest;
import org.springframework.http.server.ServerHttpResponse;
import org.springframework.web.ErrorResponse;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.mvc.method.annotation.ResponseBodyAdvice;

@RestControllerAdvice(basePackages = {"com.sun.xxm.controller"}) // 注意哦，这里要加上需要扫描的包
public class BaseControllerAdvice implements ResponseBodyAdvice<Object> {
    @Override
    public boolean supports(MethodParameter returnType, final Class<? extends HttpMessageConverter<?>> converterType) {
        // 如果接口返回的类型本身就是ResultVO那就没有必要进行额外的操作，返回false
        return !returnType.getGenericParameterType().equals(ResultModel.class);
    }

    @Override
    public Object beforeBodyWrite(Object body, MethodParameter returnType, MediaType selectedContentType, Class selectedConverterType, ServerHttpRequest request, ServerHttpResponse response) {
        // String类型不能直接包装，所以要进行些特别的处理
        if(returnType.getGenericParameterType().equals(String.class)){
            ObjectMapper objectMapper = new ObjectMapper();
            try {
                // 将数据包装在ResultModel里后，再转换为json字符串响应给前端
                if(body instanceof ResultModel){
                    return objectMapper.writeValueAsString(body);
                }
                return objectMapper.writeValueAsString(new ResultModel<>(body));
            } catch (JsonProcessingException e) {
                throw new ApiException(ResultCodeEnum.FAILED);
            }
        }

        // 将原本的数据包装在ResultModel里
        if(body instanceof ResultModel){
            return body;
        }
        if(body instanceof Page) {
            var result = new PageResultModel();
            result.setCode(ResultCodeEnum.SUCCESS.getCode());
            result.setData(((Page<?>) body).getRecords());
            result.setPage(((Page<?>) body).getPageNumber());
            result.setTotal(((Page<?>) body).getTotalRow());
            result.setTotalPage(((Page<?>) body).getTotalPage());
            result.setLimit(((Page<?>) body).getPageSize());
            return result;
        }

        return new ResultModel<>(body);
    }

    @ExceptionHandler(value = ApiException.class)
    @ResponseBody
    public ResultModel<Object> handleBusinessException(ApiException e) {
        var result = new ResultModel<Object>();
        result.setCode(e.getCode());
        result.setMessage(e.getMessage());
        result.setData("");
        return result;
    }

    @ExceptionHandler(value = Exception.class)
    @ResponseBody
    public ResultModel<Object> handleExceptionInternal(Exception e) {
        var result = new ResultModel<Object>();
        result.setCode(-1);
        result.setMessage(e.getMessage());
        result.setData(e);
        return result;
    }
}
