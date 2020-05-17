package com.restpractice.restAPI.controller;

import com.restpractice.restAPI.clients.SwapiClient;
import lombok.AllArgsConstructor;
import lombok.NonNull;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("swapi")
@AllArgsConstructor
public class SwapiController {
    // add a private final client
    // the helper will use a service that has the query methods
    private final SwapiClient swapiClient;

    @GetMapping
    public void getSwapi(@RequestParam("topic") @NonNull String topic,
                         @RequestParam("num") @NonNull Integer num) {
        swapiClient.getSnapiSync(topic, num);
    }
}
