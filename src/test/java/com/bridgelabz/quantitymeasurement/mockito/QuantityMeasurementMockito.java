package com.bridgelabz.quantitymeasurement.mockito;

import com.bridgelabz.quantitymeasurement.controller.QuantityMeasurementController;
import com.bridgelabz.quantitymeasurement.dto.UnitConverterDTO;
import com.bridgelabz.quantitymeasurement.enumeration.SubTypes;
import com.bridgelabz.quantitymeasurement.enumeration.Units;
import com.bridgelabz.quantitymeasurement.respone.ResponseDTO;
import com.bridgelabz.quantitymeasurement.service.implementation.MeasurementService;
import com.google.gson.Gson;
import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;

import java.util.Arrays;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(QuantityMeasurementController.class)
public class QuantityMeasurementMockito {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private MeasurementService measurementService;

    Gson gson = new Gson();

    @Test
    void getAllMeasurementTypes() throws Exception {
        Units[] unitsList = {Units.LENGTH, Units.TEMPERATURE, Units.MASS, Units.VOLUME};
        when(measurementService.getAllUnitTypes()).thenReturn(Arrays.asList(unitsList));
        this.mockMvc.perform(get("/unit/type")).andDo(print())
                .andExpect(status().isOk()).andExpect(content().json(Arrays.toString(unitsList)));

    }

    @Test
    void getAllMeasurementSubTypes() throws Exception {
        SubTypes[] subTypes = {SubTypes.INCH, SubTypes.FEET, SubTypes.CENTIMETER, SubTypes.YARD};
        when(measurementService.getAllSubTypes(Units.LENGTH)).thenReturn(Arrays.asList(subTypes));
        this.mockMvc.perform(get("/unit/type/LENGTH"))
                .andExpect(status().isOk()).andExpect(content().json(Arrays.toString(subTypes)));
        verify(measurementService).getAllSubTypes(Units.LENGTH);
    }

    @Test
    void getConvertedValue() throws Exception {
        UnitConverterDTO unitConverterDTO = new UnitConverterDTO();
        unitConverterDTO.setInitialUnit(SubTypes.FEET);
        unitConverterDTO.setOutputUnit(SubTypes.INCH);
        unitConverterDTO.setInitialValue(1.0);

        String stringConvertDTO = gson.toJson(unitConverterDTO);
        when(measurementService.convertUnit(any())).thenReturn(12.0);
        MvcResult mvcResult = this.mockMvc.perform(post("/unit/convert")
                .contentType(MediaType.APPLICATION_JSON).content(stringConvertDTO)).andReturn();
        String response = mvcResult.getResponse().getContentAsString();
        ResponseDTO responseDTO = gson.fromJson(response, ResponseDTO.class);
        double resultValue = (double) responseDTO.getData();
        Assert.assertEquals(12.0,resultValue,0.0);
    }
}
