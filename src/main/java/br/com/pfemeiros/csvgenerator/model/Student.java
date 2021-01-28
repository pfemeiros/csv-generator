package br.com.pfemeiros.csvgenerator.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.time.LocalDate;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Student {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id = 0L;

    private String name;

    @JsonFormat(pattern = "yyyy-MM-dd")
    private LocalDate birthDate;
    private String address;

    public Student(StudentCsv studentCsv) {
        this.name = studentCsv.getName();
        this.birthDate = studentCsv.getBirthDate();
        this.address = studentCsv.getAddress();
    }

}
