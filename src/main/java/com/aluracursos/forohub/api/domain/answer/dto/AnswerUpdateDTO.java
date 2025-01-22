package com.aluracursos.forohub.api.domain.answer.dto;
import jakarta.validation.constraints.NotBlank;

public record AnswerUpdateDTO(
        @NotBlank String message,
        boolean solution
) {}
