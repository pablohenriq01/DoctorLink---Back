package br.com.projeto.DoctorLink.DTOs;

import jakarta.validation.constraints.NotNull;

import java.time.LocalTime;

public record AppointmentDTO(@NotNull Long patientId,
                             @NotNull Long consultancyId,
                             @NotNull LocalTime timeInitial,
                             @NotNull LocalTime timeFinal){
}
