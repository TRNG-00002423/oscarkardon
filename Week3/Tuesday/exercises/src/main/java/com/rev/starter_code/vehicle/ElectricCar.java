package com.rev.starter_code.vehicle;

public class ElectricCar extends Vehicle implements AutonomousCapable{
    // TODO fields: e.g. kWhPer100Km, pricePerKWh
    private double kWhPer100Km;
    private double pricePerKWh;

    public ElectricCar(String make, int modelYear, double kWhPer100Km, double pricePerKWh){
        super(make, modelYear);
        this.kWhPer100Km = kWhPer100Km;
        this.pricePerKWh = pricePerKWh;
    }

    @Override
    public double fuelCostPer100Km() {
        return kWhPer100Km * pricePerKWh;
    }

    public boolean supportsSelfDrive(){
        return true;
    }
}
