package com.rev.starter_code.vehicle;

public class GasCar extends Vehicle {
    // TODO fields: e.g. litersPer100Km, pricePerLiter
    private double litersPer100km;
    private double pricePerLiter;

    public GasCar(String name, int modelYear, double litersPer100km, double pricePerLiter){
        super(name, modelYear);
        this.litersPer100km = litersPer100km;
        this.pricePerLiter = pricePerLiter;

    }

    @Override
    public double fuelCostPer100Km() {
        return litersPer100km * pricePerLiter;
    }
}
