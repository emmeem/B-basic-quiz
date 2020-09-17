package com.thoughtworks.capacity.gtb.mvc.Interceptor;
// GTB: - ↑ package name 叫 Interceptor 合适吗？
import com.thoughtworks.capacity.gtb.mvc.Error.ErrorResult;
import com.thoughtworks.capacity.gtb.mvc.Exception.EducationInfoIsNotExist;
import com.thoughtworks.capacity.gtb.mvc.Exception.UserNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.text.SimpleDateFormat;
import java.util.Date;

@ControllerAdvice
public class GlobalExceptionHandler {
    SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<ErrorResult> handler(MethodArgumentNotValidException ex) {
        String message = ex.getBindingResult().getFieldError().getDefaultMessage();
        ErrorResult errorResult = new ErrorResult(df.format(new Date()),400,"Bad Request",message);
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(errorResult);
    }

    @ExceptionHandler({UserNotFoundException.class, EducationInfoIsNotExist.class})
    public ResponseEntity<ErrorResult> handler(Exception ex) {
        ErrorResult errorResult = new ErrorResult(df.format(new Date()),404,"Not found",ex.getMessage());
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(errorResult);
    }

}
