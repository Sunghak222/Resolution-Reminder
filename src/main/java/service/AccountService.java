package service;

import model.Account;
import repository.AccountRepository;

public class AccountService {
    private final AccountRepository accountRepository;

    public AccountService(AccountRepository accountRepository) {
        this.accountRepository = accountRepository;
    }

    public Account registerAccount(Account account) {
        if (accountRepository.existsByEmail(account.getEmail())) {
            throw new RuntimeException("Email already exists");
        }
        return accountRepository.save(account);
    }
    public boolean findAccount(Account account) {
        if (accountRepository.existsByEmail(account.getEmail())) {
            
        }
    }
}
