package com.example.carmanager.repos;

import com.example.carmanager.domain.Car;
import org.springframework.data.repository.CrudRepository;

public interface CarRepo extends CrudRepository<Car, Integer> {
}
