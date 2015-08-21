/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.epam.tc.taxi.view;

import com.epam.tc.taxi.view.util.InputStub;
import com.epam.tc.taxi.view.util.CarDescriptor;
import com.epam.tc.taxi.view.util.IPrinter;
import com.epam.tc.taxi.view.util.IInput;
import com.epam.tc.taxi.controller.TaxiController;
import com.epam.tc.taxi.controller.TaxiControllerCommand;
import com.epam.tc.taxi.entity.AutoPark;
import com.epam.tc.taxi.entity.Car;
import com.epam.tc.taxi.logic.CarType;
import com.epam.tc.taxi.controller.bean.TaxiParamName;
import com.epam.tc.taxi.controller.bean.TaxiControllerRequest;
import com.epam.tc.taxi.view.util.PrinterCreator;
import java.util.List;
import org.apache.log4j.BasicConfigurator;
import org.apache.log4j.Logger;

/**
 *
 * @author Pavel
 */
public class TaxiView {

    private static final TaxiController CONTROLLER = new TaxiController();
    private static final IPrinter PRINTER = PrinterCreator.createConsolePrinter(new CarDescriptor());
    private static final Logger LOGGER = Logger.getLogger(TaxiView.class);

    public TaxiView() {
        super();
        BasicConfigurator.configure();
    }

    private TaxiControllerRequest getParametersForNewCar(CarType carType) {
        TaxiControllerRequest request = new TaxiControllerRequest();
        IInput input = new InputStub();
        request.addParam(TaxiParamName.CAR_TYPE, carType);
        switch (carType) {
            case TAXI:
                request.addParam(TaxiParamName.TARIFF, input.getTariffInput());
            case PASSENGER_CAR:
                request.addParam(TaxiParamName.BODY_TYPE, input.getPassengerBodyTypeInput());
                request.addParam(TaxiParamName.PASSENGER_CAPACITY, input.getPassengerCapacityInput());
                request.addParam(TaxiParamName.BAGGAGE_SPACE, input.getBaggageSpaceInput());
            case CAR:
                request.addParam(TaxiParamName.VIN, input.getVinInput());
                request.addParam(TaxiParamName.MAX_SPEED, input.getMaxSpeedInput());
                request.addParam(TaxiParamName.COST, input.getCostInput());
                request.addParam(TaxiParamName.FUEL_CONSUMPTION, input.getFuelConsumptionInput());
                request.addParam(TaxiParamName.DISTANCE_PASSED, input.getDistancePassedInput());
                request.addParam(TaxiParamName.CURRENT_FUEL, input.getCurrentFuelInput());
                return request;
            case RACE_CAR:
                request.addParam(TaxiParamName.AUTHORIZED_FOR, input.getAuthorizedForInput());
                request.addParam(TaxiParamName.VIN, input.getVinInput());
                request.addParam(TaxiParamName.MAX_SPEED, input.getMaxSpeedInput());
                request.addParam(TaxiParamName.COST, input.getCostInput());
                request.addParam(TaxiParamName.FUEL_CONSUMPTION, input.getFuelConsumptionInput());
                request.addParam(TaxiParamName.DISTANCE_PASSED, input.getDistancePassedInput());
                request.addParam(TaxiParamName.CURRENT_FUEL, input.getCurrentFuelInput());
                return request;
            default:
                LOGGER.error("Incorrect CarType: " + carType.name());
                return null;
        }
    }

    private TaxiControllerRequest getParametersForSort() {
        TaxiControllerRequest request = new TaxiControllerRequest();
        IInput input = new InputStub();
        request.addParam(TaxiParamName.SORT_ASCENDING, input.getAscendingInput());
        return request;
    }

    private TaxiControllerRequest getParametersForFind() {
        TaxiControllerRequest request = new TaxiControllerRequest();
        IInput input = new InputStub();
        int[] speeds = input.getSpeedRange();
        request.addParam(TaxiParamName.FROM_SPEED, speeds[0]);
        request.addParam(TaxiParamName.TO_SPEED, speeds[1]);
        return request;
    }

    public void run() {
        

        AutoPark park = null;

        park = (AutoPark) CONTROLLER.execute(TaxiControllerCommand.CREATE_NEW_PARK, park);

        nullCheck(park);
        
        nullCheck(CONTROLLER.execute(TaxiControllerCommand.ADD_NEW_CAR, park, 
                getParametersForNewCar(CarType.TAXI)));
        nullCheck(CONTROLLER.execute(TaxiControllerCommand.ADD_NEW_CAR, park, 
                getParametersForNewCar(CarType.TAXI)));
        nullCheck(CONTROLLER.execute(TaxiControllerCommand.ADD_NEW_CAR, park, 
                getParametersForNewCar(CarType.TAXI)));
        nullCheck(CONTROLLER.execute(TaxiControllerCommand.ADD_NEW_CAR, park, 
                getParametersForNewCar(CarType.TAXI)));
        nullCheck(CONTROLLER.execute(TaxiControllerCommand.ADD_NEW_CAR, park, 
                getParametersForNewCar(CarType.TAXI)));

        PRINTER.printTaxiPark(park);

        int cost = (Integer) CONTROLLER.execute(TaxiControllerCommand.CALCULATE_PARK_COST, park);
        nullCheck(cost);
        
        PRINTER.print("Park cost: " + cost);

        nullCheck(CONTROLLER.execute(TaxiControllerCommand.SORT_CARS_BY_CONSUMPTION, 
                park, getParametersForSort()));

        PRINTER.printTaxiPark(park);

        PRINTER.print("Found cars within speed range:\n");

        List<Car> list = (List<Car>) CONTROLLER.execute(
                TaxiControllerCommand.FIND_CAR_BY_SPEED, park, 
                getParametersForFind());
        nullCheck(list);
        
        PRINTER.printList(list);
                
    }
    
    //Well, instead of this, 
    private void nullCheck(Object obj){
        if (obj==null){
            LOGGER.error("Controller returned null, please check your "
                    + "TaxiController.execute() parameters");
        }
    }
    
}
