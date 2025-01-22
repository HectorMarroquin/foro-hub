package com.aluracursos.forohub.api.domain.topic.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record TopicRequestDTO(
        @NotBlank String title,
        @NotBlank String message,
        @NotNull Long userId,
        @NotNull Long courseId
) {}
