package com.ceiba.cita;

import com.ceiba.cita.modelo.dto.CitaResumenDto;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.time.LocalTime;

public class CitaResumenDtoTest {

    @Test
    void deberiaConstruirSatisfactoriamente(){
        CitaResumenDto citaResumenDto = new CitaResumenDto(1L, "MILTON PAREDES"
        , "VAPOR O AGUA CALIENTE", LocalDate.parse("2022-09-17")
        , LocalTime.parse("08:00:00"), "DIA", 1, 15.0, 1);
        Assertions.assertEquals(1L, citaResumenDto.getId());
        Assertions.assertEquals("MILTON PAREDES", citaResumenDto.getClienteNombre());
        Assertions.assertEquals("VAPOR O AGUA CALIENTE", citaResumenDto.getTarifaNombre());
        Assertions.assertEquals(LocalDate.parse("2022-09-17"), citaResumenDto.getFechaCita());
        Assertions.assertEquals(LocalTime.parse("08:00:00"), citaResumenDto.getHoraCita());
        Assertions.assertEquals("DIA", citaResumenDto.getHorario());
        Assertions.assertEquals(1, citaResumenDto.getEstado());
        Assertions.assertEquals(15.0, citaResumenDto.getCosto());
        Assertions.assertEquals(1, citaResumenDto.getEstado());
    }
}
