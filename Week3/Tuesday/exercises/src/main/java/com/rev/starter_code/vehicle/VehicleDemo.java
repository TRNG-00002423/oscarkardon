package com.rev.starter_code.vehicle;

import java.util.ArrayList;
import java.util.List;

public class VehicleDemo {
    public static void main(String[] args) {
        List<Vehicle> vehicleList = new ArrayList<>();
        // TODO: add GasCar, ElectricCar, optionally one that implements AutonomousCapable
        // TODO: polymorphic loop + instanceof demo
        GasCar gasCar = new GasCar("Pilot", 2014, 20.0, 35.99);
        ElectricCar electricCar = new ElectricCar("Model X", 2024, 300, 2.5);

        vehicleList.add(electricCar);
        vehicleList.add(gasCar);

        for (Vehicle vehicle : vehicleList) {
            System.out.println("Fuel cost per 100 km for a " + vehicle.getModelYear() + " " + vehicle.getMake() + ": " + vehicle.fuelCostPer100Km());
            
        }
    }
}
