package ru.bychkov.patientappointment.service.impl;

import lombok.RequiredArgsConstructor;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Service;
import ru.bychkov.patientappointment.controller.dto.AppointmentByPatientDto;
import ru.bychkov.patientappointment.controller.dto.FreeAppointmentsDto;
import ru.bychkov.patientappointment.entity.Appointment;
import ru.bychkov.patientappointment.exception.TakenAppException;
import ru.bychkov.patientappointment.repository.AppointmentRepository;
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
    public List<FreeAppointmentsDto> checkFreeDoctorAppointments(long doctorId, String date) {
        List<FreeAppointmentsDto> appointmentDtos = new ArrayList<>();
        List<Appointment> appointments = appointmentRepository.getByDoctorIdAndDate(doctorId, LocalDate.parse(date));
        for (Appointment appointment : appointments) {
            appointmentDtos.add(new FreeAppointmentsDto(appointment.getDoctor(),
                    appointment.getDatetime()));
        }
        return appointmentDtos;
    }

    @Override
    public AppointmentByPatientDto takeAppointment(long appId, long patientId) {
        if(appointmentRepository.getReferenceById(appId).getPatient() != null) {
            throw new TakenAppException();
        } else {
            appointmentRepository.registerPatientByAppId(appId, patientId);
            Appointment appointment = appointmentRepository.getReferenceById(appId);
            return new AppointmentByPatientDto(appointment.getPatient(),
                    appointment.getDatetime(),
                    appointment.getDoctor());
        }
    }

    @Override
    public List<AppointmentByPatientDto> getAppointmentsByPatientId(long patientId) {
        List<AppointmentByPatientDto> appointmentDtos = new ArrayList<>();
        List<Appointment> appointments = appointmentRepository.getByPatientId(patientId);
        for (Appointment appointment : appointments) {
            appointmentDtos.add(new AppointmentByPatientDto(appointment.getPatient(),
                    appointment.getDatetime(),
                    appointment.getDoctor()));
        }
        return appointmentDtos;
    }
}
