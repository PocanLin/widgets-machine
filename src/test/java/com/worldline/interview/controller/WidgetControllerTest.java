package com.worldline.interview.controller;

import com.worldline.interview.service.WidgetMachine;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;

import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(WidgetController.class)
public class WidgetControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private WidgetMachine widgetMachine;

    @Test
    public void testProduceWidgetsWithInternalEngine() throws Exception {
        when(widgetMachine.produceWidgets(anyInt())).thenReturn(1800); // 18.00 pounds

        mockMvc.perform(get("/produce?quantity=10&engineType=internal&fuelType=petrol"))
                .andExpect(status().isOk())
                .andExpect(content().string("Cost to produce 10 widgets: £18.00"));
    }

    @Test
    public void testProduceWidgetsWithSteamEngine() throws Exception {
        when(widgetMachine.produceWidgets(anyInt())).thenReturn(2175); // 21.75 pounds

        mockMvc.perform(get("/produce?quantity=10&engineType=steam&fuelType=wood"))
                .andExpect(status().isOk())
                .andExpect(content().string("Cost to produce 10 widgets: £21.75"));
    }

    @Test
    public void testProduceWidgetsWithInvalidParameters() throws Exception {
        mockMvc.perform(get("/produce?quantity=10&engineType=invalid&fuelType=invalid"))
                .andExpect(status().isOk())
                .andExpect(content().string("Invalid fuel type"));
    }

    @Test
    public void testProduceWidgetsWithMissingParameters() throws Exception {
        mockMvc.perform(get("/produce"))
                .andExpect(status().isInternalServerError());
    }
}