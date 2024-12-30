package service;

import model.Account;
import repository.AccountRepository;

import java.util.Optional;

public class AccountService {
    private final AccountRepository accountRepository;

    public AccountService(AccountRepository accountRepository) {
        this.accountRepository = accountRepository;
    }

    // Create Account
    public Account registerAccount(Account account) {
        if (account == null || account.getEmail() == null || account.getUserName() == null) {
            throw new IllegalArgumentException("Account cannot have a null value.");
        }
        if (accountRepository.existsByEmail(account.getEmail())) {
            throw new RuntimeException("Email already exists");
        }
        return accountRepository.save(account);
    }
    public boolean existsAccount(Account account) {
        return accountRepository.existsById(account.getUserId());
    }
    public Optional<Account> getAccountByEmail(String email) {
        return accountRepository.findByEmail(email);
    }
    public boolean updateAccount(Account account) {
        if (existsAccount(account)) {
            accountRepository.save(account);
            return true;
        }
        return false;
    }
    public boolean deleteAccount(Account account) {
        if (existsAccount(account)) {
            accountRepository.deleteById(account.getUserId());
            return true;
        }
        return false;
    }
}
