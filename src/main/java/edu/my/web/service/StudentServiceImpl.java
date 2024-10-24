package edu.my.web.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import edu.my.web.dto.StudentDto;
import edu.my.web.entity.StudentEntity;
import edu.my.web.repository.StudentRepository;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

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
        if (!repository.existsById(id)){
            throw  new EntityNotFoundException("Student Not Found...");
        }
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

    @Override
    public StudentDto getById(Integer id){
        StudentEntity studentEntity = repository.findById(id).orElse(null);
        return mapper.convertValue(studentEntity,StudentDto.class);
    }

    @Override
    public StudentDto update (Integer id,StudentDto studentDto){
        Optional<StudentEntity> optionalStudent = repository.findById(id);
        if (optionalStudent.isPresent()){
            StudentEntity existingStudentEntity = optionalStudent.get();
            existingStudentEntity.setName(studentDto.getName());
            existingStudentEntity.setAge(studentDto.getAge());
            existingStudentEntity.setContact(studentDto.getContact());
            existingStudentEntity.setGuardianName(studentDto.getGuardianName());
            existingStudentEntity.setAddress(studentDto.getAddress());
            existingStudentEntity.setGuardianContact(studentDto.getGuardianContact());


            StudentEntity saved = repository.save(existingStudentEntity);
            return mapper.convertValue(saved,StudentDto.class);

        }
        return null;
    }
}
