package com.bobbybriqz.web3.playground.config;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.event.EventListener;
import org.web3j.protocol.Web3j;
import org.web3j.protocol.http.HttpService;


@Slf4j
@Configuration
@RequiredArgsConstructor
public class BeanBasket {

    private final ApplicationContext context;

    @Value("${bsc.testnet.url}")
    String bscTestnetUrl;

    @Value("${bsc.mainnet.url}")
    String bscMainnetUrl;



    @Bean("bsc_testnet")
    public Web3j bscTestnetWeb3j() {
        return Web3j.build(new HttpService(bscTestnetUrl));
    }

    @Bean("bsc")
    public Web3j bscMainnetWeb3j() {
        return Web3j.build(new HttpService(bscMainnetUrl));
    }

    @EventListener(ApplicationReadyEvent.class)
    public void printNumberOfNodeConnections() {
        log.info("Found {} node connections: {}", context.getBeanNamesForType(Web3j.class).length,
                context.getBeanNamesForType(Web3j.class));
    }
}
