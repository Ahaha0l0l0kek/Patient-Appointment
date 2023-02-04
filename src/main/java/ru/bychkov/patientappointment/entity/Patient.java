package ru.bychkov.patientappointment.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.UuidGenerator;

import java.time.LocalDateTime;
import java.util.UUID;

@Entity
public class Patient {
    @Id
    long id;

    UUID uuid;

    String name;

    LocalDateTime birthday;

    String phoneNumber;
}
