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
public interface IPrinter {
    
    void print(String s);
    
    void printList(List <? extends Car> list);
    
    void printTaxiPark (AutoPark park);
    
}
