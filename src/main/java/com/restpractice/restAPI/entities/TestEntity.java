package com.restpractice.restAPI.entities;

import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
@NoArgsConstructor
@Data
public class TestEntity {
    @Id
    public Integer id = 0;

    public String name = null;

    @Override
    public String toString() {
        return String.format(
                "Person[id=%d, name='%s']",
                id, name);
    }
}
