package edu.my.web.service;

import edu.my.web.dto.StudentDto;

public interface StudentService {
    StudentDto persist(StudentDto studentDto);
    void deleteById(Integer id);


}
