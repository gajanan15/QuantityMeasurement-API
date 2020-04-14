package com.bridgelabz.quantitymeasurement.mockito;

import com.bridgelabz.quantitymeasurement.controller.QuantityMeasurementController;
import com.bridgelabz.quantitymeasurement.enumeration.Units;
import com.bridgelabz.quantitymeasurement.service.implementation.MeasurementService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;

import java.util.Arrays;

import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(QuantityMeasurementController.class)
public class QuantityMeasurementMockito {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private MeasurementService measurementService;

    @Test
    void getAllMeasurementTypes() throws Exception {
        Units[] unitsList = {Units.LENGTH, Units.TEMPERATURE, Units.WEIGHT, Units.VOLUME};
        when(measurementService.getAllUnitTypes()).thenReturn(Arrays.asList(unitsList));
        this.mockMvc.perform(get("/unit/type")).andDo(print())
                .andExpect(status().isOk()).andExpect(content().json(Arrays.toString(unitsList)));
        verify(measurementService).getAllUnitTypes();
    }
}
