package br.com.projeto.DoctorLink.DTOs;

import java.time.LocalTime;
import java.util.Date;

public record DoctorResponseDTO(String name, String email, String specialty, LocalTime startTime, LocalTime endTime) {
}
