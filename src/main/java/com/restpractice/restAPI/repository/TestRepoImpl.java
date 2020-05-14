package com.restpractice.restAPI.repository;

import com.restpractice.restAPI.entities.TestEntity;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public class TestRepoImpl implements TestRepo {
    @Override
    public void getIdWhere() {

    }

    @Override
    public <S extends TestEntity> S save(S s) {
        return null;
    }

    @Override
    public <S extends TestEntity> Iterable<S> saveAll(Iterable<S> iterable) {
        return null;
    }

    @Override
    public Optional<TestEntity> findById(Long aLong) {
        return Optional.empty();
    }

    @Override
    public boolean existsById(Long aLong) {
        return false;
    }

    @Override
    public Iterable<TestEntity> findAll() {
        return null;
    }

    @Override
    public Iterable<TestEntity> findAllById(Iterable<Long> iterable) {
        return null;
    }

    @Override
    public long count() {
        return 0;
    }

    @Override
    public void deleteById(Long aLong) {

    }

    @Override
    public void delete(TestEntity testEntity) {

    }

    @Override
    public void deleteAll(Iterable<? extends TestEntity> iterable) {

    }

    @Override
    public void deleteAll() {

    }
}
