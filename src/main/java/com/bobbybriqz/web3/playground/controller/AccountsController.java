package com.bobbybriqz.web3.playground.controller;

import com.bobbybriqz.web3.playground.service.AccountsService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
@RequestMapping("{network}/accounts")
@RequiredArgsConstructor
public class AccountsController {

    private final AccountsService accountsService;

    @GetMapping("/{address}/balance")
    public Map<String, Object> getAccountBalance(@PathVariable("network") String network,
                                                 @PathVariable("address") String address) {
        return accountsService.getAccountBalance(network, address);
    }
}
