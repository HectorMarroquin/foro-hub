package com.aluracursos.forohub.api.domain.course.dto;

import com.aluracursos.forohub.api.domain.course.Category;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record CourseRequestDTO(
        @NotBlank
        String name,
        @NotNull
        Category category
) {}
