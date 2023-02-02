package ru.bychkov.patientappointment.exception;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import org.springframework.http.HttpStatus;

import java.time.ZonedDateTime;

@Getter
@AllArgsConstructor
@Builder
public class MyException {
    private final String message;
    private final HttpStatus httpStatus;
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "MM/dd/yyyy - HH:mm:ss Z")
    private final ZonedDateTime time;
}

