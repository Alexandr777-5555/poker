package shop.web.controllers;


import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;


@ControllerAdvice
public class GlobalExceptionController {




    @ExceptionHandler(Exception.class)
    public void handleException() {


    }


}
