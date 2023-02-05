package ru.bychkov.patientappointment.exception;

public class TakenAppException extends RuntimeException {
    public TakenAppException() {
        super("This appointment was taken");
    }
}
