package br.com.pfemeiros.csvgenerator.model;

import com.opencsv.bean.CsvBindByName;
import com.opencsv.bean.CsvDate;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class StudentCsv {

    @CsvBindByName
    private String name;

    @CsvDate(value = "yyyy-MM-dd")
    @CsvBindByName(column = "birth date")
    private LocalDate birthDate;

    @CsvBindByName
    private String address;

}
