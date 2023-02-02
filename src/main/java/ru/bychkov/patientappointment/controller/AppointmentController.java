package ru.bychkov.patientappointment.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.bychkov.patientappointment.entity.Appointment;
import ru.bychkov.patientappointment.service.AppointmentService;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("/appointment")
@RequiredArgsConstructor
public class AppointmentController {
    private final AppointmentService appointmentService;

    @GetMapping("/doctor/{doctorId}")
    public ResponseEntity<List<Appointment>> checkDoctorAppointments(@PathVariable long doctorId,
                                                                     @RequestParam LocalDate date) {
        return new ResponseEntity<>(appointmentService.checkFreeDoctorAppointments(doctorId, date), HttpStatus.OK);
    }

    @PostMapping("/{appId}")
    public ResponseEntity<Appointment> takeAppointment(@PathVariable long appId) {
        return new ResponseEntity<>(appointmentService.takeAppointment(appId), HttpStatus.OK);
    }
    
    @GetMapping("/patient/{patientId}")
    public ResponseEntity<List<Appointment>> getAppointmentsByPatientId(@PathVariable long patientId) {
        return new ResponseEntity<>(appointmentService.getAppointmentsByPatientId(patientId), HttpStatus.OK);
    }
}
