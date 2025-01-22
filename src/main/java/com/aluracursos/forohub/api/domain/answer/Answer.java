package com.aluracursos.forohub.api.domain.answer;

import com.aluracursos.forohub.api.domain.topic.Topic;
import com.aluracursos.forohub.api.domain.user.User;
import jakarta.persistence.*;

import java.time.LocalDateTime;

@Table(name = "answers")
@Entity(name = "Answer")
public class Answer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String message;

    @Column(nullable = false)
    private boolean solution;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "topic_id", nullable = false)
    private Topic topic;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id", nullable = false)
    private User user;

    @Column(nullable = false)
    private LocalDateTime createdAt;

    public Answer() {}

    public Answer(String message, boolean solution, Topic topic, User user, LocalDateTime createdAt) {
        this.message = message;
        this.solution = solution;
        this.topic = topic;
        this.user = user;
        this.createdAt = createdAt;
    }

    // Getters y Setters
    public Long getId() {
        return id;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public boolean isSolution() {
        return solution;
    }

    public void setSolution(boolean solution) {
        this.solution = solution;
    }

    public Topic getTopic() {
        return topic;
    }

    public User getUser() {
        return user;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }
}
