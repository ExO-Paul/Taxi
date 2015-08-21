/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.epam.tc.taxi.view.util;

import com.epam.tc.taxi.entity.PassengerBodyType;
import com.epam.tc.taxi.entity.RaceClass;

/**
 *
 * @author ExO
 */
public interface IInput {
   
   int getTariffInput();
   
   PassengerBodyType getPassengerBodyTypeInput();
   
   RaceClass getAuthorizedForInput();
   
   int getPassengerCapacityInput();
   
   int getBaggageSpaceInput();
   
   int getMaxSpeedInput();
   
   int getCostInput();
   
   int getFuelConsumptionInput();
   
   int getDistancePassedInput();
   
   int getCurrentFuelInput();
   
   long getVinInput();
   
   int getCapacityInput();
   
   int[] getSpeedRange();
   
   boolean getAscendingInput();
    
}
