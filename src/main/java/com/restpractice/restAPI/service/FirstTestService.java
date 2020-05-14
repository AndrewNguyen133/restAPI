package com.restpractice.restAPI.service;

import com.restpractice.restAPI.entities.TestEntity;
import com.restpractice.restAPI.repository.TestRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class FirstTestService {

    @Autowired
    private final TestRepo testRepo;

    public List<TestEntity> findAll() {
        var it = testRepo.findAll();
        var users = new ArrayList<TestEntity>();
        it.forEach(e -> users.add(e));
        return users;
    }

    public Long count() {
        return testRepo.count();
    }

    public void deleteById(Long userId) {
        testRepo.deleteById(userId);
    }
}

