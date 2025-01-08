package dev.sunghak.resolution_reminder.repository;

import dev.sunghak.resolution_reminder.model.Account;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

@DataJpaTest
public class AccountRepositoryTest {

    @Autowired
    private AccountRepository accountRepository;

    @Test
    void findByEmailTest() {
        Account account = new Account("temp","temp@example.com","password1");
        accountRepository.save(account);

        Optional<Account> found = accountRepository.findByEmail(account.getEmail());

        assertTrue(found.isPresent());
        assertEquals(account.getEmail(),found.get().getEmail());
    }

    @Test
    void findByUsernameTest() {
        Account account = new Account("temp","temp@example.com","password1");
        accountRepository.save(account);
        Optional<Account> found = accountRepository.findByUsername("temp");
        assertTrue(found.isPresent());
        assertEquals(account.getEmail(),found.get().getEmail());
    }

    @Test
    void existsByUsernameTest() {
        Account account = new Account("temp","temp@example.com","password1");
        accountRepository.save(account);

        assertTrue(accountRepository.existsByUsername("temp"));
    }

    @Test
    void existsByEmailTest() {
        Account account = new Account("temp","temp@example.com","password1");
        accountRepository.save(account);

        assertTrue(accountRepository.existsByEmail("temp@example.com"));
    }
}
