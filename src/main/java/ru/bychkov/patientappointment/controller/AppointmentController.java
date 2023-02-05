package ru.bychkov.patientappointment.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.media.ArraySchema;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import ru.bychkov.patientappointment.controller.dto.AppointmentByPatientDto;
import ru.bychkov.patientappointment.controller.dto.FreeAppointmentsDto;
import ru.bychkov.patientappointment.exception.MyException;
import ru.bychkov.patientappointment.service.AppointmentService;

import java.util.List;

@RestController
@RequestMapping("/appointment")
@RequiredArgsConstructor
public class AppointmentController {
    private final AppointmentService appointmentService;

    @Operation(
            summary = "Получение списка свободных записей ко врачу по его id и дате"
    )
    @GetMapping("/doctor/{doctorId}")
    public ResponseEntity<List<FreeAppointmentsDto>> checkDoctorAppointments(@PathVariable long doctorId,
                                                                             @Parameter(description = "Формат даты: yyyy-MM-dd", example = "2023-02-02") @RequestParam String date) {
        return new ResponseEntity<>(appointmentService.checkFreeDoctorAppointments(doctorId, date), HttpStatus.OK);
    }

    @Operation(
            summary = "Занятие слота времени по его id и id пациента"
    )
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Возвращает время записи и информацию по доктору и пациенту",
                    content = @Content(mediaType = "application/json", array = @ArraySchema(schema = @Schema(implementation = AppointmentByPatientDto.class)))),
            @ApiResponse(responseCode = "409", description = "Запись занята, возвращает ответ с ошибкой",
                    content = @Content(mediaType = "application/json", schema = @Schema(implementation = MyException.class))),
    })
    @GetMapping("/{appId}")
    public ResponseEntity<AppointmentByPatientDto> takeAppointment(@PathVariable long appId,
                                                               @RequestParam("patient") long patientId) {
        return new ResponseEntity<>(appointmentService.takeAppointment(appId, patientId), HttpStatus.OK);
    }

    @Operation(
            summary = "Получение всех записей пациента по его id"
    )
    @GetMapping("/patient/{patientId}")
    public ResponseEntity<List<AppointmentByPatientDto>> getAppointmentsByPatientId(@PathVariable long patientId) {
        return new ResponseEntity<>(appointmentService.getAppointmentsByPatientId(patientId), HttpStatus.OK);
    }
}
