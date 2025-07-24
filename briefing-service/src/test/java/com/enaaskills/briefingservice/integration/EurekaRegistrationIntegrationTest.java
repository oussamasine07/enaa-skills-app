package com.enaaskills.briefingservice.integration;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.web.client.RestTemplate;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@ActiveProfiles("test")
public class EurekaRegistrationIntegrationTest {

    private final RestTemplate restTemplate = new RestTemplate();

    @Test
    public void testServiceIsRegisteredInEureka() throws InterruptedException {
        Thread.sleep(5000);

        String eurekaUrl = "http://localhost:8761/eureka/apps/BRIEFING-SERVICE";

        String response = restTemplate.getForObject(eurekaUrl, String.class);

        assertThat(response).contains("BRIEFING-SERVICE");
    }
}

