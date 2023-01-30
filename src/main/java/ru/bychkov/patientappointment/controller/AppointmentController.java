package ru.bychkov.patientappointment.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.bychkov.patientappointment.entity.Appointment;

import java.time.LocalDate;
import java.util.List;

@RestController
public class AppointmentController {
    @GetMapping
    public ResponseEntity<List<Appointment>> checkDoctorAppointments(long doctorId, LocalDate date){
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Appointment> takeAppointment(long appId){
        return new ResponseEntity<>(HttpStatus.OK);
    }
    
    @GetMapping
    public ResponseEntity<List<Appointment>> getAppointmentsByPatientId(long patientId){
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
