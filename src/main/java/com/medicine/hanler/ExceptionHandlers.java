package com.medicine.hanler;


import com.medicine.common.Result;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;


@ControllerAdvice
@Slf4j
public class ExceptionHandlers extends ResponseEntityExceptionHandler {


    public ExceptionHandlers() {
        super();
    }

    @ExceptionHandler({Exception.class})
    public ResponseEntity handle(final RuntimeException ex, final WebRequest request) {

        // 系统异常打印error日志
        log.error("medicine server error {}", ex);
        Result result = new Result(500,
                "服务器忙");
        return handleExceptionInternal(ex, result, new HttpHeaders(), HttpStatus.OK, request);
    }

}
