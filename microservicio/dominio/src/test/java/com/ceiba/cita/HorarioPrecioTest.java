package com.ceiba.cita;

import com.ceiba.cita.modelo.entidad.HorarioPrecio;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class HorarioPrecioTest {
    @Test
    public void deberiaRetornarValoresDeNoche() {
        Assertions.assertEquals(0.0, HorarioPrecio.NOCHE.getPorcentaje());
        Assertions.assertEquals(5, HorarioPrecio.NOCHE.getCostoAdicional());
    }

    @Test
    public void deberiaRetornarValoresDeDiaDescuento() {
        Assertions.assertEquals(0.1, HorarioPrecio.DIA_DESCUENTO.getPorcentaje());
        Assertions.assertEquals(0, HorarioPrecio.DIA_DESCUENTO.getCostoAdicional());
    }

    @Test
    public void deberiaRetornarValoresDeNocheDescuento() {
        Assertions.assertEquals(0.1, HorarioPrecio.NOCHE_DESCUENTO.getPorcentaje());
        Assertions.assertEquals(3, HorarioPrecio.NOCHE_DESCUENTO.getCostoAdicional());
    }


}
