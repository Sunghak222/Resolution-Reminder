package dev.sunghak.resolution_reminder.repository;

import dev.sunghak.resolution_reminder.model.Account;
import dev.sunghak.resolution_reminder.model.Resolution;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ResolutionRepository extends JpaRepository<Resolution, Long> {
    // Retrieve by author.
    List<Resolution> findAllByAuthor(Account author);

    // Optional<Resolution> findByAuthor_Id(Long authorId);
}
