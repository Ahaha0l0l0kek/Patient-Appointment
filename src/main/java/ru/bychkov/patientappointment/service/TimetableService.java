package ru.bychkov.patientappointment.service;

import ru.bychkov.patientappointment.CreateTimetableRequest;
import ru.bychkov.patientappointment.CreateTimetableResponse;

public interface TimetableService {
    CreateTimetableResponse createTimetable(CreateTimetableRequest request);
}
