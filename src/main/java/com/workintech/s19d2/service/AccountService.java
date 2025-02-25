package com.workintech.s19d2.service;

import com.workintech.s19d2.entity.Account;

import java.util.List;
import java.util.Optional;

public interface AccountService {
    List<Account> findAll();
    Account save(Account account);
    Optional<Account> findById(Long id);
    Account update(Long id, Account updatedAccount);
    void delete(Long id);

}
