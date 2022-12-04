package com.bobbybriqz.web3.playground.service;

import lombok.RequiredArgsConstructor;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Component;
import org.web3j.protocol.Web3j;

@Component
@RequiredArgsConstructor
public class NetworkConnectionResolver {

    private final ApplicationContext context;

    public Web3j getWeb3JForNetwork(String network) {
        return context.getBean(network, Web3j.class);
    }
}
