/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.epam.tc.taxi.view.util;


import com.epam.tc.taxi.entity.PassengerBodyType;
import com.epam.tc.taxi.entity.RaceClass;
import java.util.Random;

/**
 *
 * @author ExO
 */
public class InputStub implements IInput {

    Random rand = new Random();
    
    @Override
    public int getTariffInput() {
        return rand.nextInt(20);
    }

    @Override
    public PassengerBodyType getPassengerBodyTypeInput() {
        return PassengerBodyType.values()[rand.nextInt(4)]; 
    }
    
    @Override
    public RaceClass getAuthorizedForInput() {
        return RaceClass.values()[rand.nextInt(4)]; 
    }

    @Override
    public int getPassengerCapacityInput() {
        return rand.nextInt(10);
    }

    @Override
    public int getBaggageSpaceInput() {
        return rand.nextInt(200);
    }

    @Override
    public int getMaxSpeedInput() {
        return rand.nextInt(250);
    }

    @Override
    public int getCostInput() {
        return rand.nextInt(30_000);
    }

    @Override
    public int getFuelConsumptionInput() {
        return rand.nextInt(20);
    }

    @Override
    public int getDistancePassedInput() {
       return rand.nextInt(1_000_000);
    }

    @Override
    public int getCurrentFuelInput() {
      return rand.nextInt(60);      
    }

    @Override
    public long getVinInput() {
       return Math.abs(rand.nextLong());
    }

    @Override
    public int getCapacityInput(){
        //return rand.nextInt(10);
        return 10;
    }

    @Override
    public int[] getSpeedRange() {
        int[] result = {100, 150};
        return result;
    }
    
    @Override
    public boolean getAscendingInput(){
        return true;
    }
}
