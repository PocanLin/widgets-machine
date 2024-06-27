package com.worldline.interview.model;

import com.worldline.interview.exception.InsufficientFuelException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class InternalCombustionEngineTest {

    private InternalCombustionEngine engine;

    @BeforeEach
    void setUp() {
        engine = new InternalCombustionEngine(FuelType.PETROL);
    }

    @Test
    void testStartEngine() {
        engine.fill(FuelType.PETROL, 50);
        engine.start();
        assertTrue(engine.isRunning());
    }

    @Test
    void testStartEngineWithNoFuel() {
        assertThrows(InsufficientFuelException.class, () -> engine.start());
    }

    @Test
    void testStopEngine() {
        engine.fill(FuelType.PETROL, 50);
        engine.start();
        engine.stop();
        assertFalse(engine.isRunning());
    }

    @Test
    void testGetBatchSize() {
        assertEquals(8, engine.getBatchSize());
    }

    @Test
    void testGetCostPerBatch() {
        assertEquals(9, engine.getCostPerBatch() / 100.0);
    }
}
