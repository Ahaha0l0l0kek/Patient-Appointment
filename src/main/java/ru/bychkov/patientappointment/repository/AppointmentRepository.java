package ru.bychkov.patientappointment.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import ru.bychkov.patientappointment.entity.Appointment;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface AppointmentRepository extends JpaRepository<Appointment, Long> {

    @Query(value = "select * from appointment where doctor_id = :doctorId and app_date = :date",
            nativeQuery = true)
    List<Appointment> getByDoctorIdAndDate(long doctorId, LocalDate date);

    List<Appointment> getByPatientId(long patientId);

    @Transactional
    @Modifying(clearAutomatically = true)
    @Query(value = "update appointment set patient_id = :patientId where id = :id",
            nativeQuery = true)
    void registerPatientByAppId(long id, long patientId);
}
