package com.chanpion.admin.config;

import com.chanpion.admin.common.BaseResponse;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @author April Chen
 * @date 2020/8/15 18:27
 */
@ControllerAdvice
public class GlobalExceptionAdvice {

    @ExceptionHandler(Exception.class)
    @ResponseBody
    public BaseResponse global(Exception e) {
        return BaseResponse.error(e.getMessage());
    }
}
