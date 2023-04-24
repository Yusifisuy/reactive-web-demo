package com.example.reaction.student;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
@RequiredArgsConstructor
public class StudentService {

    private final StudentRepository studentRepository;


    public Flux<Student> getAll(){
        return studentRepository.findAll();
    }

    public Mono<Student> findById(Integer id){
        return studentRepository.findById(id);
    }

    public Mono<Student> saveStudent(StudentDto student){
        return studentRepository.save(
                Student.builder().firstName(student.getFirstName())
                        .lastName(student.getLastName())
                        .age(student.getAge())
                        .build()
        );
    }

}
