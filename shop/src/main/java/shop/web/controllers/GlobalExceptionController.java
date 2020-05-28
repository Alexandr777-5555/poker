package shop.web.controllers;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.servlet.ModelAndView;


@ControllerAdvice
public class GlobalExceptionController {

    private final Logger log = LoggerFactory.getLogger(this.getClass());


    //@ResponseStatus(value = HttpStatus.NOT_FOUND)
    // @ExceptionHandler(Exception.class)
    public void handleException() {
        // log.info("exeption");
    }

    //@ResponseStatus(value = HttpStatus.NOT_FOUND)
    @ExceptionHandler(Exception.class)
    public ModelAndView handleAllException(Exception error) {
        ModelAndView model = new ModelAndView("errors/error");
        model.addObject("err" , error.getMessage());
        return model;
    }


}
