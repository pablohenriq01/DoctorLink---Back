package br.com.projeto.DoctorLink.repositories;

import br.com.projeto.DoctorLink.models.Patient;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PatientRepository extends JpaRepository<Patient, Long> {
}
