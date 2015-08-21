/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.epam.tc.taxi.logic.util;

import com.epam.tc.taxi.entity.Car;
import java.util.Comparator;

/**
 *
 * @author Pavel
 */
public class CarConsumptionComparator implements Comparator<Car>{

    private boolean ascending = true;

    public CarConsumptionComparator() {
    }

    public boolean isAscending() {
        return ascending;
    }

    public void setAscending(boolean ascending) {
        this.ascending = ascending;
    }
    
    
    @Override
    public int compare(Car t, Car t1) {
        int i = ascending? 1: -1; 
        return i*(t.getFuelConsumption()-t1.getFuelConsumption());
    }

}
