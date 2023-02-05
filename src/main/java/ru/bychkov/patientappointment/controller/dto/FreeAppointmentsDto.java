package ru.bychkov.patientappointment.controller.dto;

import ru.bychkov.patientappointment.entity.Doctor;

import java.time.ZonedDateTime;

public record FreeAppointmentsDto(Doctor doctor, ZonedDateTime time) {}
