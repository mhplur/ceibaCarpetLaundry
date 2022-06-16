package com.ceiba.tarifa.controlador;


import com.ceiba.ApplicationMock;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.http.MediaType;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;

import static org.hamcrest.core.Is.is;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@ExtendWith(SpringExtension.class)
@WebMvcTest(ConsultaControladorTarifa.class)
@ContextConfiguration(classes = ApplicationMock.class)
@DirtiesContext(classMode = DirtiesContext.ClassMode.AFTER_EACH_TEST_METHOD)
public class ConsultaControladorTarifaTest {

    @Autowired
    private MockMvc mockMvc;

    @Test
    void consultarPorCodigo() throws Exception {
        mockMvc.perform(get("/tarifa/obtenerPorCodigo/W001")
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.id", is(1)))
                .andExpect(jsonPath("$.nombre", is("VAPOR O AGUA CALIENTE")))
                .andExpect(jsonPath("$.codigo", is("W001")))
                .andExpect(jsonPath("$.tiempoHoraSecado", is(24)))
                .andExpect(jsonPath("$.costoPorMetroCuadrado", is(15)))
                .andExpect(jsonPath("$.limpiezaProfunda", is(1)));
    }

    @Test
    void consultarPorId() throws Exception {
        mockMvc.perform(get("/tarifa/obtenerPorId/1")
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.id", is(1)))
                .andExpect(jsonPath("$.nombre", is("VAPOR O AGUA CALIENTE")))
                .andExpect(jsonPath("$.codigo", is("W001")))
                .andExpect(jsonPath("$.tiempoHoraSecado", is(24)))
                .andExpect(jsonPath("$.costoPorMetroCuadrado", is(15)))
                .andExpect(jsonPath("$.limpiezaProfunda", is(1)));
    }
}
