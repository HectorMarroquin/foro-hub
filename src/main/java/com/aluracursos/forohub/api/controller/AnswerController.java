package com.aluracursos.forohub.api.controller;

import com.aluracursos.forohub.api.domain.answer.Answer;
import com.aluracursos.forohub.api.domain.answer.AnswerRepository;
import com.aluracursos.forohub.api.domain.answer.dto.AnswerRequestDTO;
import com.aluracursos.forohub.api.domain.answer.dto.AnswerResponseDTO;
import com.aluracursos.forohub.api.domain.answer.dto.AnswerUpdateDTO;
import com.aluracursos.forohub.api.domain.topic.Topic;
import com.aluracursos.forohub.api.domain.topic.TopicRepository;
import com.aluracursos.forohub.api.domain.user.User;
import com.aluracursos.forohub.api.domain.user.UserRepository;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/answers")
public class AnswerController {

    @Autowired
    private AnswerRepository answerRepository;

    @Autowired
    private TopicRepository topicRepository;

    @Autowired
    private UserRepository userRepository;

    // CREATE (Registrar una nueva respuesta)
    @PostMapping
    public ResponseEntity<AnswerResponseDTO> registerAnswer(@RequestBody @Valid AnswerRequestDTO answerRequestDTO) {
        Topic topic = topicRepository.findById(answerRequestDTO.topicId())
                .orElseThrow(() -> new RuntimeException("Topic not found"));
        User user = userRepository.findById(answerRequestDTO.userId())
                .orElseThrow(() -> new RuntimeException("User not found"));

        Answer answer = new Answer(answerRequestDTO.message(), false, topic, user, LocalDateTime.now());
        answerRepository.save(answer);

        return ResponseEntity.ok(new AnswerResponseDTO(answer));
    }

    // READ (Listar todas las respuestas)
    @GetMapping
    public ResponseEntity<List<AnswerResponseDTO>> getAllAnswers() {
        List<AnswerResponseDTO> answers = answerRepository.findAll().stream()
                .map(AnswerResponseDTO::new)
                .collect(Collectors.toList());
        return ResponseEntity.ok(answers);
    }

    // READ (Obtener una respuesta por ID)
    @GetMapping("/{id}")
    public ResponseEntity<AnswerResponseDTO> getAnswerById(@PathVariable Long id) {
        Answer answer = answerRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Answer not found"));
        return ResponseEntity.ok(new AnswerResponseDTO(answer));
    }

    // UPDATE (Actualizar una respuesta)
    @PutMapping("/{id}")
    public ResponseEntity<AnswerResponseDTO> updateAnswer(@PathVariable Long id, @RequestBody @Valid AnswerUpdateDTO answerUpdateDTO) {
        Answer answer = answerRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Answer not found"));

        answer.setMessage(answerUpdateDTO.message());
        answer.setSolution(answerUpdateDTO.solution());
        answerRepository.save(answer);

        return ResponseEntity.ok(new AnswerResponseDTO(answer));
    }

    // DELETE (Eliminar una respuesta)
    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteAnswer(@PathVariable Long id) {
        Answer answer = answerRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Answer not found"));

        answerRepository.delete(answer);
        return ResponseEntity.ok("Answer deleted successfully");
    }
}
