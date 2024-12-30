package repository;

import model.Account;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface AccountRepository extends JpaRepository<Account, Long> {
    // Retrieve by username.
    Optional<Account> findByUsername(String username);

    // Retrieve by user email.
    Optional<Account> findByEmail(String email);

    // Check if an account with the username exists.
    boolean existsByUsername(String username);

    // Check if an account with the user email exists.
    boolean existsByEmail(String email);
}
