package ru.bychkov.patientappointment.service;

import ru.bychkov.patientappointment.controller.dto.AppointmentDto;
import ru.bychkov.patientappointment.entity.Appointment;

import java.time.LocalDate;
import java.util.List;

public interface AppointmentService {
    List<AppointmentDto> checkFreeDoctorAppointments(long doctorId, String date);
    AppointmentDto takeAppointment(long appId, long patientId);
    List<AppointmentDto> getAppointmentsByPatientId(long patientId);
}
