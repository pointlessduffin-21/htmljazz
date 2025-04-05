package com.yeems214.assignment5.exception;

import java.time.LocalDateTime;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class StoreExceptionHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler(StoreNotFoundException.class)
    public ModelAndView handleStoreNotFoundException(StoreNotFoundException ex, WebRequest webRequest) {
        ExceptionResponse response = new ExceptionResponse();
        response.setDateTime(LocalDateTime.now());
        response.setMessage(ex.getMessage());
        response.setDescription("No Data Found");
        ModelAndView model = new ModelAndView();
        model.addObject("message", response.getMessage());
        model.addObject("description", response.getDescription());
        model.addObject("dateTime", response.getDateTime());
        model.setViewName("error");
        return model;
    }

}
