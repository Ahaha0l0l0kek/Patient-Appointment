package ru.bychkov.patientappointment.exception;

public class TakenAppException extends RuntimeException {
    public TakenAppException(String message) {
        super("This appointment was taken");
    }
}
