package com.example.carmanager;

import com.example.carmanager.domain.Car;
import com.example.carmanager.repos.CarRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class CarService {

    @Autowired
    private CarRepo carRepo;

    public List<Car> showAll() {
        return (List<Car>) carRepo.findAll();
    }

    public void save(Car car) {
        carRepo.save(car);
    }

    public Car get(int id) {
        return carRepo.findById(id).get();
    }

    public void delete(int id) {
        carRepo.deleteById(id);
    }
}
