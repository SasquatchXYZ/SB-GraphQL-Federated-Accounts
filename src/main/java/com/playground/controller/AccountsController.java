package com.playground.controller;

import com.playground.entity.Account;
import com.playground.service.AccountService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;

import java.util.List;

@Controller
@Slf4j
public class AccountsController {

    @Autowired
    AccountService accountsService;

    @QueryMapping
    public List<Account> accounts() {
        log.info("Getting Accounts");
        return accountsService.accounts();
    }

    @MutationMapping
    public Account addAccount(@Argument("account") Account account) {
        accountsService.save(account);
        return account;
    }

    @MutationMapping
    public Boolean deleteAccount(@Argument("accountId") Integer accountId) {
        accountsService.deleteAccount(accountId);
        return Boolean.TRUE;
    }
}
