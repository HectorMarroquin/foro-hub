package com.aluracursos.forohub.api.domain.answer.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record AnswerRequestDTO(
        @NotBlank String message,
        @NotNull Long topicId,
        @NotNull Long userId
) {}
