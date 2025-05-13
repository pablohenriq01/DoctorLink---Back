package br.com.projeto.DoctorLink.repositories;

import br.com.projeto.DoctorLink.models.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
}
