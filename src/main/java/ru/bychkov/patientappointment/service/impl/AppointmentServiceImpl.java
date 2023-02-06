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
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class AppointmentServiceImpl implements AppointmentService {

    private static final Logger logger = LogManager.getLogger(AppointmentServiceImpl.class);

    private final AppointmentRepository appointmentRepository;

    @Override
    public List<FreeAppointmentsDto> checkFreeDoctorAppointments(long doctorId, String date) {
        List<Appointment> appointments = appointmentRepository.getByDoctorIdAndDate(doctorId, LocalDate.parse(date));
        return appointments.stream()
                .filter(appointment -> appointment.getPatient() == null)
                .map(appointment -> new FreeAppointmentsDto(appointment.getDoctor(), appointment.getDatetime()))
                .collect(Collectors.toList());
    }

    @Override
    public AppointmentByPatientDto takeAppointment(long appId, long patientId) {
        if (appointmentRepository.getReferenceById(appId).getPatient() != null) {
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
        List<Appointment> appointments = appointmentRepository.getByPatientId(patientId);
        return appointments.stream()
                .map(appointment -> new AppointmentByPatientDto(appointment.getPatient(),
                        appointment.getDatetime(),
                        appointment.getDoctor()))
                .collect(Collectors.toList());
    }
}
