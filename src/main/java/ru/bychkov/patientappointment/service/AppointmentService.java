package ru.bychkov.patientappointment.service;

import org.springframework.stereotype.Service;
import ru.bychkov.patientappointment.entity.Appointment;

import java.time.LocalDate;
import java.util.List;

@Service
public interface AppointmentService {
    List<Appointment> checkDoctorAppointments(long doctorId, LocalDate date);
    Appointment takeAppointment(long appId);
    List<Appointment> getAppointmentsByPatientId(long patientId);
}
