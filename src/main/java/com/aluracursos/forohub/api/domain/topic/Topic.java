package com.aluracursos.forohub.api.domain.topic;

import com.aluracursos.forohub.api.domain.course.Course;
import com.aluracursos.forohub.api.domain.topic.dto.TopicRequestDTO;
import com.aluracursos.forohub.api.domain.user.User;
import jakarta.persistence.*;
import jakarta.validation.Valid;

import java.time.LocalDateTime;
import java.util.Objects;

@Table(name = "topics")
@Entity(name = "Topic")
public class Topic {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String title;

    @Column(nullable = false)
    private String message;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private TopicStatus topicStatus;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id", nullable = false)
    private User user;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "course_id", nullable = false)
    private Course course;

    @Column(nullable = false)
    private LocalDateTime createdAt;

    // Constructor sin argumentos (obligatorio para Hibernate)
    public Topic() {
    }

    // Constructor con todos los campos
    public Topic(Long id, String title, String message, TopicStatus topicStatus, User user, Course course, LocalDateTime createdAt) {
        this.id = id;
        this.title = title;
        this.message = message;
        this.topicStatus = topicStatus;
        this.user = user;
        this.course = course;
        this.createdAt = createdAt;
    }

    // Constructor con DTO
    public Topic(@Valid TopicRequestDTO data, User user, Course course) {
        this.title = data.title();
        this.message = data.message();
        this.user = user;
        this.course = course;
        this.topicStatus = TopicStatus.OPEN; // Estado inicial
        this.createdAt = LocalDateTime.now(); // Fecha de creación
    }

    // Getters y Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public TopicStatus getTopicStatus() {
        return topicStatus;
    }

    public void setTopicStatus(TopicStatus topicStatus) {
        this.topicStatus = topicStatus;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Course getCourse() {
        return course;
    }

    public void setCourse(Course course) {
        this.course = course;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }

    // Métodos equals y hashCode basados en el campo id
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Topic topic = (Topic) o;
        return Objects.equals(id, topic.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    // Método toString (opcional, para depuración)
    @Override
    public String toString() {
        return "Topic{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", message='" + message + '\'' +
                ", topicStatus=" + topicStatus +
                ", user=" + (user != null ? user.getId() : "null") +
                ", course=" + (course != null ? course.getId() : "null") +
                ", createdAt=" + createdAt +
                '}';
    }
}
