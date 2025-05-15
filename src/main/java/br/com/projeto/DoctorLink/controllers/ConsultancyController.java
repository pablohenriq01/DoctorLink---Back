package br.com.projeto.DoctorLink.controllers;

import br.com.projeto.DoctorLink.DTOs.ConsultancyDTO;
import br.com.projeto.DoctorLink.services.ConsultancyService;
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
@RequestMapping("/doctor")
@CrossOrigin(origins = "http://127.0.0.1:5500")
public class ConsultancyController {
    @Autowired
    ConsultancyService consultancyService;

    @PostMapping("/register")
    public ResponseEntity<?> register(@Valid @RequestBody ConsultancyDTO consultancyDTO) {
        try {
            consultancyService.create(consultancyDTO);
            return new ResponseEntity<>("Cadastrado com sucesso.", HttpStatus.ACCEPTED);
        } catch (Exception e) {

            return new ResponseEntity<>("Não foi possivel cadastrar o consultorio. Email ja cadastrado ou informações invalidas."
                    ,HttpStatus.BAD_REQUEST);
        }
    }
}
