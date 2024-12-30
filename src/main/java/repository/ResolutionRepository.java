package repository;

import model.Account;
import model.Resolution;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ResolutionRepository extends JpaRepository<Resolution, Long> {
    // Retrieve by author.
    Optional<Resolution> findByAuthor(Account author);
}
