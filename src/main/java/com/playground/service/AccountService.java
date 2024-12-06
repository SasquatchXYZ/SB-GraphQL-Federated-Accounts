package com.playground.service;

import com.playground.entity.Account;
import com.playground.exceptions.AccountAlreadyExistsException;
import com.playground.exceptions.AccountNotFoundException;
import com.playground.repo.AccountRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;

@Service
public class AccountService {

    @Autowired
    AccountRepo repo;

    public void save(Account account) {
        if (repo.findById(account.getAccountId()).isEmpty()) {
            repo.save(account);
        } else {
            throw new AccountAlreadyExistsException("Account " + account.getAccountId() + " already exists");
        }
    }

    public List<Account> accounts() {
        return repo.findAll();
    }

    public Account accountById(Integer accountId) {
        if (repo.findById(accountId).isPresent()) {
            return repo.findById(accountId).get();
        } else {
            throw new AccountNotFoundException("Account Not Found: " + accountId);
        }
    }

    public Boolean deleteAccount(Integer accountId) {
        if (Objects.nonNull(accountById(accountId))) {
            repo.delete(accountById(accountId));
            return true;
        }
        return false;
    }
}
