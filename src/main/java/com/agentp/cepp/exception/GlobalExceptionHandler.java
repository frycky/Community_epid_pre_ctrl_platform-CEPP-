package com.agentp.cepp.exception;

import com.agentp.cepp.common.Result;
import lombok.extern.slf4j.Slf4j;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.List;

@RestControllerAdvice
@Slf4j
public class GlobalExceptionHandler {
    /**
     * 运行时异常处理
     */
    @ExceptionHandler(RuntimeException.class)
    public Result<?> exceptionHandler() {
        return Result.error();
    }

    @ExceptionHandler(value = CustomException.class)
    public Result<?> CustomExceptionHandler(CustomException e) {
        log.error("错误原因为：" + e.getMessage());
        return Result.error(e.getCode(), e.getMessage());

    }

    @ExceptionHandler(value = MethodArgumentNotValidException.class)
    public Result<?> MethodArgumentNotValidExceptionHandler(MethodArgumentNotValidException e) {
        List<FieldError> fieldErrors = e.getFieldErrors();
        String defaultMessage = fieldErrors.get(0).getDefaultMessage();
        log.error("错误原因为：" + defaultMessage);
        return Result.error(defaultMessage);

    }
}
