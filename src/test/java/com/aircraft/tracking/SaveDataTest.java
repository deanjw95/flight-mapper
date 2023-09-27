package com.aircraft.tracking;

import com.aircraft.tracking.dto.AirlineRequest;
import com.aircraft.tracking.dto.AirportRequest;
import com.aircraft.tracking.dto.CityRequest;
import com.aircraft.tracking.dto.RouteRequest;
import com.aircraft.tracking.entity.Airline;
import com.aircraft.tracking.entity.Airport;
import com.aircraft.tracking.entity.City;
import com.aircraft.tracking.entity.Route;
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
    AirlineRepository airlineRepository;
    @Autowired
    AirportRepository airportRepository;
    @Autowired
    CityRepository cityRepository;
    @Autowired
    RouteRepository routeRepository;

    @Test
    public void saveAirports() throws IOException, InterruptedException {
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create("https://airlabs.co/api/v9/airports.json?&api_key=9a4c5309-9dae-4240-81f7-2a2b4b1e475b"))
                .method("GET", HttpRequest.BodyPublishers.noBody())
                .build();

        HttpResponse<String> response = HttpClient.newHttpClient().send(request, HttpResponse.BodyHandlers.ofString());

        ObjectMapper objectMapper = new ObjectMapper();
        AirportRequest airportRequest = objectMapper.readValue(response.body(), AirportRequest.class);

        List<AirportRequest.AirportResponse> airports = airportRequest.getResponse();

        List<Airport> airportList = airports.stream()
                .map(Airport::new)
                .collect(Collectors.toList());

        // save all
        airportRepository.saveAll(airportList);

        // save가 잘 됐는지 확인
        List<Airport> all = airportRepository.findAll();
        Assertions.assertThat(all.size()).isEqualTo(airports.size());
    }

    @Test
    public void saveAirlines() throws IOException, InterruptedException {
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create("https://airlabs.co/api/v9/airlines.json?&api_key=9a4c5309-9dae-4240-81f7-2a2b4b1e475b"))
                .method("GET", HttpRequest.BodyPublishers.noBody())
                .build();

        HttpResponse<String> response = HttpClient.newHttpClient().send(request, HttpResponse.BodyHandlers.ofString());

        ObjectMapper objectMapper = new ObjectMapper();
        AirlineRequest airlineRequest = objectMapper.readValue(response.body(), AirlineRequest.class);

        List<AirlineRequest.AirlineResponse> airlines = airlineRequest.getResponse();

        List<Airline> airlineList = airlines.stream()
                .map(Airline::new)
                .collect(Collectors.toList());

        airlineRepository.saveAll(airlineList);

        List<Airline> all = airlineRepository.findAll();
        Assertions.assertThat(all.size()).isEqualTo(airlines.size());
    }

    @Test
    public void saveCities() throws IOException, InterruptedException {
        HttpResponse<String> response = HttpClient.newHttpClient()
                .send(HttpRequest.newBuilder()
                        .uri(URI.create("https://airlabs.co/api/v9/cities.json?&api_key=9a4c5309-9dae-4240-81f7-2a2b4b1e475b"))
                        .method("GET", HttpRequest.BodyPublishers.noBody())
                        .build(), HttpResponse.BodyHandlers.ofString());

        CityRequest cityRequest = new ObjectMapper().readValue(response.body(), CityRequest.class);

        List<City> cityList = cityRequest.getResponse().stream()
                .map(City::new)
                .collect(Collectors.toList());

        cityRepository.saveAll(cityList);
    }

    @Test
    public void saveRoutes() throws IOException, InterruptedException {
        HttpResponse<String> response = HttpClient.newHttpClient()
                .send(HttpRequest.newBuilder()
                        .uri(URI.create("https://airlabs.co/api/v9/routes.json?&api_key=9a4c5309-9dae-4240-81f7-2a2b4b1e475b"))
                        .method("GET", HttpRequest.BodyPublishers.noBody())
                        .build(), HttpResponse.BodyHandlers.ofString());

        RouteRequest routeRequest = new ObjectMapper().readValue(response.body(), RouteRequest.class);

        List<Route> routeList = routeRequest.getResponse().stream()
                .map(Route::new)
                .collect(Collectors.toList());

        routeRepository.saveAll(routeList);
    }


}
