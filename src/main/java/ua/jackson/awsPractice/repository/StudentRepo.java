package ua.jackson.awsPractice.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ua.jackson.awsPractice.entity.Student;

public interface StudentRepo extends JpaRepository<Student,Long> {
}
