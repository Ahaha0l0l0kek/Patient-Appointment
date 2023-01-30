package ru.bychkov.patientappointment.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

import java.time.LocalDateTime;

@Entity
public class Appointment {
    @Id
    long id;

    @ManyToOne
    @JoinColumn(name = "doctor_ID")
    Doctor doctor;

    @ManyToOne
    @JoinColumn(name = "patient_ID")
    Patient patient;

    LocalDateTime time;

    public Patient getPatient() {
        return patient;
    }

    public Doctor getDoctor() {
        return doctor;
    }
}
