package com.aluracursos.forohub.api.domain.course;

import com.aluracursos.forohub.api.domain.course.dto.CourseRequestDTO;
import jakarta.persistence.*;

@Table(name = "courses")
@Entity(name = "Course")
public class Course {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, length = 50)
    private String name;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false, length = 50)
    private Category category;

    // Constructor por defecto
    public Course() {
    }

    // Constructor con todos los parámetros
    public Course(Long id, String name, Category category) {
        this.id = id;
        this.name = name;
        this.category = category;
    }

    // Constructor con CourseRequestDTO
    public Course(CourseRequestDTO course) {
        this.name = course.name();
        this.category = course.category();
    }

    // Getters
    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public Category getCategory() {
        return category;
    }

    // Setters
    public void setId(Long id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    // Método equals basado en el id
    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Course course = (Course) obj;
        return id != null && id.equals(course.id);
    }

    // Método hashCode basado en el id
    @Override
    public int hashCode() {
        return id != null ? id.hashCode() : 0;
    }

    // Método toString
    @Override
    public String toString() {
        return "Course{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", category=" + category +
                '}';
    }
}
