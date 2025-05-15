package br.com.projeto.DoctorLink.controllers;

import br.com.projeto.DoctorLink.DTOs.LoginUserDTO;
import br.com.projeto.DoctorLink.repositories.UserRepository;
import br.com.projeto.DoctorLink.services.UserService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/user")
@CrossOrigin(origins = "http://127.0.0.1:5500")
public class UserController {
    @Autowired
    UserService userService;

    @PostMapping("/login")
    public ResponseEntity<?> login(@Valid @RequestBody LoginUserDTO loginUserDTO) {
        boolean validation = userService.validateLogin(loginUserDTO);

        if (validation) {
            return new ResponseEntity<>("Acesso liberado.",
                    HttpStatus.ACCEPTED);
        }
        return new ResponseEntity<>("email ou senha incorretos, tente novamente."
                ,HttpStatus.UNAUTHORIZED);

    }
}
