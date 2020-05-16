package com.restpractice.restAPI.service;

import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

@Service
public class SwapiService {
    private String baseUrl = "https://swapi.dev/api/";
    private HttpClient client = HttpClient.newHttpClient();

    public Object getSnapiHttpClientSync() {
        try {
            HttpClient client = this.client;
            HttpRequest request = HttpRequest.newBuilder()
                    .uri(URI.create(this.baseUrl + "people/2/"))
                    .build();
//        client.sendAsync(request, HttpResponse.BodyHandlers.ofString())
//                .thenApply(response -> { System.out.println(response.statusCode());
//                    return response; } )
//                .thenApply(HttpResponse::body)
//                .thenAccept(System.out::println);
            HttpResponse<String> response =
                    client.send(request, HttpResponse.BodyHandlers.ofString());
            System.out.println(response.statusCode());
            System.out.println(response.body());
        }
        catch (Exception e){
            System.out.println(e);
        }
        return null;
    }

}
