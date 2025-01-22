package com.aluracursos.forohub.api.controller;

import com.aluracursos.forohub.api.domain.topic.Topic;
import com.aluracursos.forohub.api.domain.topic.TopicRepository;
import com.aluracursos.forohub.api.domain.topic.dto.TopicRequestDTO;
import com.aluracursos.forohub.api.domain.topic.dto.TopicResponseDTO;
import com.aluracursos.forohub.api.domain.topic.dto.TopicUpdateDTO;
import com.aluracursos.forohub.api.domain.user.User;
import com.aluracursos.forohub.api.domain.user.UserRepository;
import com.aluracursos.forohub.api.domain.course.Course;
import com.aluracursos.forohub.api.domain.course.CourseRepository;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/topics")
public class TopicController {

    @Autowired
    private TopicRepository topicRepository;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private CourseRepository courseRepository;

    // CREATE (Registrar un nuevo topic)
    @PostMapping
    public ResponseEntity<TopicResponseDTO> registerTopic(@RequestBody @Valid TopicRequestDTO topicRequestDTO) {
        User user = userRepository.findById(topicRequestDTO.userId())
                .orElseThrow(() -> new RuntimeException("User not found"));
        Course course = courseRepository.findById(topicRequestDTO.courseId())
                .orElseThrow(() -> new RuntimeException("Course not found"));

        Topic topic = new Topic(topicRequestDTO, user, course);
        topicRepository.save(topic);

        return ResponseEntity.ok(new TopicResponseDTO(topic));
    }

    // READ (Listar todos los topics)
    @GetMapping
    public ResponseEntity<List<TopicResponseDTO>> getAllTopics() {
        List<TopicResponseDTO> topics = topicRepository.findAll().stream()
                .map(TopicResponseDTO::new)
                .collect(Collectors.toList());
        return ResponseEntity.ok(topics);
    }

    // READ (Obtener un topic por ID)
    @GetMapping("/{id}")
    public ResponseEntity<TopicResponseDTO> getTopicById(@PathVariable Long id) {
        Topic topic = topicRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Topic not found"));
        return ResponseEntity.ok(new TopicResponseDTO(topic));
    }

    // UPDATE (Actualizar un topic)
    @PutMapping("/{id}")
    public ResponseEntity<TopicResponseDTO> updateTopic(@PathVariable Long id, @RequestBody @Valid TopicUpdateDTO topicUpdateDTO) {
        Topic topic = topicRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Topic not found"));

        topic.setTitle(topicUpdateDTO.title());
        topic.setMessage(topicUpdateDTO.message());
        topicRepository.save(topic);

        return ResponseEntity.ok(new TopicResponseDTO(topic));
    }

    // DELETE (Eliminar un topic)
    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteTopic(@PathVariable Long id) {
        Topic topic = topicRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Topic not found"));

        topicRepository.delete(topic);
        return ResponseEntity.ok("Topic deleted successfully");
    }
}
