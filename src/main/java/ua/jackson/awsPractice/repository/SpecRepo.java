package ua.jackson.awsPractice.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ua.jackson.awsPractice.entity.Specialization;

public interface SpecRepo extends JpaRepository<Specialization,Long> {

}
