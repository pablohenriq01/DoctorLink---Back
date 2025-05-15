package br.com.projeto.DoctorLink.DTOs;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;

import java.time.LocalTime;

public record ConsultancyDTO(@NotNull String nameConsultancy,
                             @NotNull @Email(message = "Coloque um email valido!") String email,
                             @NotNull String password,
                             @NotNull String specialty,
                             @NotNull LocalTime startTime,
                             @NotNull LocalTime endTime) {}
