package com.demo.demoProject;

import static org.springframework.boot.test.context.SpringBootTest.WebEnvironment.RANDOM_PORT;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;

@SpringBootTest(webEnvironment = RANDOM_PORT)
class ApplicationTest {

    private static final String HELLO_ENDPOINT = "api/hello";

    @Value(value = "${local.server.port}")
    private int port;

    @Autowired
    private TestRestTemplate restTemplate;

    @Test
    void contextLoads() {
    }

    private String getHelloEndpointUrl() {
        return getLocalServerUrl() + HELLO_ENDPOINT;
    }

    private String getLocalServerUrl() {
        return String.format("http://localhost:%d/", port);
    }
}
