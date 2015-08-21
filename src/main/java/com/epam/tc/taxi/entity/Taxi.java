package com.epam.tc.taxi.entity;

public class Taxi extends PassengerCar{

    private int tariff;

    /**
     * @return the tariff
     */
    public Taxi() {
        super();
    }

    public Taxi(int tariff, PassengerBodyType bodyType ,int passengerCapacity,
            int baggageSpace, int maxSpeed, int cost, int fuelConsumption, 
                    int distancePassed, int currentFuel, long vin){
        super(bodyType, passengerCapacity, baggageSpace, maxSpeed, cost, fuelConsumption, distancePassed, currentFuel, vin);
        this.tariff = tariff;
    } 
        
     public int getTariff() {
        return tariff;
    }

    public void setTariff(int tariff) {
        this.tariff = tariff;
    }
    
    @Override
    public String toString() {
        return super.toString()+" Tariff: " + tariff;
    }
    
    @Override
    public boolean equals(Object o) {
        if (!super.equals(o)){
            return false;
        }
        Taxi other = (Taxi) o;
        if (tariff != other.tariff){
            return false;
        }
        return true;
    }

    @Override
    public int hashCode() {
        return super.hashCode()+5*tariff;
    }
}
