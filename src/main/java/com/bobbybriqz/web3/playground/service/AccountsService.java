package com.bobbybriqz.web3.playground.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.web3j.protocol.core.DefaultBlockParameter;

import java.io.IOException;
import java.util.Map;

@Slf4j
@Service
@RequiredArgsConstructor
public class AccountsService {

    private final NetworkConnectionResolver networkConnectionResolver;

    public Map<String, Object> getAccountBalance(String network, String address) throws IllegalStateException {
        try {
            var web3j = networkConnectionResolver.getWeb3JForNetwork(network);
            var blockNumber = web3j.ethBlockNumber().send();
            var response = web3j.ethGetBalance(address, DefaultBlockParameter.valueOf(blockNumber.getBlockNumber())).send();
            return Map.of("address", address,
                    "balance", response.getBalance(),
                    "unit", "wei");
        } catch (IOException e) {
            log.error(e.getMessage());
            throw new IllegalStateException(e.getMessage());
        }
    }
}
