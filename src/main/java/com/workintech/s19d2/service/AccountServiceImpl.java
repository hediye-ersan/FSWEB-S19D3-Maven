package com.workintech.s19d2.service;

import com.workintech.s19d2.repository.AccountRepository;
import com.workintech.s19d2.entity.Account;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@AllArgsConstructor
@Service
public class AccountServiceImpl implements AccountService{

    private final AccountRepository accountRepository;

    @Override
    public List<Account> findAll() {
        return accountRepository.findAll();
    }

    @Override
    public Account save(Account account) {
        return accountRepository.save(account);
    }

    @Override
    public Optional<Account> findById(Long id) {
        return accountRepository.findById(id);
    }

    @Override
    public Account update(Long id, Account updatedAccount) {
        Account existingAccount = accountRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Account not found! ID: " + id));

        existingAccount.setName(updatedAccount.getName());


        return accountRepository.save(existingAccount);
    }

    @Override
    public void delete(Long id) {
        Account existingAccount = accountRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Account not found! ID: " + id));

        accountRepository.delete(existingAccount);
    }
}
