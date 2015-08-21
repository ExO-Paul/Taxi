/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.epam.tc.taxi.entity;

/**
 *
 * @author Pavel
 */
public class RaceCar extends Car {

    private RaceClass authorizedFor;

    public RaceCar() {
    }

    public RaceCar(RaceClass authorizedFor, int maxSpeed, int cost, int fuelConsumption, int distancePassed, int currentFuel, long vin) {
        super(maxSpeed, cost, fuelConsumption, distancePassed, currentFuel, vin);
        this.authorizedFor = authorizedFor;
    }

    public RaceClass getAuthorizedFor() {
        return authorizedFor;
    }

    public void setAuthorizedFor(RaceClass authorizedFor) {
        this.authorizedFor = authorizedFor;
    }

    @Override
    public String toString() {
        return super.toString() + " Authorized for: " + authorizedFor.name();
    }

    @Override
    public boolean equals(Object o) {
        if (!super.equals(o)) {
            return false;
        }
        RaceCar other = (RaceCar) o;
        if (authorizedFor != other.authorizedFor){
            return false;
        }
        return true;
    }

    @Override
        public int hashCode() {
        return super.hashCode() + 3 *(authorizedFor==null?0:authorizedFor.hashCode());
    }

}
