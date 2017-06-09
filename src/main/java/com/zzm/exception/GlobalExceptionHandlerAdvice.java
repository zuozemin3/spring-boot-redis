package com.zzm.exception;

import com.zzm.utils.ResultBuilder;
import com.zzm.utils.ResultVo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@Slf4j
@RestControllerAdvice
public class GlobalExceptionHandlerAdvice {

  @ExceptionHandler(IllegalArgumentException.class)
  public ResultVo handlerIllegalArgumentException(IllegalArgumentException exception) {
    return ResultBuilder.buildFail(exception.getMessage(), "999");
  }

  @ExceptionHandler(value = {NullPointerException.class})
  public ResultVo handlerRuntimeException(RuntimeException exception) {
    log.error(exception.getMessage(), exception);
    return ResultBuilder.buildFail("Internal Server Error", "500");
  }

  @ExceptionHandler(value = {Exception.class})
  public ResultVo handlerException(Exception exception) {
    log.error(exception.getMessage(), exception);
    return ResultBuilder.buildFail("Internal Server Error", "500");
  }
}
