package ru.bychkov.patientappointment.service.impl;

import ru.bychkov.patientappointment.entity.Appointment;
import ru.bychkov.patientappointment.service.AppointmentService;

import java.time.LocalDate;
import java.util.List;

public class AppointmentServiceImpl implements AppointmentService {
    @Override
    public List<Appointment> checkDoctorAppointments(long doctorId, LocalDate date) {
        return null;
    }

    @Override
    public Appointment takeAppointment(long appId) {
        return null;
    }

    @Override
    public List<Appointment> getAppointmentsByPatientId(long patientId) {
        return null;
    }
}
