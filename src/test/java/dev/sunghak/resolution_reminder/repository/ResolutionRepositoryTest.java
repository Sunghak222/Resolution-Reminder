package dev.sunghak.resolution_reminder.repository;

import dev.sunghak.resolution_reminder.model.Account;
import dev.sunghak.resolution_reminder.model.Resolution;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.time.LocalDateTime;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

@DataJpaTest
public class ResolutionRepositoryTest {

    @Autowired
    private ResolutionRepository resolutionRepository;
    @Autowired
    private AccountRepository accountRepository;

    @Test
    void findAllByAuthorTest() {
        Account account = new Account("temp", "temp@example.com","password1");
        Resolution res1 = new Resolution(account,"I want to be a good programmer.", LocalDateTime.now(),LocalDateTime.of(2026,1,1,0,0));
        Resolution res2 = new Resolution(account, "I want to make a lot of money.", LocalDateTime.now(), LocalDateTime.of(2026,1,1,0,0));
        accountRepository.save(account);

        resolutionRepository.save(res1);
        resolutionRepository.save(res2);

        List<Resolution> resList = resolutionRepository.findAllByAuthor(account);

        assertEquals(resList.get(0), res1);
        assertEquals(resList.get(1), res2);
    }
}
