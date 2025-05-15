package br.com.projeto.DoctorLink.controllers;

import br.com.projeto.DoctorLink.DTOs.PatientDTO;
import br.com.projeto.DoctorLink.services.PatientService;
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
@RequestMapping("/patient")
@CrossOrigin(origins = "http://127.0.0.1:5500")
public class PatientController {
    @Autowired
    PatientService patientService;

    @PostMapping("/register")
    public ResponseEntity<?> register(@Valid @RequestBody PatientDTO patientDTO){
        try {
            System.out.println("DTO Recebido: " + patientDTO);
            patientService.register(patientDTO);
            return new ResponseEntity<>("Cadastro realizado.",HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>("Não foi possivel cadastrar o paciente. Email ja cadastrado ou informações invalidas."
                    , HttpStatus.BAD_REQUEST);
        }
    }
}
