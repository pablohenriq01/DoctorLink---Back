package br.com.projeto.DoctorLink.services;

import br.com.projeto.DoctorLink.DTOs.PatientDTO;
import br.com.projeto.DoctorLink.DTOs.PatientResponseDTO;
import br.com.projeto.DoctorLink.models.Patient;
import br.com.projeto.DoctorLink.models.User;
import br.com.projeto.DoctorLink.repositories.PatientRepository;
import br.com.projeto.DoctorLink.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PatientService {
    @Autowired
    PatientRepository patientRepository;
    @Autowired
    UserRepository userRepository;

    public PatientResponseDTO register(PatientDTO patientDTO) {
        User user = new User(patientDTO.email(), patientDTO.password(), 1);
        userRepository.save(user);

        Patient patient = new Patient();
        patient.setUser(user);
        patient.setName(patientDTO.name());
        patient.setDateBirth(patientDTO.dateBirth());
        patient.setTelephone(patientDTO.telephone());

        patientRepository.save(patient);

        return new PatientResponseDTO(
                patient.getName(),
                user.getEmail(),
                patient.getDateBirth(),
                patient.getTelephone());
    }
}

