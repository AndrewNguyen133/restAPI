package com.restpractice.restAPI.repository;

import com.restpractice.restAPI.entities.TestEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

public interface TestRepo extends CrudRepository<TestEntity, Long> {
    // declare query methods
    void getIdWhere();
}
