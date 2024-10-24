package edu.my.web.service;

import edu.my.web.dto.StudentDto;

import java.util.List;

public interface StudentService {
    StudentDto persist(StudentDto studentDto);
    void deleteById(Integer id);

    List<StudentDto> getAll();

    StudentDto getById(Integer id);

    StudentDto update (Integer id,StudentDto studentDto);
}
