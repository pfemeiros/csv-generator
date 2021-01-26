package br.com.pfemeiros.csvgenerator.repository;

import br.com.pfemeiros.csvgenerator.model.Student;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StudentRepository extends JpaRepository<Student, Long> {
}
