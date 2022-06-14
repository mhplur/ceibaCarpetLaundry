package com.ceiba.client.controlador;

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
@WebMvcTest(ConsultaControladorClient.class)
@ContextConfiguration(classes = ApplicationMock.class)
@DirtiesContext(classMode = DirtiesContext.ClassMode.AFTER_EACH_TEST_METHOD)
public class ConsultaControladorClientTest {

    @Autowired
    private MockMvc mockMvc;

    @Test
    void consultarTodosLosClientes() throws Exception {
        mockMvc.perform(get("/cliente/todos")
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().is2xxSuccessful())
                .andExpect(jsonPath("$[0].id", is(1)))
                .andExpect(jsonPath("$[0].identificacionPersonal", is("001")))
                .andExpect(jsonPath("$[0].nombre", is("MILTON PAREDES")))
                .andExpect(jsonPath("$[0].direccion", is("QUITO")))
                .andExpect(jsonPath("$[1].id", is(2)))
                .andExpect(jsonPath("$[1].identificacionPersonal", is("002")))
                .andExpect(jsonPath("$[1].nombre", is("JUAN ANDRADE")))
                .andExpect(jsonPath("$[1].direccion", is("MEDELLIN")))
                .andExpect(jsonPath("$[2].id", is(3)))
                .andExpect(jsonPath("$[2].identificacionPersonal", is("003")))
                .andExpect(jsonPath("$[2].nombre", is("CARMEN SALINAS")))
                .andExpect(jsonPath("$[2].direccion", is("GUAYAQUIL")));
    }

    @Test
    void consultarPorIdentificacionPersonal() throws Exception {
        mockMvc.perform(get("/cliente/obtenerPorIdentificacionPersonal/001")
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.id", is(1)))
                .andExpect(jsonPath("$.identificacionPersonal", is("001")))
                .andExpect(jsonPath("$.nombre", is("MILTON PAREDES")))
                .andExpect(jsonPath("$.direccion", is("QUITO")));
    }

    @Test
    void consultarPorId() throws Exception {
        mockMvc.perform(get("/cliente/obtenerPorId/1")
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.id", is(1)))
                .andExpect(jsonPath("$.identificacionPersonal", is("001")))
                .andExpect(jsonPath("$.nombre", is("MILTON PAREDES")))
                .andExpect(jsonPath("$.direccion", is("QUITO")));
    }
}
