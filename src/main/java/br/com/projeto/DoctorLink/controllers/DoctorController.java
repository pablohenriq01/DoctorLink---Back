package br.com.projeto.DoctorLink.controllers;

import br.com.projeto.DoctorLink.DTOs.DoctorDTO;
import br.com.projeto.DoctorLink.services.DoctorService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/doctor")
public class DoctorController {
    @Autowired
    DoctorService doctorService;

    @PostMapping("/create")
    public ResponseEntity<DoctorDTO> register(@Valid @RequestBody DoctorDTO doctorDTO) {
        try {
            doctorService.createDoctor(doctorDTO);
            return new ResponseEntity<>(doctorDTO, HttpStatus.ACCEPTED);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }
}
