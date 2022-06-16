package com.ceiba.cita;

import com.ceiba.cita.servicio.UtilTime;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.time.LocalTime;

public class UtilTimeTest {

    @Test
    void deberiaSerVerdadero() {
        boolean valorCondicion = UtilTime.checkAllRangeTime(LocalTime.parse("08:00:00"));

        Assertions.assertEquals(valorCondicion, true);
    }
}
