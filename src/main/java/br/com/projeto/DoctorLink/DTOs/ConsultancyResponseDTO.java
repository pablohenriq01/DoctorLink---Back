package br.com.projeto.DoctorLink.DTOs;

import java.time.LocalTime;

public record ConsultancyResponseDTO(String name,
                                     String email,
                                     String specialty,
                                     LocalTime startTime,
                                     LocalTime endTime) {
}
