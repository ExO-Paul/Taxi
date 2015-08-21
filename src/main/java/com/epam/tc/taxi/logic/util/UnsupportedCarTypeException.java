/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.epam.tc.taxi.logic.util;

/**
 *
 * @author Pavel
 */
public class UnsupportedCarTypeException extends Exception {

    public UnsupportedCarTypeException() {
    }

    public UnsupportedCarTypeException(String message) {
        super(message);
    }
   
}
