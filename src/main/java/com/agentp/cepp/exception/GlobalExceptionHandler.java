package com.agentp.cepp.exception;

import com.agentp.cepp.common.Result;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
@Slf4j
public class GlobalExceptionHandler {
    /**
     * 运行时异常处理
     */
    @ExceptionHandler(RuntimeException.class)
    public Result<?> exceptionHandler(){
        return Result.error();
    }
    @ExceptionHandler(value = CustomException.class)
    public Result<?> CustomExceptionHandler(CustomException e){
        log.error("错误原因为："+e.getMessage());
        return Result.error(e.getCode(),e.getMessage());

    }
}
