package br.com.projeto.DoctorLink.DTOs;

import jakarta.validation.constraints.NotNull;

import java.time.LocalDate;
import java.util.Date;

public record PatientResponseDTO(String name,
                                 String email,
                                 LocalDate dateBirth,
                                 String telephone) {
}
