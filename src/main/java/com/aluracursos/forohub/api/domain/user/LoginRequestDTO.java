package com.aluracursos.forohub.api.domain.user;

public record LoginRequestDTO(
        String username,
        String password
) {}