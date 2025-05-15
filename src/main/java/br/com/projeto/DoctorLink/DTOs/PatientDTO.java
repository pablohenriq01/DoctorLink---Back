package br.com.projeto.DoctorLink.DTOs;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;

import java.time.LocalDate;
import java.util.Date;

public record PatientDTO(@NotNull String name,
                         @NotNull @Email(message = "Coloque um email valido!") String email,
                         @NotNull String password,
                         @NotNull
                         LocalDate dateBirth,
                         @NotNull String telephone){
}
