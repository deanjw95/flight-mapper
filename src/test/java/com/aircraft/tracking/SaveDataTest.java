package com.aircraft.tracking;

import com.aircraft.tracking.dto.AirlineRequest;
import com.aircraft.tracking.entity.Airline;
import com.aircraft.tracking.entity.Airport;
import com.fasterxml.jackson.core.type.TypeReference;
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
import java.util.List;
import java.util.stream.Collectors;

@SpringBootTest
@Transactional
@Rollback(value = false)
public class SaveDataTest {

    @Autowired
    AirlinesRepository airlinesRepository;
    @Autowired
    AirportRepository airportRepository;

    @Test
    public void saveAirlines() throws IOException, InterruptedException {

        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create("https://airlabs.co/api/v9/airlines.json?&api_key=9a4c5309-9dae-4240-81f7-2a2b4b1e475b"))
                .method("GET", HttpRequest.BodyPublishers.noBody())
                .build();

        // response를 List<Airlines>로 받아야 함
        HttpResponse<String> response = HttpClient.newHttpClient().send(request, HttpResponse.BodyHandlers.ofString());


        ObjectMapper objectMapper = new ObjectMapper();
        List<Airline> airlines = objectMapper.readValue(response.body(), new TypeReference<List<Airline>>() {
        });

        // save all
        airlinesRepository.saveAll(airlines);
        // save가 잘 됐는지 확인
        List<Airline> all = airlinesRepository.findAll();
        Assertions.assertThat(all.size()).isEqualTo(airlines.size());

    }

    @Test
    public void saveAirports() throws IOException, InterruptedException {
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create("https://airlabs.co/api/v9/airports.json?&api_key=9a4c5309-9dae-4240-81f7-2a2b4b1e475b"))
                .method("GET", HttpRequest.BodyPublishers.noBody())
                .build();

        HttpResponse<String> response = HttpClient.newHttpClient().send(request, HttpResponse.BodyHandlers.ofString());

        ObjectMapper objectMapper = new ObjectMapper();
        AirlineRequest airlineRequest = objectMapper.readValue(response.body(), AirlineRequest.class);

        List<AirlineRequest.AirlineResponse> airports = airlineRequest.getResponse();

        List<Airport> airportList = airports.stream()
                .map(Airport::new)
                .collect(Collectors.toList());

        // save all
        airportRepository.saveAll(airportList);

        // save가 잘 됐는지 확인
        List<Airport> all = airportRepository.findAll();
        Assertions.assertThat(all.size()).isEqualTo(airports.size());
    }
}
