package com.aircraft.tracking;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;


public class Airlabs {

    @Test
    public void test() throws IOException, InterruptedException {
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create("http://airlabs.co/api/v9/ping?api_key=9a4c5309-9dae-4240-81f7-2a2b4b1e475b"))
                .method("GET", HttpRequest.BodyPublishers.noBody())
                .build();

        HttpResponse<String> response = HttpClient.newHttpClient().send(request, HttpResponse.BodyHandlers.ofString());
        Assertions.assertThat(response.statusCode()).isEqualTo(200);
    }


}
