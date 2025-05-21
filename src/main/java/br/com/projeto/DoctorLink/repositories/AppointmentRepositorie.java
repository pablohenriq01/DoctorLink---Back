package br.com.projeto.DoctorLink.repositories;

import br.com.projeto.DoctorLink.models.Appointment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.UUID;

public interface AppointmentRepositorie extends JpaRepository<Appointment, UUID> {
    @Query("SELECT a FROM Appointment a WHERE a.patient.id = :id")
    List<Appointment> findByPatientId(@Param("id") Long id);

    @Query("SELECT a FROM Appointment a WHERE a.consultancy.id = :consultancyId")
    List<Appointment> findByConsultancyId(@Param("consultancyId") Long consultancyId);
}
