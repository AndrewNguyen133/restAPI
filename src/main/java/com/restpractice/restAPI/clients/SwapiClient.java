package com.restpractice.restAPI.clients;

import com.restpractice.restAPI.service.SwapiService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
public class SwapiClient {
    private SwapiService swapiService;

    public Object getSwapi() {
        return swapiService.getSnapiHttpClientSync();
    }
}
