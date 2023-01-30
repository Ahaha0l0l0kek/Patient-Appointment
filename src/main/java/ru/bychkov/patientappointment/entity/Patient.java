package ru.bychkov.patientappointment.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

import java.time.LocalDateTime;

@Entity
public class Patient {
    @Id
    long id;

    long uuid;

    String name;

    LocalDateTime birthday;
}
