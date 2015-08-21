/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.epam.tc.taxi.view.util;

import com.epam.tc.taxi.entity.Car;
import com.epam.tc.taxi.entity.PassengerCar;
import com.epam.tc.taxi.entity.RaceCar;
import com.epam.tc.taxi.entity.Taxi;

/**
 *
 * @author Pavel
 */
public class CarDescriptor implements IDescriptor{
    
    
    private String getCarDescription(Car car){
        StringBuilder builder = new StringBuilder();
        if (car instanceof Taxi){
            builder.append("Taxi:\n Tariff: ").
                    append(((Taxi)car).getTariff()).
                    append("\nBased on:\n");
        }
        if (car instanceof PassengerCar){
            PassengerCar passCar = (PassengerCar) car;
            builder.append("Passenger car:\n Body type:").
                    append(passCar.getBodyType().name()).
                    append("\n Baggage space:").
                    append(passCar.getBaggageSpace()).
                    append("\n Passenger capacity: ").
                    append(passCar.getPassengerCapacity()).
                    append("\nBased on:\n");
        }
        if (car instanceof RaceCar){
            builder.append("Race car:\n Authorized for:").
                    append(((RaceCar)car).getAuthorizedFor().name()).
                    append("\nBased on:\n");
        }        
        builder.append("Car:\n VIN: ").append(car.getVin()).
                append("\n Max speed: ").append(car.getMaxSpeed()).
                append("\n Fuel consumption: ").append(car.getFuelConsumption()).
                append("\n Cost: ").append(car.getCost()).
                append("\n Distance passed: ").append(car.getDistancePassed()).
                append("\n Current fuel: ").append(car.getCurrentFuel());
        
        return builder.toString();
    }

    @Override
    public String getDescription(Object o) {
        if (o instanceof Car){
            return getCarDescription((Car)o);
        }
        return o.getClass().getName();
    }
}
