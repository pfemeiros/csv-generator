package br.com.pfemeiros.csvgenerator.service;

import br.com.pfemeiros.csvgenerator.repository.StudentRepository;
import org.springframework.stereotype.Service;

@Service
public class CsvServiceImpl implements CsvService {

    private final StudentRepository studentRepository;

    public CsvServiceImpl(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    @Override
    public void upload() {
        studentRepository.findAll();
    }

    @Override
    public byte[] download() {
        return new byte[0];
    }

}
