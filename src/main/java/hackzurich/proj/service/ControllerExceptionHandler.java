package hackzurich.proj.service;

import hackzurich.proj.model.exception.FoodNotFoundException;
import hackzurich.proj.model.exception.OrderNotFoundException;
import hackzurich.proj.model.exception.UserExistingException;
import hackzurich.proj.model.exception.UserNotFoundException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;

@ControllerAdvice
@Slf4j
public class ControllerExceptionHandler {
    @ResponseStatus(HttpStatus.NOT_FOUND)
    @ExceptionHandler({UserNotFoundException.class})
    public void handleUserNotFound() {
        //No scenarios for handling this exception. Only returning http response
    }

    @ResponseStatus(HttpStatus.NOT_FOUND)
    @ExceptionHandler({OrderNotFoundException.class})
    public void handleOrderNotFound() {
        //No scenarios for handling this exception. Only returning http response
    }

    @ResponseStatus(HttpStatus.NOT_ACCEPTABLE)
    @ExceptionHandler({FoodNotFoundException.class})
    public void handleFoodNotFound() {
        //No scenarios for handling this exception. Only returning http response
    }

    @ResponseStatus(HttpStatus.FOUND)
    @ExceptionHandler({UserExistingException.class})
    public void handleExistingUser() {
        //No scenarios for handling this exception. Only returning http response
    }
}
