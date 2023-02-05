package ru.bychkov.patientappointment.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import ru.bychkov.patientappointment.controller.dto.AppointmentDto;
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
    public ResponseEntity<List<AppointmentDto>> checkDoctorAppointments(@PathVariable long doctorId,
                                                                        @RequestParam String date) {
        return new ResponseEntity<>(appointmentService.checkFreeDoctorAppointments(doctorId, date), HttpStatus.OK);
    }

    @GetMapping("/{appId}")
    public ResponseEntity<AppointmentDto> takeAppointment(@PathVariable long appId,
                                                          @RequestParam("patient") long patientId) {
        return new ResponseEntity<>(appointmentService.takeAppointment(appId, patientId), HttpStatus.OK);
    }
    
    @GetMapping("/patient/{patientId}")
    public ResponseEntity<List<AppointmentDto>> getAppointmentsByPatientId(@PathVariable long patientId) {
        return new ResponseEntity<>(appointmentService.getAppointmentsByPatientId(patientId), HttpStatus.OK);
    }
}
