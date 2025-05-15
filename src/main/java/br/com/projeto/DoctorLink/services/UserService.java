package br.com.projeto.DoctorLink.services;

import br.com.projeto.DoctorLink.DTOs.LoginUserDTO;
import br.com.projeto.DoctorLink.models.User;
import br.com.projeto.DoctorLink.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.Optional;

@Service
public class UserService {
    @Autowired
    UserRepository userRepository;

    public boolean validateLogin(LoginUserDTO loginUserDTO) {

        User user = userRepository.findByEmail(loginUserDTO.email());

        if(user!= null && loginUserDTO.password().equals(user.getPassword())) {
            return true;
        }
        return false;

    }
}
