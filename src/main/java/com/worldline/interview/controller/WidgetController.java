package com.worldline.interview.controller;

import com.worldline.interview.model.Engine;
import com.worldline.interview.model.FuelType;
import com.worldline.interview.model.InternalCombustionEngine;
import com.worldline.interview.model.SteamEngine;
import com.worldline.interview.service.WidgetMachine;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class WidgetController {

    @Autowired
    private WidgetMachine widgetMachine;

    @GetMapping("/produce")
    public String produceWidgets(@RequestParam(value = "quantity") int quantity,
                                 @RequestParam(value = "engineType") String engineType,
                                 @RequestParam(value = "fuelType") String fuelType) {
        FuelType fuel;
        switch (fuelType.toLowerCase()) {
            case "petrol":
                fuel = FuelType.PETROL;
                break;
            case "diesel":
                fuel = FuelType.DIESEL;
                break;
            case "wood":
                fuel = FuelType.WOOD;
                break;
            case "coal":
                fuel = FuelType.COAL;
                break;
            default:
                return "Invalid fuel type";
        }

        Engine engine;
        switch (engineType.toLowerCase()) {
            case "internal":
                engine = new InternalCombustionEngine(fuel);
                break;
            case "steam":
                engine = new SteamEngine(fuel);
                break;
            default:
                return "Invalid engine type";
        }

        widgetMachine.setEngine(engine);
        engine.fill(engine instanceof SteamEngine ? FuelType.WOOD : FuelType.PETROL, 100);

        int cost = widgetMachine.produceWidgets(quantity);
        // Divide by 100 to convert "pence" to "pounds".
        return String.format("Cost to produce %d widgets: £%.2f", quantity, cost / 100.0);
    }
}
