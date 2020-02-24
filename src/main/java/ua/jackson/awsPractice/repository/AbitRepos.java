package ua.jackson.awsPractice.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ua.jackson.awsPractice.entity.Abiturient;

import java.util.List;

public interface AbitRepos extends JpaRepository<Abiturient,Long> {
//    List<Abiturient> findTopByAvgDiplomaMark();
}
