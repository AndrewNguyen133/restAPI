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
    // only need the one client so this initialization is ok
    // encourage to try a different a library -> Unirest, Okhttp
    // want people to grab the client and make a set of calls on that client
    private HttpClient client = HttpClient.newHttpClient();

    //        client.sendAsync(request, HttpResponse.BodyHandlers.ofString())
//                .thenApply(response -> { System.out.println(response.statusCode());
//                    return response; } )
//                .thenApply(HttpResponse::body)
//                .thenAccept(System.out::println);

    public Object getSnapiHttpClientSync() {
        // other endpoints for like movies not just people
        // go in and at least one other endpoint
        // make the people one parametized so when search for anyone they can do it
        // implement one other endpoint so can differentiate between the two and show using a couple different ones

        try {
            HttpClient client = this.client;
            HttpRequest request = HttpRequest.newBuilder()
                    .uri(URI.create(this.baseUrl + "people/2/"))
                    .build();
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
