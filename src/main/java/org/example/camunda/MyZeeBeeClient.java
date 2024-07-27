package org.example.camunda;

import io.camunda.zeebe.client.ZeebeClient;
import jakarta.annotation.PostConstruct;
import org.springframework.stereotype.Component;

@Component
public class MyZeeBeeClient {

    private ZeebeClient client;

    public MyZeeBeeClient() {
    }

    @PostConstruct
    public  void init() {
        System.out.println("Zeebee Connection Established");

        String ZEEBE_ADDRESS = "127.0.0.1:26500";

        client = ZeebeClient
                             .newClientBuilder()
                             .gatewayAddress(ZEEBE_ADDRESS)
                             .usePlaintext()
                             .build();
    }

    public ZeebeClient getClient() {
        return client;
    }
}