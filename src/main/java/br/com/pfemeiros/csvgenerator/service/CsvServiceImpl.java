package br.com.pfemeiros.csvgenerator.service;

import br.com.pfemeiros.csvgenerator.model.Student;
import br.com.pfemeiros.csvgenerator.model.StudentCsv;
import br.com.pfemeiros.csvgenerator.repository.StudentRepository;
import com.opencsv.bean.CsvToBean;
import com.opencsv.bean.CsvToBeanBuilder;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Reader;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class CsvServiceImpl implements CsvService {

    private final StudentRepository studentRepository;

    public CsvServiceImpl(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    @Override
    public void upload(MultipartFile file) {
        try (Reader reader = new BufferedReader(new InputStreamReader(file.getInputStream()))) {
            List<Student> studentListToSave = new CsvToBeanBuilder<StudentCsv>(reader)
                    .withType(StudentCsv.class)
                    .withIgnoreLeadingWhiteSpace(true)
                    .build()
                    .parse()
                    .stream()
                    .map(Student::new)
                    .collect(Collectors.toList());
            studentRepository.saveAll(studentListToSave);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public byte[] download() {
        return new byte[0];
    }

}
