package com.ceiba.cita.controlador;

import com.ceiba.ApplicationMock;
import com.ceiba.cita.puerto.RepositorioCita;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.http.MediaType;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;

import java.time.LocalDate;
import java.time.LocalTime;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@ExtendWith(SpringExtension.class)
@WebMvcTest(ComandoControladorCita.class)
@ContextConfiguration(classes = ApplicationMock.class)
@DirtiesContext(classMode = DirtiesContext.ClassMode.AFTER_EACH_TEST_METHOD)
public class ComandoControladorCitaTest {

    @Autowired
    private ObjectMapper objectMapper;

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private RepositorioCita repositorioCita;

    @Test
    void crearCitaExitosa() throws Exception {
        var comandoCitarTestDataBuilder = new ComandoCitarTestDataBuilder().crearPorDefecto().build();

        var resultado = mockMvc.perform(post("/cita")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(comandoCitarTestDataBuilder)))
                .andExpect(status().is2xxSuccessful()).andReturn();

        String jsonResult = resultado.getResponse().getContentAsString();
        var respuesta = objectMapper.readValue(jsonResult, RespuestaCitar.class);

        var citaGuardada = repositorioCita.obtenerPorId(respuesta.getValor());

        Assertions.assertEquals(LocalDate.parse("2022-06-14"), citaGuardada.getFechaCita());
        Assertions.assertEquals(LocalTime.parse("08:03:00"), citaGuardada.getHoraCita());
        Assertions.assertEquals("DIA", citaGuardada.getHorario());
        Assertions.assertEquals(15.0, citaGuardada.getCosto());
    }




    @Test
    void cancelarCita() throws Exception {
        mockMvc.perform(post("/cita/cancelar/1")
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk());

        var citaCancelada = repositorioCita.obtenerPorId(1l);
        Assertions.assertEquals(0, citaCancelada.getEstado());
    }
}
