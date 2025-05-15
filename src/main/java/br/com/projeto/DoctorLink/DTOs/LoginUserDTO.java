package br.com.projeto.DoctorLink.DTOs;

import jakarta.validation.constraints.NotNull;

public record LoginUserDTO(@NotNull String email,
                           @NotNull String password) {
}
