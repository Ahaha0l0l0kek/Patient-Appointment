package ru.bychkov.patientappointment.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import ru.bychkov.patientappointment.entity.enums.Specialization;

@Entity
public class Doctor {
    @Id
    long id;

    long uuid;

    String name;

    Specialization specialization;
}
