package com.aluracursos.forohub.api.domain.answer.dto;

import com.aluracursos.forohub.api.domain.answer.Answer;

public record AnswerResponseDTO(Long id, String message, boolean solution, String topicTitle, String userName) {
    public AnswerResponseDTO(Answer answer) {
        this(
                answer.getId(),
                answer.getMessage(),
                answer.isSolution(),
                answer.getTopic().getTitle(),
                answer.getUser().getUsername()
        );
    }
}