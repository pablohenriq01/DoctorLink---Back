package br.com.projeto.DoctorLink.DTOs;

import java.time.LocalTime;
import java.util.UUID;

public record ConsultancyResponseDTO(long id,
                                     String name,
                                     String email,
                                     String specialty,
                                     LocalTime startTime,
                                     LocalTime endTime) {
}
