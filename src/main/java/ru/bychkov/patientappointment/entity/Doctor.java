package ru.bychkov.patientappointment.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.Id;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.FieldDefaults;
import ru.bychkov.patientappointment.entity.enums.SpecializationEnum;

@Entity
@Getter
@Setter
@FieldDefaults(level = AccessLevel.PRIVATE)
@NoArgsConstructor
public class Doctor {
    @Id
    long id;

    long uuid;

    String name;

    @Enumerated(EnumType.STRING)
    SpecializationEnum specialization;
}
