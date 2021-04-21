package se.lexicon.marek.registration.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import se.lexicon.marek.registration.entity.Student;
import se.lexicon.marek.registration.repository.StudentRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@RestController
public class StudentController {
    StudentRepository studentRepository;

    @Autowired
    public void setStudentRepository(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }


    @GetMapping("/")
    public ResponseEntity<List<Student>> getAll() {
        List<Student> studentList = new ArrayList<>();
        studentRepository.findAll().iterator().forEachRemaining(studentList::add);
        return ResponseEntity.ok(studentList);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Student> getById(@PathVariable("id") UUID id) {
        Optional<Student> optionalStudent = studentRepository.findById(id);
        if (optionalStudent.isPresent())
            return ResponseEntity.ok(optionalStudent.get());
        else
            return ResponseEntity.noContent().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteById(@PathVariable("id") UUID id) {
        Optional<Student> optionalStudent = studentRepository.findById(id);
        if (optionalStudent.isPresent()) {
            studentRepository.deleteById(id);
            return ResponseEntity.status(HttpStatus.OK).build();
        } else {
            return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
        }
    }

    @PostMapping("/")
    public ResponseEntity<Student> save(@RequestBody Student student) {
        Student result = studentRepository.save(student);
        return ResponseEntity.ok(result);
    }

    @PutMapping("/")
    public ResponseEntity<Student> update(@RequestBody Student student) {
        Student result = studentRepository.save(student);
        return ResponseEntity.ok(result);
    }
}
