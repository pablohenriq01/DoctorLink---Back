package br.com.projeto.DoctorLink.DTOs;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;

import java.util.Date;

public record PatientDTO(@NotNull String name,
                         @NotNull @Email(message = "Coloque um email valido!") String email,
                         @NotNull String password,
                         @NotNull Date dateBirth,
                         @NotNull int telephone){
}
