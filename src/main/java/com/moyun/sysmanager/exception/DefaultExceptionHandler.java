package com.moyun.sysmanager.exception;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.moyun.sysmanager.common.result.Result;
import com.moyun.sysmanager.common.result.ResultEnum;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import javax.validation.ConstraintViolation;
import javax.validation.ConstraintViolationException;
import javax.validation.Path;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.http.HttpStatus;
import org.springframework.validation.BindException;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.List;

@Slf4j
@RestControllerAdvice
@Order(value = Ordered.HIGHEST_PRECEDENCE)
public class DefaultExceptionHandler {

  @ExceptionHandler(value = Exception.class)
  @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
  public Result handleException(Exception e) {
    log.error("internal exception, error msg: {}", e.getMessage());
    return Result.of(ResultEnum.SERVER_ERROR, e.getMessage());
  }

  @ExceptionHandler(value = JsonProcessingException.class)
  @ResponseStatus(HttpStatus.BAD_REQUEST)
  public Result handleJsonException(JsonProcessingException e) {
    log.error("json error: {}", e.getMessage());
    return Result.of(ResultEnum.BAD_REQUEST, "json parser error");
  }

  @ExceptionHandler(BindException.class)
  @ResponseStatus(HttpStatus.BAD_REQUEST)
  public Result validExceptionHandler(BindException e) {
    StringBuilder sb = new StringBuilder();
    List<FieldError> fieldErrors = e.getBindingResult().getFieldErrors();
    for (FieldError error : fieldErrors) {
      sb.append(error.getField()).append(error.getDefaultMessage()).append(",");
    }
    sb = new StringBuilder(sb.substring(0, sb.length() - 1));
    return Result.of(ResultEnum.SERVER_ERROR, sb.toString());
  }

  @ExceptionHandler(value = ConstraintViolationException.class)
  @ResponseStatus(HttpStatus.BAD_REQUEST)
  public Result handleConstraintViolationException(ConstraintViolationException e) {
    StringBuilder sb = new StringBuilder();
    Set<ConstraintViolation<?>> violations = e.getConstraintViolations();
    for (ConstraintViolation<?> violation : violations) {
      Path path = violation.getPropertyPath();
      String[] pathArr = StringUtils.splitByWholeSeparatorPreserveAllTokens(path.toString(), ".");
      sb.append(pathArr[1]).append(violation.getMessage()).append(",");
    }
    sb = new StringBuilder(sb.substring(0, sb.length() - 1));
    return Result.of(ResultEnum.SERVER_ERROR, sb.toString());
  }



}
