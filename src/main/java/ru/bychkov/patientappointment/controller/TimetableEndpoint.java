package ru.bychkov.patientappointment.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;
import ru.bychkov.patientappointment.CreateTimetableRequest;
import ru.bychkov.patientappointment.CreateTimetableResponse;
import ru.bychkov.patientappointment.service.TimetableService;

@Endpoint
@RequiredArgsConstructor
public class TimetableEndpoint {

    private final TimetableService timetableService;

    @PayloadRoot(namespace = "http://projects.my/ws", localPart = "CreateTimetableRequest")
    @ResponsePayload
    public CreateTimetableResponse createTimetable(@RequestPayload CreateTimetableRequest request) {
        return timetableService.createTimetable(request);
    }
}
