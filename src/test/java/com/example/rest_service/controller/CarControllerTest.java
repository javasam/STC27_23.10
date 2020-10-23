package com.example.rest_service.controller;

import com.example.rest_service.repository.CarsRepository;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import javax.sql.DataSource;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;

class CarControllerTest {

    @Test
    void findTest() {
        DataSource dataSource = Mockito.mock(DataSource.class);
        CarsRepository carsRepository = Mockito.mock(CarsRepository.class);
        CarController carController = new CarController(carsRepository, dataSource);
        Optional<?> optional = carController.find(1L);
        assertEquals(Optional.of("Car not found"), optional);
    }

    @Test
    void addCar() {
    }

    @Test
    void showAll() {
    }

    @Test
    void showOneRow() {
    }
}