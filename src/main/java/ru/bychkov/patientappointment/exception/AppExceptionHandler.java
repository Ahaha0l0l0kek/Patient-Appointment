package ru.bychkov.patientappointment.exception;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.time.Clock;
import java.time.ZonedDateTime;

@ControllerAdvice
public class AppExceptionHandler {

    private static final Logger logger = LogManager.getLogger(AppExceptionHandler.class);

    @ExceptionHandler(value = {NotFoundException.class})
    public ResponseEntity<Object> handleNotFoundException(NotFoundException e) {
        HttpStatus badRequest = HttpStatus.NOT_FOUND;
        logger.error("Error caused by " + e);
        return new ResponseEntity<>(getException(e, badRequest), badRequest);
    }

    @ExceptionHandler(value = {TakenAppException.class})
    public ResponseEntity<Object> handleTakenAppException(TakenAppException e) {
        HttpStatus badRequest = HttpStatus.CONFLICT;
        logger.error("Error caused by " + e);
        return new ResponseEntity<>(getException(e, badRequest), badRequest);
    }

    public MyException getException(RuntimeException e, HttpStatus badRequest) {
        Clock cl = Clock.systemUTC();
        return MyException.builder()
                .message(e.getMessage())
                .httpStatus(badRequest)
                .time(ZonedDateTime.now(cl))
                .build();
    }

}
