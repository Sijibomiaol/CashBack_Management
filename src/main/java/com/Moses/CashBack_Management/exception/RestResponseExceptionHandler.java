package com.Moses.CashBack_Management.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.context.request.WebRequest;

@ControllerAdvice
@ResponseStatus
public class RestResponseExceptionHandler {

    @ExceptionHandler(RewardNotFoundException.class)

    public ResponseEntity<ErrorMessage> RewardNotFoundException(RewardNotFoundException rewardNotFoundException, WebRequest request){
        ErrorMessage message = new ErrorMessage(HttpStatus.NOT_FOUND, rewardNotFoundException.getMessage());
        return  ResponseEntity.status(HttpStatus.NOT_FOUND).body(message);
    }

}
