package com.rev.starter_code.vehicle;
/**
 * TODO: abstract Vehicle — encapsulate fields, declare abstract cost method.
 */
public abstract class Vehicle {
    private String make;
    private int modelYear;

    public Vehicle(String make, int modelYear){
        this.make = make;
        this.modelYear = modelYear;
    }

    public abstract double fuelCostPer100Km();

    public String getMake(){
        return make;
    }
    public int getModelYear(){
        return modelYear;
    }
}
