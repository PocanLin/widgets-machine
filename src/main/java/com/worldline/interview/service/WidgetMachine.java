package com.worldline.interview.service;

import com.worldline.interview.model.Engine;
import com.worldline.interview.model.FuelType;
import com.worldline.interview.model.InternalCombustionEngine;
import org.springframework.stereotype.Component;

@Component
public class WidgetMachine {
    private Engine engine;

    public WidgetMachine() {
        this.engine = new InternalCombustionEngine(FuelType.PETROL);
    }

    public void setEngine(Engine engine) {
        this.engine = engine;
    }

    public int produceWidgets(int quantity) {
        engine.start();
        int cost = 0;

        if (engine.isRunning()) {
            cost = produce(quantity);
        }

        engine.stop();

        return cost;
    }

    private int produce(int quantity) {
        int batch = 0;
        int batchCount = 0;
        int costPerBatch = engine.getCostPerBatch();
        int batchSize = engine.getBatchSize();

        while (batch < quantity) {
            batch += batchSize;
            batchCount++;
        }

        return batchCount * costPerBatch;
    }
}