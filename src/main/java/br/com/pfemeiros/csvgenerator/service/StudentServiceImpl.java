package br.com.pfemeiros.csvgenerator.service;

import br.com.pfemeiros.csvgenerator.model.Student;
import br.com.pfemeiros.csvgenerator.repository.StudentRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentServiceImpl implements StudentService {

    private final StudentRepository studentRepository;

    public StudentServiceImpl(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    @Override
    public List<Student> findAll() {
        return studentRepository.findAll();
    }

}
