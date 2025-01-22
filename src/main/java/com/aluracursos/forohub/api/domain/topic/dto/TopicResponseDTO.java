package com.aluracursos.forohub.api.domain.topic.dto;

import com.aluracursos.forohub.api.domain.topic.Topic;

public record TopicResponseDTO(Long id, String title, String message, String status, String userName, String courseName) {
    public TopicResponseDTO(Topic topic) {
        this(
                topic.getId(),
                topic.getTitle(),
                topic.getMessage(),
                topic.getTopicStatus().name(),
                topic.getUser().getUsername(),
                topic.getCourse().getName()
        );
    }
}