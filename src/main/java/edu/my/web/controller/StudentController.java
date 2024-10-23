package edu.my.web.controller;

import edu.my.web.dto.StudentDto;
import edu.my.web.service.StudentService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("student")
@RequiredArgsConstructor
public class StudentController {

    private final StudentService service;
    @PostMapping
    StudentDto persist(@RequestBody StudentDto studentDto){
        return service.persist(studentDto);
    }

    @DeleteMapping("/delete/{id}")
    void deleteById(@PathVariable Integer id){
        service.deleteById(id);
    }



}
