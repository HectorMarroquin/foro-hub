package com.aluracursos.forohub.api.controller;

import com.aluracursos.forohub.api.domain.course.Course;
import com.aluracursos.forohub.api.domain.course.CourseRepository;
import com.aluracursos.forohub.api.domain.course.dto.CourseRequestDTO;
import jakarta.persistence.Entity;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/courses")
public class CourseController {

    @Autowired
    private CourseRepository courseRepository;

    @PostMapping
    public ResponseEntity createCourse(@RequestBody @Valid CourseRequestDTO courseRequestDTO){
        var course = courseRepository.save( new Course( courseRequestDTO ));
        return ResponseEntity.ok( course );
    }
}
