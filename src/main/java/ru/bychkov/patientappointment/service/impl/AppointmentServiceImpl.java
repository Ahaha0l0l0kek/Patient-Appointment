package ru.bychkov.patientappointment.service.impl;

import lombok.RequiredArgsConstructor;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Service;
import ru.bychkov.patientappointment.entity.Appointment;
import ru.bychkov.patientappointment.exception.AppExceptionHandler;
import ru.bychkov.patientappointment.repository.AppointmentRepository;
import ru.bychkov.patientappointment.repository.DoctorRepository;
import ru.bychkov.patientappointment.repository.PatientRepository;
import ru.bychkov.patientappointment.service.AppointmentService;

import java.time.LocalDate;
import java.util.List;

@Service
@RequiredArgsConstructor
public class AppointmentServiceImpl implements AppointmentService {

    private static final Logger logger = LogManager.getLogger(AppointmentServiceImpl.class);

    private final AppointmentRepository appointmentRepository;
    private final PatientRepository patientRepository;
    private final DoctorRepository doctorRepository;

    @Override
    public List<Appointment> checkFreeDoctorAppointments(long doctorId, LocalDate date) {
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
