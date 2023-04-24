package com.example.reaction.student;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/reactive/v1/students")
@RequiredArgsConstructor
public class StudentController {

    private final StudentService studentService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    Mono<Student> save(@RequestBody StudentDto student){
        return studentService.saveStudent(student);
    }

    @GetMapping
    Flux<Student> getAll(){
        return studentService.getAll();
    }

    @GetMapping("/{id}")
    Mono<Student> getById(@PathVariable("id")Integer id){
        return studentService.findById(id);
    }
}
