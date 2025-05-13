package br.com.projeto.DoctorLink.repositories;

import br.com.projeto.DoctorLink.models.Doctor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DoctorRepository extends JpaRepository<Doctor, Long> {
}
