package com.restpractice.restAPI.controller;

import com.restpractice.restAPI.entities.TestEntity;
import com.restpractice.restAPI.exceptions.GeneralException;
import com.restpractice.restAPI.service.FirstTestService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("first")
@RequiredArgsConstructor
public class FirstTestController {

    private final FirstTestService firstTestService;

    @GetMapping("/users")
    public List<TestEntity> allUsers() {
        return firstTestService.findAll();
    }

    @GetMapping("/users/count")
    public Long count() {
        return firstTestService.count();
    }

    @DeleteMapping("/users/{id}")
    public void delete(@PathVariable String id) {
        Long userId = Long.parseLong(id);
        firstTestService.deleteById(userId);
    }

    // test endpoints
    @GetMapping(consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public String getName() { return "Andrew"; }

    @GetMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public String getNamePath(@PathVariable("id") String id) {
        return id;
    }

    @GetMapping(value = "/{id}/queryparam", produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public Integer getIdPath(@RequestParam("age") Integer age) {
        return age;
    }

    @PostMapping(value = "/{id}/queryparam", consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public Integer getIdPathPost(@RequestBody Integer age) {
        return age;
    }
}
