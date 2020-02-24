package ua.jackson.awsPractice.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ua.jackson.awsPractice.entity.Abiturient;

public interface AbitRepos extends JpaRepository<Abiturient,Long> {
}
