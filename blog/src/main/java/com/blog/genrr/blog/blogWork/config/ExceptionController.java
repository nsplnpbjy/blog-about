package com.blog.genrr.blog.blogWork.config;

import com.blog.genrr.blog.blogWork.exceptionType.NonSearchResultException;
import com.blog.genrr.blog.blogWork.dto.ResponseData;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.sql.SQLIntegrityConstraintViolationException;

/**
 * @author nsplnpbjy
 */
@RestControllerAdvice
public class ExceptionController {

    @ExceptionHandler(NonSearchResultException.class)
    public ResponseData nonSearchResultException(NonSearchResultException e){
        return ResponseData.bad(e);
    }

    @ExceptionHandler(SQLIntegrityConstraintViolationException.class)
    public ResponseData SQLIntegrityConstraintViolationException(SQLIntegrityConstraintViolationException e){
        return ResponseData.bad(e);
    }

}
