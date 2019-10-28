package com.beiming.common.exception;

import java.util.stream.Collectors;

import javax.validation.ConstraintViolationException;
import javax.validation.Valid;
import javax.validation.ValidationException;

import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import com.beiming.common.enums.ResultCodeEnums;
import com.beiming.common.utils.ResultModel;

import lombok.extern.slf4j.Slf4j;

/**
 * 	统一异常捕获类
 *
 */
@ControllerAdvice
@ResponseBody
@Slf4j
public class DefaultExceptionHandler {
	
	@ExceptionHandler(Exception.class)
	public ResultModel processException(Exception e) {
		log.error("exception = { }", e);
		return ResultModel.fail(e);
	}
	
	//用于捕获接口参数绑定时的异常，@Valid抛出的异常
	@ExceptionHandler(MethodArgumentNotValidException.class)
	public ResultModel  processMethodArgumentNotValidException(MethodArgumentNotValidException e) {
		String message = e.getBindingResult().getAllErrors().stream().map(ObjectError::getDefaultMessage).collect(Collectors.joining(", "));
		log.error("methodArgumentNotValidException = {}", message);
		return ResultModel.fail(ResultCodeEnums.ILLEGAL_PARAMETER, message);
	}
	  @ExceptionHandler(ValidationException.class)
	  public ResultModel processValidationException(ValidationException e) {
	    log.error("validation error", e);
	    return ResultModel.fail(ResultCodeEnums.ILLEGAL_PARAMETER, e.getMessage());
	  }

	  @ExceptionHandler(ConstraintViolationException.class)
	  public ResultModel processConstraintViolationException(ConstraintViolationException e) {
	    StringBuilder sb = new StringBuilder();
	    e.getConstraintViolations().forEach(cv -> {
	      sb.append(cv.getMessage());
	    });
	    log.error("validation error {} ", sb.toString(), e);
	    return ResultModel.fail(ResultCodeEnums.ILLEGAL_PARAMETER, sb.toString());
	  }
}
