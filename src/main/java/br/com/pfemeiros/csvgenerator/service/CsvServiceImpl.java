package br.com.pfemeiros.csvgenerator.service;

import br.com.pfemeiros.csvgenerator.model.Student;
import br.com.pfemeiros.csvgenerator.model.StudentCsv;
import br.com.pfemeiros.csvgenerator.repository.StudentRepository;
import com.opencsv.bean.CsvToBeanBuilder;
import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVPrinter;
import org.apache.commons.csv.QuoteMode;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.server.ResponseStatusException;

import java.io.*;
import java.util.Arrays;
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
        List<Student> all = studentRepository.findAll();
        return studentsToCsv(all);
    }

    private ByteArrayInputStream studentsToCsv(List<Student> studentList) {
        final CSVFormat format = CSVFormat.DEFAULT.withQuoteMode(QuoteMode.MINIMAL);
        try (ByteArrayOutputStream out = new ByteArrayOutputStream();
             CSVPrinter csvPrinter = new CSVPrinter(new PrintWriter(out), format);) {
            csvPrinter.printRecord(Arrays.asList("name", "birth date", "address"));
            for (Student student : studentList) {
                List<String> data = Arrays.asList(
                        student.getName(),
                        student.getBirthDate().toString(),
                        student.getAddress()
                );
                csvPrinter.printRecord(data);
            }
            csvPrinter.flush();
            return new ByteArrayInputStream(out.toByteArray());
        } catch (IOException e) {
            throw new RuntimeException("fail to import data to CSV file: " + e.getMessage());
        }
    }

}
