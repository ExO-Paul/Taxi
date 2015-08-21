/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.epam.tc.taxi.entity;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 *
 * @author Pavel
 */
public class AutoPark {

    private List<Car> cars;

    public AutoPark() {
        this.cars = new ArrayList<Car>();
    }

    public AutoPark(List<Car> taxies) {
        this.cars = taxies;
    }

    public List<Car> getCars() {
        return cars;
    }

    public void setCars(List<Car> taxies) {
        this.cars = taxies;
    }

    public Car getCar(int position) {
        return cars.get(position);
    }

    public void setCar(int position, Taxi taxi) {
        this.cars.set(position, taxi);
    }

    public void addCar(Car car) {
        cars.add(car);
    }

    @Override
    public int hashCode() {
        return 3*Objects.hashCode(cars);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null) {
            return false;
        }
        if (getClass() != o.getClass()) {
            return false;
        }
        final AutoPark other = (AutoPark) o;
        if (!Objects.equals(this.cars, other.cars)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return this.getClass().getName() + "@ cars=" + cars.toString();
    }

   

    
    
}
