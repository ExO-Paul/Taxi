/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.epam.tc.taxi.entity;

/**
 *
 * @author ExO
 */
public class Car {

    private int maxSpeed;
    private int cost;
    private int fuelConsumption;
    private int distancePassed;
    private int currentFuel;
    private long vin;

    public Car() {
    }

    public Car(int maxSpeed, int cost, int fuelConsumption, int distancePassed, int currentFuel, long vin) {
        this.maxSpeed = maxSpeed;
        this.cost = cost;
        this.fuelConsumption = fuelConsumption;
        this.distancePassed = distancePassed;
        this.currentFuel = currentFuel;
        this.vin = vin;
    }

    public int getMaxSpeed() {
        return maxSpeed;
    }

    public void setMaxSpeed(int maxSpeed) {
        this.maxSpeed = maxSpeed;
    }

    public int getCost() {
        return cost;
    }

    public void setCost(int cost) {
        this.cost = cost;
    }

    public int getFuelConsumption() {
        return fuelConsumption;
    }

    public void setFuelConsumption(int fuelCosumption) {
        this.fuelConsumption = fuelCosumption;
    }

    public int getDistancePassed() {
        return distancePassed;
    }

    public void setDistancePassed(int distancePassed) {
        this.distancePassed = distancePassed;
    }

    public int getCurrentFuel() {
        return currentFuel;
    }

    public void setCurrentFuel(int currentFuel) {
        this.currentFuel = currentFuel;
    }

    public long getVin() {
        return vin;
    }

    public void setVin(long vin) {
        this.vin = vin;
    }

    @Override
    public String toString() {
        return getClass().getName() + "@ VIN: " + this.getVin() + " Max speed: "
                + this.getMaxSpeed() + " Fuel consumption: " + this.getFuelConsumption()
                + " Cost: " + this.getCost() + " Distance passed: "
                + this.getDistancePassed() + " Current fuel: "
                + this.getCurrentFuel();
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
        Car other = (Car) o;
        if (maxSpeed != other.maxSpeed) {
            return false;
        }
        if (cost != other.cost) {
            return false;
        }
        if (fuelConsumption != other.fuelConsumption) {
            return false;
        }
        if (vin != other.vin) {
            return false;
        }
        if (distancePassed != other.distancePassed) {
            return false;
        }
        if (currentFuel != other.currentFuel) {
            return false;
        }
        return true;
    }

    @Override
    public int hashCode() {
        return 3 * maxSpeed + 5 * cost + 7 * fuelConsumption
                + 31 * distancePassed + 23 * currentFuel
                + (int) (vin ^ (vin >>> 32));
    }

}
