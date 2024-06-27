package com.worldline.interview.model;

public class SteamEngine extends AbstractEngine {

    public SteamEngine(FuelType fuelType) {
        this.fuelType = fuelType;
    }

    @Override
    public int getBatchSize() {
        return 2;
    }

    @Override
    public int getCostPerBatch() {
        // I have chosen to express the cost as an integer in order to avoid the precision problems with floating point calculations.
        // Therefore, I multiply the cost by 100 to convert it from "pounds" to "pence".
        return fuelType == FuelType.WOOD ? 435 : 565;
    }

    @Override
    protected boolean isValidFuelType(FuelType fuelType) {
        return fuelType == FuelType.WOOD || fuelType == FuelType.COAL;
    }
}
