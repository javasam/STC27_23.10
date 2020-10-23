package com.example.rest_service.controller;

import com.example.rest_service.model.Car;
import com.example.rest_service.repository.CarsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.web.bind.annotation.*;

import javax.sql.DataSource;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

@RestController
@RequestMapping(path = "/rest")
public class CarController {

    CarsRepository carsRepository;
    private final DataSource dataSource;

    @Autowired
    public CarController(CarsRepository carsRepository, DataSource dataSource) {
        this.carsRepository = carsRepository;
        this.dataSource = dataSource;
    }

    //-> http://localhost:8080/rest/car?id=1
    @RequestMapping("/car")
    public Optional<?> find(@RequestParam(value = "id") Long id) {
        if (carsRepository.findById(id).isPresent()) {
            return carsRepository.findById(id);
        }
        return Optional.of("Car not found");
    }

    //  POST -> {"modelName":"VW"} to INSERT or {"id":5,"modelName":"VW"} to UPDATE entry
    @PostMapping("/car")
    public ResponseEntity<?> addCar(@RequestBody Car car) {
        Car newCar = new Car(car.getId(), car.getModelName());
        carsRepository.save(newCar);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    //-> http://localhost:8080/rest/allcars
    @RequestMapping("/allcars")
    public Iterable<Car> showAll() {
        return carsRepository.findAll();
    }

    //-> http://localhost:8080/rest/car/1
    @RequestMapping("/car/{rowNumber}")
    public Map<String, Object> showOneRow(@PathVariable("rowNumber") Integer rowNumber) {
        NamedParameterJdbcTemplate jdbcTemplate = new NamedParameterJdbcTemplate(dataSource);
        Map<String, Integer> paramMap = new HashMap<>();
        paramMap.put("rowNumber", rowNumber);
        return jdbcTemplate.queryForMap("SELECT * FROM cars WHERE id=:rowNumber", paramMap);
    }
}
