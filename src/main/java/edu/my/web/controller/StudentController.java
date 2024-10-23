package edu.my.web.controller;

import edu.my.web.dto.StudentDto;
import edu.my.web.service.StudentService;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("student")
@RequiredArgsConstructor
@CrossOrigin("*")
public class StudentController {

    private final StudentService service;
    @PostMapping
    StudentDto persist(@RequestBody StudentDto studentDto){
        return service.persist(studentDto);
    }

    @DeleteMapping("/delete/{id}")
    ResponseEntity<?> deleteById(@PathVariable Integer id){
        try {
            service.deleteById(id);
            return new ResponseEntity<>("Student Deleted Successfully...", HttpStatus.OK);
        }catch (EntityNotFoundException ex){
            return new ResponseEntity<>(ex.getMessage(),HttpStatus.NOT_FOUND);
        }

    }

    @GetMapping("/all")
    List<StudentDto> getAll(){
        return service.getAll();
    }

}
