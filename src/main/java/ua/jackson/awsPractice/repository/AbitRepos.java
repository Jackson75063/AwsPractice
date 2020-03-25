package ua.jackson.awsPractice.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import ua.jackson.awsPractice.entity.Abiturient;

import java.util.Optional;

public interface AbitRepos extends PagingAndSortingRepository<Abiturient,Long>, JpaRepository<Abiturient,Long> {
//    List<Abiturient> findTopByAvgDiplomaMark();

    Optional<Abiturient> findByUsername(String username);

    Boolean existsByUsername(String username);

    Boolean existsByEmail(String email);

    Optional<Abiturient> findByEmail(String email);


}
