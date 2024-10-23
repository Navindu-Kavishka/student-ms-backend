package edu.my.web.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import edu.my.web.dto.StudentDto;
import edu.my.web.entity.StudentEntity;
import edu.my.web.repository.StudentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class StudentServiceImpl implements StudentService{

    private final StudentRepository repository;
    private final ObjectMapper mapper;
    @Override
    public StudentDto persist(StudentDto studentDto) {
        StudentEntity saved = repository.save(mapper.convertValue(studentDto, StudentEntity.class));
        return mapper.convertValue(saved,StudentDto.class);
    }

    @Override
    public void deleteById(Integer id) {
        repository.deleteById(id);
    }

    @Override
    public List<StudentDto> getAll() {
        Iterable<StudentEntity> all = repository.findAll();
        List<StudentDto>allStudents= new ArrayList<>();
        all.forEach(studentEntity -> {
            allStudents.add(mapper.convertValue(studentEntity,StudentDto.class));
        });
        return allStudents;
    }

}
