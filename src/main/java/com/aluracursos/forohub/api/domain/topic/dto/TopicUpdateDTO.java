package com.aluracursos.forohub.api.domain.topic.dto;

import jakarta.validation.constraints.NotBlank;

public record TopicUpdateDTO(
        @NotBlank String title,
        @NotBlank String message
) {}
