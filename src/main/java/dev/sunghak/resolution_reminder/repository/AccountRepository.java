package dev.sunghak.resolution_reminder.repository;

import dev.sunghak.resolution_reminder.model.Account;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface AccountRepository extends JpaRepository<Account, Long> {
    // Retrieve by user email.
    Optional<Account> findByEmail(String email);

    // Retrieve by username.
    Optional<Account> findByUsername(String username);

    // Check if an account with the username exists.
    boolean existsByUsername(String username);

    // Check if an account with the user email exists.
    boolean existsByEmail(String email);
}
