package ru.bychkov.patientappointment.controller.dto;

import ru.bychkov.patientappointment.entity.Doctor;
import ru.bychkov.patientappointment.entity.Patient;

import java.time.ZonedDateTime;

public record AppointmentByPatientDto(Patient patient, ZonedDateTime time, Doctor doctor) {
}
