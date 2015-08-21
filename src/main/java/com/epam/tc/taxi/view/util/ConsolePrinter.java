/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.epam.tc.taxi.view.util;

import com.epam.tc.taxi.entity.AutoPark;
import com.epam.tc.taxi.entity.Car;
import java.util.List;

/**
 *
 * @author ExO
 */
public class ConsolePrinter implements IPrinter {

    IDescriptor descriptor;
    
    public ConsolePrinter(IDescriptor descriptor){
        super();
        this.descriptor = descriptor;
    }
            
    @Override
    public void print(String s) {
        System.out.println(s);
    }

    @Override
    public void printList(List<? extends Car> list) {
        for (Car c : list) {
            System.out.println(descriptor.getDescription(c)+'\n');
        }
    }
    
    @Override
    public void printTaxiPark (AutoPark park){
    StringBuilder builder = new StringBuilder();
        for (Car c : park.getCars()){
           builder.append(descriptor.getDescription(c)).append("\n\n");
        }
        
        System.out.println("---Autopark---\nContains: \n"+builder.toString()); 
    }
}