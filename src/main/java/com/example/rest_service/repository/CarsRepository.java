package com.example.rest_service.repository;

import com.example.rest_service.model.Car;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CarsRepository extends CrudRepository<Car, Long> {

}
