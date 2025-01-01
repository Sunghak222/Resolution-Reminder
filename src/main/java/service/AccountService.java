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
            throw new RuntimeException("Email already exists: " + account.getEmail());
        }
        return accountRepository.save(account);
    }
    public boolean existsAccount(Account account) {
        return accountRepository.existsById(account.getUserId());
    }

    // Get
    public Account getAccountById(Long id) {
        return accountRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Account not found with ID: " + id));
    }
    public Account getAccountByEmail(String email) {
        return accountRepository.findByEmail(email)
                .orElseThrow(() -> new IllegalArgumentException("Account not found with email: " + email));
    }

    // Update
    public Account updateAccount(Account account) {
        Account updatedAccount = accountRepository.findById(account.getUserId())
                .orElseThrow(() -> new IllegalArgumentException("Account not found with ID: " + account.getUserId()));
        if (account.getEmail() != null) {
            updatedAccount.setEmail(account.getEmail());
        }
        if (account.getUserName() != null) {
            updatedAccount.setUserName(account.getUserName());
        }
        if (account.getPassword() != null) {
            updatedAccount.setPassword(account.getPassword());
        }

        return accountRepository.save(updatedAccount);
    }

    //Delete
    public void deleteAccount(Long id) {
        Account account = accountRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Account not found with ID: " + id));
        accountRepository.deleteById(id);
    }
}
