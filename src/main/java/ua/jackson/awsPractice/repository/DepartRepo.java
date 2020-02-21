package ua.jackson.awsPractice.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ua.jackson.awsPractice.SO.Depart;

public interface DepartRepo extends JpaRepository<Depart, Long> {
}
