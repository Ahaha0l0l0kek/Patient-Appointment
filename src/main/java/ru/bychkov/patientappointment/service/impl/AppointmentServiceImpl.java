package ru.bychkov.patientappointment.service.impl;

import lombok.RequiredArgsConstructor;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Service;
import ru.bychkov.patientappointment.controller.dto.AppointmentDto;
import ru.bychkov.patientappointment.entity.Appointment;
import ru.bychkov.patientappointment.exception.TakenAppException;
import ru.bychkov.patientappointment.repository.AppointmentRepository;
import ru.bychkov.patientappointment.repository.DoctorRepository;
import ru.bychkov.patientappointment.repository.PatientRepository;
import ru.bychkov.patientappointment.service.AppointmentService;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class AppointmentServiceImpl implements AppointmentService {

    private static final Logger logger = LogManager.getLogger(AppointmentServiceImpl.class);

    private final AppointmentRepository appointmentRepository;

    @Override
    public List<AppointmentDto> checkFreeDoctorAppointments(long doctorId, String date) {
        List<AppointmentDto> appointmentDtos = new ArrayList<>();
        List<Appointment> appointments = appointmentRepository.getByDoctorIdAndDate(doctorId, LocalDate.parse(date));
        for (Appointment appointment : appointments) {
            appointmentDtos.add(new AppointmentDto(appointment.getDatetime()));
        }
        return appointmentDtos;
    }

    @Override
    public AppointmentDto takeAppointment(long appId, long patientId) {
        if(appointmentRepository.getReferenceById(appId).getPatient() != null) {
            throw new TakenAppException();
        } else {
            appointmentRepository.registerPatientByAppId(appId, patientId);
            return new AppointmentDto(appointmentRepository.getReferenceById(appId).getDatetime());
        }
    }

    @Override
    public List<AppointmentDto> getAppointmentsByPatientId(long patientId) {
        List<AppointmentDto> appointmentDtos = new ArrayList<>();
        List<Appointment> appointments = appointmentRepository.getByPatientId(patientId);
        for (Appointment appointment : appointments) {
            appointmentDtos.add(new AppointmentDto(appointment.getDatetime()));
        }
        return appointmentDtos;
    }
}
