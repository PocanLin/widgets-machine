package com.worldline.interview.service;

import com.worldline.interview.model.FuelType;
import com.worldline.interview.model.InternalCombustionEngine;
import com.worldline.interview.model.SteamEngine;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class WidgetMachineTest {

    private WidgetMachine widgetMachine;

    @BeforeEach
    void setUp() {
        widgetMachine = new WidgetMachine();
    }

    @Test
    void testProduceWidgetsWithInternalCombustionEngine() {
        InternalCombustionEngine engine = new InternalCombustionEngine(FuelType.PETROL);
        engine.fill(FuelType.PETROL, 100);
        widgetMachine.setEngine(engine);

        int cost = widgetMachine.produceWidgets(10);
        assertEquals(18, cost / 100.0); // 2 batches * £9 per batch
    }

    @Test
    void testProduceWidgetsWithSteamEngine() {
        SteamEngine engine = new SteamEngine(FuelType.WOOD);
        engine.fill(FuelType.WOOD, 100);
        widgetMachine.setEngine(engine);

        int cost = widgetMachine.produceWidgets(10);
        assertEquals(21.75, cost / 100.0); // 5 batches * £4.35 per batch
    }
}
