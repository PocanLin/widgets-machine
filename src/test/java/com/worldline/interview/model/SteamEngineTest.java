package com.worldline.interview.model;

import com.worldline.interview.exception.InvalidFuelTypeException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class SteamEngineTest {

    private SteamEngine engine;

    @BeforeEach
    void setUp() {
        engine = new SteamEngine(FuelType.WOOD);
    }

    @Test
    void testStartEngine() {
        engine.fill(FuelType.WOOD, 50);
        engine.start();
        assertTrue(engine.isRunning());
    }

    @Test
    void testStartEngineWithInvalidFuel() {
        assertThrows(InvalidFuelTypeException.class, () -> engine.fill(FuelType.PETROL, 50));
    }

    @Test
    void testStopEngine() {
        engine.fill(FuelType.COAL, 50);
        engine.start();
        engine.stop();
        assertFalse(engine.isRunning());
    }

    @Test
    void testGetBatchSize() {
        assertEquals(2, engine.getBatchSize());
    }

    @Test
    void testGetCostPerBatchWood() {
        engine.fill(FuelType.WOOD, 50);
        assertEquals(4.35, engine.getCostPerBatch() / 100.0);
    }

    @Test
    void testGetCostPerBatchCoal() {
        engine.fill(FuelType.COAL, 50);
        assertEquals(5.65, engine.getCostPerBatch() / 100.0);
    }
}
