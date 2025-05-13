package br.com.projeto.DoctorLink.services;

import br.com.projeto.DoctorLink.DTOs.DoctorDTO;
import br.com.projeto.DoctorLink.DTOs.DoctorResponseDTO;
import br.com.projeto.DoctorLink.models.Doctor;
import br.com.projeto.DoctorLink.models.User;
import br.com.projeto.DoctorLink.repositories.DoctorRepository;
import br.com.projeto.DoctorLink.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DoctorService {
    @Autowired
    UserRepository userRepository;
    @Autowired
    DoctorRepository doctorRepository;

    public DoctorResponseDTO createDoctor(DoctorDTO doctorDTO) {
        User user = new User(doctorDTO.name(), doctorDTO.email(), doctorDTO.password(),2);
        userRepository.save(user);

        Doctor doctor = new Doctor();
        doctor.setUser(user);
        doctor.setSpecialty(doctorDTO.specialty());
        doctor.setStartTime(doctorDTO.startTime());
        doctor.setEndTime(doctorDTO.endTime());
        doctorRepository.save(doctor);

        return new DoctorResponseDTO(
                user.getName(),
                user.getEmail(),
                doctor.getSpecialty(),
                doctor.getStartTime(),
                doctor.getEndTime());
    }
}
