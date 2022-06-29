package com.ceiba.cita;

import com.ceiba.cita.servicio.UtilTime;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.time.LocalTime;

public class UtilTimeTest {

    @Test
    void deberiaLanzarExcepcionPorParametroNulo() {
        Assertions.assertThrows(IllegalArgumentException.class, () -> UtilTime.checkAllRangeTime(null));
    }

    @Test
    void deberiaSerVerdaderoPorEstarDentroDelRango() {
        boolean valorCondicion = UtilTime.checkAllRangeTime(LocalTime.parse("08:00:00"));
        Assertions.assertEquals(valorCondicion, true);
    }

    @Test
    void deberiaSerFalsoPorEstarFueraDelRango(){
        boolean valorCondicion = UtilTime.checkAllRangeTime(LocalTime.parse("05:00:00"));
        Assertions.assertEquals(valorCondicion, false);
    }
}
