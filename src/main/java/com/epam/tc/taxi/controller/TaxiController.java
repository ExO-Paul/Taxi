/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.epam.tc.taxi.controller;

import com.epam.tc.taxi.entity.AutoPark;
import com.epam.tc.taxi.controller.bean.TaxiParamName;
import com.epam.tc.taxi.logic.ParkWorker;
import com.epam.tc.taxi.controller.bean.TaxiControllerRequest;
import com.epam.tc.taxi.entity.PassengerBodyType;
import com.epam.tc.taxi.entity.RaceClass;
import com.epam.tc.taxi.logic.CarType;
import com.epam.tc.taxi.logic.util.UnsupportedCarTypeException;
import org.apache.log4j.BasicConfigurator;
import org.apache.log4j.Logger;

/**
 *
 * @author Pavel
 */
public class TaxiController {

    private static final ParkWorker PARK_WORKER = new ParkWorker();
    private static final Logger LOGGER = Logger.getLogger(TaxiController.class);

    public TaxiController() {
        super();
        BasicConfigurator.configure();
    }

    public Object execute(TaxiControllerCommand command, AutoPark park,
            TaxiControllerRequest parameters){
        if (park==null || parameters==null){
            return null;
        }
        switch (command) {
            case ADD_NEW_CAR:
                addCar(park, parameters);
                return true;
            case SORT_CARS_BY_CONSUMPTION:
                PARK_WORKER.sortCarsByConsumption(
                        park,
                        (Boolean) parameters.getParam(TaxiParamName.SORT_ASCENDING)
                );
                return true;
            case FIND_CAR_BY_SPEED:
                return PARK_WORKER.findCarBySpeed(park,
                        (Integer) parameters.getParam(TaxiParamName.FROM_SPEED),
                        (Integer) parameters.getParam(TaxiParamName.TO_SPEED)
                );
            default:
                return null;
        }
    }

    public Object execute(TaxiControllerCommand command, AutoPark park) {
    
        switch (command) {
            case CREATE_NEW_PARK:
                return PARK_WORKER.createPark();
            case CALCULATE_PARK_COST:
                if (park==null){
                return null;
                }
                else {
                    return PARK_WORKER.calculateCost(park);
                }
            default:
                return null;
        }
    }

    private void addCar(AutoPark park, TaxiControllerRequest parameters) {
        try {
            PARK_WORKER.addNewCar(park,
                    (CarType) parameters.getParam(TaxiParamName.CAR_TYPE),
                    (Integer) parameters.getParam(TaxiParamName.MAX_SPEED),
                    (Integer) parameters.getParam(TaxiParamName.COST),
                    (Integer) parameters.getParam(TaxiParamName.FUEL_CONSUMPTION),
                    (Integer) parameters.getParam(TaxiParamName.DISTANCE_PASSED),
                    (Integer) parameters.getParam(TaxiParamName.CURRENT_FUEL),
                    (Long) parameters.getParam(TaxiParamName.VIN),
                    (RaceClass) parameters.getParam(TaxiParamName.RACE_CLASS),
                    (PassengerBodyType) parameters.getParam(TaxiParamName.BODY_TYPE),
                    (Integer) parameters.getParam(TaxiParamName.PASSENGER_CAPACITY),
                    (Integer) parameters.getParam(TaxiParamName.BAGGAGE_SPACE),
                    (Integer) parameters.getParam(TaxiParamName.TARIFF)
            );
        } catch (UnsupportedCarTypeException ex) {
            LOGGER.error("Car type is not yet supported", ex);
        }
    }

}
