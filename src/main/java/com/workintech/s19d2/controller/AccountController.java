package com.workintech.s19d2.controller;

import com.workintech.s19d2.entity.Account;
import com.workintech.s19d2.service.AccountService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@AllArgsConstructor
@RestController
@RequestMapping("/account")
public class AccountController {

    private final AccountService accountService;

    @GetMapping
    public List<Account> findAll(){
        return accountService.findAll();
    }

    // Belirli ID'li hesabı getir
    @GetMapping("/{id}")
    public ResponseEntity<Account> findById(@PathVariable Long id) {
        return accountService.findById(id)
                .map(ResponseEntity::ok)
                .orElseThrow(() -> new RuntimeException("Account not found! ID: " + id));
    }

    // Yeni hesap ekle
    @PostMapping
    public ResponseEntity<Account> createAccount(@RequestBody Account account) {
        return ResponseEntity.ok(accountService.save(account));
    }

    // Hesabı güncelle
    @PutMapping("/{id}")
    public ResponseEntity<Account> updateAccount(@PathVariable Long id, @RequestBody Account updatedAccount) {
        return ResponseEntity.ok(accountService.update(id, updatedAccount));
    }

    // Hesabı sil
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteAccount(@PathVariable Long id) {
        accountService.delete(id);
        return ResponseEntity.noContent().build();
    }
}
