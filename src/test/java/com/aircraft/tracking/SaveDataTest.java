package com.aircraft.tracking;

import com.aircraft.tracking.dto.Airlines;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.transaction.annotation.Transactional;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.ArrayList;
import java.util.List;

@SpringBootTest
@Transactional
@Rollback(value = false)
public class SaveDataTest {

    @Autowired
    AirlinesRepository airlinesRepository;

    @Test
    public void saveAirlines() throws IOException, InterruptedException {

        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create("https://airlabs.co/api/v9/airlines.json?&api_key=9a4c5309-9dae-4240-81f7-2a2b4b1e475b"))
                .method("GET", HttpRequest.BodyPublishers.noBody())
                .build();

        // response를 List<Airlines>로 받아야 함
        HttpResponse<JsonNode> response = HttpClient.newHttpClient().send(request, HttpResponse.BodyHandlers.ofJson());

        ObjectMapper objectMapper = new ObjectMapper();
        List<Airlines> airlines = objectMapper.readValue(response.body(), new TypeReference<List<Airlines>>() {
        });

        // save all
        airlinesRepository.saveAll(airlines);
        // save가 잘 됐는지 확인
        List<Airlines> all = airlinesRepository.findAll();
        Assertions.assertThat(all.size()).isEqualTo(airlines.size());

    }

}
