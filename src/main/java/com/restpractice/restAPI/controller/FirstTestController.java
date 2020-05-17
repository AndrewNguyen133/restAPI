package com.restpractice.restAPI.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.mysql.cj.log.Slf4JLogger;
import com.restpractice.restAPI.entities.TestEntity;
import com.restpractice.restAPI.service.FirstTestService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RestController
@RequestMapping("first")
@RequiredArgsConstructor
public class FirstTestController {

    private final FirstTestService firstTestService;
    private final Slf4JLogger logger;

    @GetMapping("/healthCheck")
    @ResponseBody
    public String healthCheck() {
        return firstTestService.healthCheck();
    }

    @PostMapping("/create")
    @ResponseBody
    public void createEntity(@RequestBody String testEntity) {
        try {
            ObjectMapper mapper = new ObjectMapper();
            TestEntity entity = mapper.readValue(testEntity, TestEntity.class);
            firstTestService.createEntity(entity);
        }
        catch(JsonProcessingException e) {
            logger.logWarn(e);
        }
    }

    @GetMapping("/read")
    public List<TestEntity> getAllEntities() {
        try {
            return firstTestService.findAll();
        }
        catch (Exception e) {
            System.out.println(e);
            return null;
        }
    }

    @DeleteMapping("/users/{id}")
    public void delete(@PathVariable String id) {
        Long userId = Long.parseLong(id);
        firstTestService.deleteEntityById(userId);
    }

    @GetMapping("/users/count")
    public Long count() {
        return firstTestService.count();
    }

    //////////////////// test endpoints //////////////////////////////
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
