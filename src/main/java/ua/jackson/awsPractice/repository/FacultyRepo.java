package ua.jackson.awsPractice.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ua.jackson.awsPractice.entity.Faculty;

public interface FacultyRepo  extends JpaRepository<Faculty,Long> {
}
