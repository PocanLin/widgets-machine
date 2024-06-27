package com.worldline.interview.model;

public interface Engine {
    void start();
    void stop();
    boolean isRunning();
    void fill(FuelType fuelType, int fuelLevel);
    FuelType getFuelType();
    int getBatchSize();
    int getCostPerBatch();
}
