package br.com.projeto.DoctorLink.repositories;

import br.com.projeto.DoctorLink.models.Consultancy;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ConsultancyRepository extends JpaRepository<Consultancy, Long> {
}
