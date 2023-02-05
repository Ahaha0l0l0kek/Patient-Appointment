package ru.bychkov.patientappointment.service;

import ru.bychkov.patientappointment.controller.dto.AppointmentByPatientDto;
import ru.bychkov.patientappointment.controller.dto.FreeAppointmentsDto;

import java.util.List;

public interface AppointmentService {
    List<FreeAppointmentsDto> checkFreeDoctorAppointments(long doctorId, String date);
    AppointmentByPatientDto takeAppointment(long appId, long patientId);
    List<AppointmentByPatientDto> getAppointmentsByPatientId(long patientId);
}
