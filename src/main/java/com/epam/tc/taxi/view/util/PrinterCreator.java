/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.epam.tc.taxi.view.util;

/**
 *
 * @author ExO
 */
public class PrinterCreator {
    
    public static IPrinter createConsolePrinter(IDescriptor descriptor){
        return new ConsolePrinter(descriptor);
    }
    
}
