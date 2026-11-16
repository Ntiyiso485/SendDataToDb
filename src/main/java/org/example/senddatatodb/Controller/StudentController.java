package org.example.senddatatodb.Controller;

import jakarta.validation.Valid;
import org.example.senddatatodb.DTO.StudentRequest;
import org.example.senddatatodb.DTO.StudentResponse;
import org.example.senddatatodb.Service.StudentService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

    @RestController
    @RequestMapping("/api/v1/students")
    public class StudentController {

        private final StudentService studentService;

        public StudentController(StudentService studentService) {
            this.studentService = studentService;
        }

        // CREATE
        @PostMapping
        public ResponseEntity<StudentResponse> createStudent(
                @Valid @RequestBody StudentRequest request) {

            StudentResponse response =
                    studentService.createStudent(request);

            return ResponseEntity
                    .status(HttpStatus.CREATED)
                    .body(response);
        }

        // READ ALL
        @GetMapping
        public ResponseEntity<List<StudentResponse>> getAllStudents() {

            return ResponseEntity.ok(
                    studentService.getAllStudents()
            );
        }

        // READ ONE
        @GetMapping("/{id}")
        public ResponseEntity<StudentResponse> getStudentById(
                @PathVariable Long id) {

            return ResponseEntity.ok(
                    studentService.getStudentById(id)
            );
        }

        // UPDATE
        @PutMapping("/{id}")
        public ResponseEntity<StudentResponse> updateStudent(
                @PathVariable Long id,
                @Valid @RequestBody StudentRequest request) {

            return ResponseEntity.ok(
                    studentService.updateStudent(id, request)
            );
        }

        // DELETE
        @DeleteMapping("/{id}")
        public ResponseEntity<Void> deleteStudent(
                @PathVariable Long id) {

            studentService.deleteStudent(id);

            return ResponseEntity.noContent().build();
        }
    }

