package uz.al_jamoa.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;

import java.time.LocalDateTime;

@RestControllerAdvice()
public class ExceptionHandler {
    @org.springframework.web.bind.annotation.ExceptionHandler({UniversalException.class})
    public ResponseEntity<?> universalExceptionHandler(UniversalException exception, WebRequest webRequest) {
        return new ResponseEntity<>(exception.getMessage(), HttpStatus.valueOf(exception.getStatus()));
    }
}
