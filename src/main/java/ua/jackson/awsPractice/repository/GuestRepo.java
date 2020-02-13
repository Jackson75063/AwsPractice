package ua.jackson.awsPractice.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ua.jackson.awsPractice.entity.Guest;

public interface GuestRepo extends JpaRepository<Guest,Long> {
}
