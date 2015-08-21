/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.epam.tc.taxi.logic;

import com.epam.tc.taxi.logic.util.CarFactory;
import com.epam.tc.taxi.entity.Car;
import com.epam.tc.taxi.entity.AutoPark;
import com.epam.tc.taxi.entity.PassengerBodyType;
import com.epam.tc.taxi.entity.RaceClass;
import com.epam.tc.taxi.logic.util.CarConsumptionComparator;
import com.epam.tc.taxi.logic.util.UnsupportedCarTypeException;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

/**
 *
 * @author Pavel
 */
public class ParkWorker {

    private static final CarConsumptionComparator COMPARATOR = new CarConsumptionComparator();
    private static final CarFactory CAR_FACTORY = new CarFactory();

    public ParkWorker() {
        super();
    }

    public AutoPark createPark() {
        return new AutoPark();
    }

    public void addNewCar(AutoPark park, CarType carType, int maxSpeed, int cost,
            int fuelConsumption, int distancePassed, int currentFuel,
            long vin, RaceClass raceClass, PassengerBodyType bodyType, int PassengerCapacity,
            int baggageSpace, int tariff) throws UnsupportedCarTypeException {

        Car car;
        switch (carType) {
            case CAR:
                car = CAR_FACTORY.makeCar(carType, maxSpeed, cost, fuelConsumption,
                        distancePassed, currentFuel, vin);
                break;
            case RACE_CAR:
                car = CAR_FACTORY.makeCar(carType, maxSpeed, cost, fuelConsumption,
                        distancePassed, currentFuel, vin, raceClass);
                break;
            case PASSENGER_CAR:
                car = CAR_FACTORY.makeCar(carType, maxSpeed, cost, fuelConsumption,
                        distancePassed, currentFuel, vin, bodyType,
                        PassengerCapacity, baggageSpace);
                break;
            case TAXI:
                car = CAR_FACTORY.makeCar(carType, maxSpeed, cost, fuelConsumption,
                        distancePassed, currentFuel, vin, bodyType,
                        PassengerCapacity, baggageSpace, tariff);
                break;
            default:
                throw new UnsupportedCarTypeException();
        }

        park.addCar(car);
    }

    public int calculateCost(AutoPark park) {
        int cost = 0;
        for (Car car : park.getCars()) {
            cost += car.getCost();
        }
        return cost;
    }

    public void sortCarsByConsumption(AutoPark park, boolean ascending) {
       
        COMPARATOR.setAscending(ascending);

        List<Car> list = park.getCars();
        Collections.sort(list, COMPARATOR);
    }

    public List<Car> findCarBySpeed(AutoPark park, int fromSpeed, int toSpeed) {
        List<Car> results = new LinkedList<>();
        for (Car car : park.getCars()) {
            if (car.getMaxSpeed() >= fromSpeed && car.getMaxSpeed() <= toSpeed) {
                results.add(car);
            }
        }
        return results;
    }
}
