package com.bobbybriqz.web3.playground.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.web3j.protocol.Web3j;
import org.web3j.protocol.http.HttpService;

@Configuration
public class BeanBasket {

    @Value("${bsc.testnet.url}")
    String bscTestnetUrl;

    @Bean("bsc_testnet")
    public Web3j web3j() {
        return Web3j.build(new HttpService(bscTestnetUrl));
    }
}
