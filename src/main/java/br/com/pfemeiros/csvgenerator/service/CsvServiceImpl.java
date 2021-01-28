package br.com.pfemeiros.csvgenerator.service;

import br.com.pfemeiros.csvgenerator.model.Student;
import br.com.pfemeiros.csvgenerator.model.StudentCsv;
import br.com.pfemeiros.csvgenerator.repository.StudentRepository;
import com.opencsv.bean.CsvToBeanBuilder;
import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVPrinter;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.server.ResponseStatusException;

import java.io.*;
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
    public ByteArrayInputStream download() {
        // TODO implement
        return null;
    }

}
