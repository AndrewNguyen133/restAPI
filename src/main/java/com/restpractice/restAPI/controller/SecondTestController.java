package com.restpractice.restAPI.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("lance")
@RequiredArgsConstructor
public class SecondTestController {

    @GetMapping
    @ResponseBody
    // set headers with ResponseBody
    public String getName() {
        return "Andrew";
    }
}
