package ru.bychkov.patientappointment.service.impl;

import lombok.RequiredArgsConstructor;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Service;
import ru.bychkov.patientappointment.CreateTimetableRequest;
import ru.bychkov.patientappointment.CreateTimetableResponse;
import ru.bychkov.patientappointment.entity.Appointment;
import ru.bychkov.patientappointment.repository.AppointmentRepository;
import ru.bychkov.patientappointment.repository.DoctorRepository;
import ru.bychkov.patientappointment.service.TimetableService;

import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;

@Service
@RequiredArgsConstructor
public class TimetableServiceImpl implements TimetableService {

    private static final Logger logger = LogManager.getLogger(TimetableServiceImpl.class);

    private final AppointmentRepository appointmentRepository;
    private final DoctorRepository doctorRepository;

    @Override
    public CreateTimetableResponse createTimetable(CreateTimetableRequest request) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm Z");
        CreateTimetableResponse createTimetableResponse = new CreateTimetableResponse();
        for (CreateTimetableRequest.Doctor doctor: request.getDoctor()) {

            ZonedDateTime startTime = ZonedDateTime.parse(request.getDate() + " " + request.getStartTime() + " +0300", formatter);
            long endTimeUnix = ZonedDateTime.parse(request.getDate() + " " + request.getEndTime() + " +0300", formatter).toEpochSecond();

            while (startTime.toEpochSecond() < endTimeUnix) {
                appointmentRepository.save(Appointment
                        .builder()
                        .date(startTime.toLocalDate())
                        .datetime(startTime)
                        .doctor(doctorRepository.getReferenceById(doctor.getId()))
                        .build());
                startTime = startTime.plusMinutes(30);
            }
        }

        createTimetableResponse.setIsCreated(true);
        return createTimetableResponse;
    }
}
