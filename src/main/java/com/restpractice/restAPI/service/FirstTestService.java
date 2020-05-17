package com.restpractice.restAPI.service;

import com.restpractice.restAPI.entities.TestEntity;
import com.restpractice.restAPI.repository.TestRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class FirstTestService {

    private final TestRepo testRepo;

    public String healthCheck() {
        return "here";
    }

    public void createEntity(TestEntity entity) {
        testRepo.save(entity);
    }

    public List<TestEntity> findAll() {
        return testRepo.findAll();
    }

    public Long count() {
        return testRepo.count();
    }

    public void deleteEntityById(Long userId) {
        testRepo.deleteById(userId);
    }

}

