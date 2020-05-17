package com.restpractice.restAPI.clients;

import com.restpractice.restAPI.service.SwapiService;
import lombok.AllArgsConstructor;
import lombok.NonNull;
import org.springframework.stereotype.Component;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

@Component
@AllArgsConstructor
public class SwapiClient {

    private String baseUrl = "https://swapi.dev/api/";
    // only need the one client so this initialization is ok
    // encourage to try a different a library -> Unirest, Okhttp
    // want people to grab the client and make a set of calls on that client
    private HttpClient client = HttpClient.newHttpClient();

    public Object getSnapiSync(@NonNull String topic, @NonNull Integer num) {
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
