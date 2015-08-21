/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.epam.tc.taxi.logic.util;

import com.epam.tc.taxi.entity.Car;
import com.epam.tc.taxi.entity.PassengerBodyType;
import com.epam.tc.taxi.entity.PassengerCar;
import com.epam.tc.taxi.entity.RaceCar;
import com.epam.tc.taxi.entity.RaceClass;
import com.epam.tc.taxi.entity.Taxi;
import com.epam.tc.taxi.logic.CarType;

/**
 *
 * @author Pavel
 */
public class CarFactory {
    
    public Car makeCar (CarType carType, int maxSpeed, int cost,
            int fuelConsumption, int distancePassed, int currentFuel,
            long vin) 
            throws UnsupportedCarTypeException  {
        
        switch (carType) {
            case CAR:
               return new Car(maxSpeed, cost, fuelConsumption, distancePassed, 
                       currentFuel, vin);
            default:
                throw new UnsupportedCarTypeException();
        }
    }
        
      public Car makeCar (CarType carType, int maxSpeed, int cost,
            int fuelConsumption, int distancePassed, int currentFuel,
            long vin, RaceClass raceClass) 
            throws UnsupportedCarTypeException  {
        
        switch (carType) {
            case CAR:
               return new Car(maxSpeed, cost, fuelConsumption, distancePassed, 
                       currentFuel, vin);
            case RACE_CAR:
               return new RaceCar(raceClass, maxSpeed, cost, fuelConsumption, 
                       distancePassed, currentFuel, vin);
            default:
                throw new UnsupportedCarTypeException();
        }
    }  
        
      public Car makeCar (CarType carType, int maxSpeed, int cost,
            int fuelConsumption, int distancePassed, int currentFuel,
            long vin, PassengerBodyType bodyType,
            int PassengerCapacity, int baggageSpace) 
            throws UnsupportedCarTypeException  {
          
        switch (carType) {
            case CAR:
               return new Car(maxSpeed, cost, fuelConsumption, distancePassed, 
                       currentFuel, vin);
            case PASSENGER_CAR:
               return new PassengerCar(bodyType, PassengerCapacity, baggageSpace,
                       maxSpeed, cost, fuelConsumption, distancePassed,
                       currentFuel, vin);
            default:
                throw new UnsupportedCarTypeException();
        }
    }
      
      public Car makeCar (CarType carType, int maxSpeed, int cost,
            int fuelConsumption, int distancePassed, int currentFuel,
            long vin, PassengerBodyType bodyType,
            int PassengerCapacity, int baggageSpace, int tariff) 
            throws UnsupportedCarTypeException  {
          
        switch (carType) {
             case CAR:
               return new Car(maxSpeed, cost, fuelConsumption, distancePassed, 
                       currentFuel, vin);
            case PASSENGER_CAR:
               return new PassengerCar(bodyType, PassengerCapacity, baggageSpace,
                       maxSpeed, cost, fuelConsumption, distancePassed,
                       currentFuel, vin);
            case TAXI:
                return new Taxi(tariff, bodyType, PassengerCapacity, baggageSpace,
                        maxSpeed, cost, fuelConsumption, distancePassed, 
                        currentFuel, vin);
            default:
                throw new UnsupportedCarTypeException();
        }
    }
          
          
          
          
        
          
            
            
       
    
    
}
