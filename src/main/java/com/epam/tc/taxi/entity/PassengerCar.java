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
public class PassengerCar extends Car {

    private PassengerBodyType bodyType;
    private int passengerCapacity;
    private int baggageSpace;

    public PassengerCar() {
        super();
    }

    public PassengerCar(PassengerBodyType bodyType, int passengerCapacity,
            int baggageSpace, int maxSpeed, int cost, int fuelConsumption,
            int distancePassed, int currentFuel, long vin) {
        super(maxSpeed, cost, fuelConsumption, distancePassed, currentFuel, vin);
        this.bodyType = bodyType;
        this.passengerCapacity = passengerCapacity;
        this.baggageSpace = baggageSpace;
    }

    public int getPassengerCapacity() {
        return passengerCapacity;
    }

    public void setPassengerCapacity(int passengerCapacity) {
        this.passengerCapacity = passengerCapacity;
    }

    public PassengerBodyType getBodyType() {
        return bodyType;
    }

    public void setBodyType(PassengerBodyType bodyType) {
        this.bodyType = bodyType;
    }

    public int getBaggageSpace() {
        return baggageSpace;
    }

    public void setBaggageSpace(int baggageSpace) {
        this.baggageSpace = baggageSpace;
    }

    @Override
    public String toString() {
        return super.toString() + " Body type: " + bodyType.name() + " Baggage space: "
                + baggageSpace + " Passenger capacity: " + passengerCapacity;
    }

    @Override
    public boolean equals(Object o) {

        //TODO: ask if all these checks before super.equals() are needed 
        if (!super.equals(o)) {
            return false;
        }
        PassengerCar other = (PassengerCar) o;
        if (bodyType != other.bodyType) {
            return false;
        }
        if (passengerCapacity != other.getPassengerCapacity()) {
            return false;
        }
        if (baggageSpace != other.getBaggageSpace()) {
            return false;
        }
        return true;
    }

    @Override
    public int hashCode() {
        return super.hashCode() + 3 * passengerCapacity + 7 * baggageSpace
                + 5 * (bodyType == null ? 0 : bodyType.hashCode());
    }

}
