package com.worldline.interview.model;

import com.worldline.interview.exception.InsufficientFuelException;
import com.worldline.interview.exception.InvalidFuelTypeException;

public abstract class AbstractEngine implements Engine {
    protected boolean running;
    protected int fuelLevel;
    protected FuelType fuelType;

    @Override
    public void start() {
        if (fuelLevel <= 0) {
            throw new InsufficientFuelException("Not enough fuel to start the engine");
        }
        if (!isValidFuelType(fuelType)) {
            throw new InvalidFuelTypeException("Invalid fuel type for this engine: " + fuelType);
        }
        running = true;
    }

    @Override
    public void stop() {
        running = false;
    }

    @Override
    public boolean isRunning() {
        return running;
    }

    @Override
    public void fill(FuelType fuelType, int fuelLevel) {
        if (!isValidFuelType(fuelType)) {
            throw new InvalidFuelTypeException("Invalid fuel type for this engine: " + fuelType);
        }

        this.fuelType = fuelType;
        this.fuelLevel = Math.min(Math.max(fuelLevel, 0), 100);
    }

    @Override
    public FuelType getFuelType() {
        return fuelType;
    }

    protected abstract boolean isValidFuelType(FuelType fuelType);
}
