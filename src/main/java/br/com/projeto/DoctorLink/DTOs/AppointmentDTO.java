package br.com.projeto.DoctorLink.DTOs;

import jakarta.validation.constraints.NotNull;

public record AppointmentDTO(@NotNull Long patientId,
                             @NotNull Long consultancyId){
}
