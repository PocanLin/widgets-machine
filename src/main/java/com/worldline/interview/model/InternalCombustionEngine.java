package com.worldline.interview.model;

public class InternalCombustionEngine extends AbstractEngine {

    public InternalCombustionEngine(FuelType fuelType) {
        this.fuelType = fuelType;
    }

    @Override
    public int getBatchSize() {
        return 8;
    }

    @Override
    public int getCostPerBatch() {
        // I have chosen to express the cost as an integer in order to avoid the precision problems with floating point calculations.
        // Therefore, I multiply the cost by 100 to convert it from "pounds" to "pence".
        return fuelType == FuelType.PETROL ? 900 : 1200;
    }

    @Override
    protected boolean isValidFuelType(FuelType fuelType) {
        return fuelType == FuelType.PETROL || fuelType == FuelType.DIESEL;
    }
}
