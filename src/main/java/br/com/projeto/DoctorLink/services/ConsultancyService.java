package br.com.projeto.DoctorLink.services;

import br.com.projeto.DoctorLink.DTOs.ConsultancyDTO;
import br.com.projeto.DoctorLink.DTOs.ConsultancyResponseDTO;
import br.com.projeto.DoctorLink.models.Consultancy;
import br.com.projeto.DoctorLink.models.User;
import br.com.projeto.DoctorLink.repositories.ConsultancyRepository;
import br.com.projeto.DoctorLink.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ConsultancyService {
    @Autowired
    UserRepository userRepository;
    @Autowired
    ConsultancyRepository doctorRepository;

    public ConsultancyResponseDTO create(ConsultancyDTO consultancyDTO) {
        User user = new User(consultancyDTO.email(), consultancyDTO.password(),2);
        userRepository.save(user);

        Consultancy consultancy = new Consultancy();
        consultancy.setNameConsultancy(consultancyDTO.nameConsultancy());
        consultancy.setUser(user);
        consultancy.setSpecialty(consultancyDTO.specialty());
        consultancy.setStartTime(consultancyDTO.startTime());
        consultancy.setEndTime(consultancyDTO.endTime());
        doctorRepository.save(consultancy);

        return new ConsultancyResponseDTO(
                consultancy.getNameConsultancy(),
                user.getEmail(),
                consultancy.getSpecialty(),
                consultancy.getStartTime(),
                consultancy.getEndTime());
    }
}
