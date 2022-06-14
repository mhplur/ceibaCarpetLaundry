package com.ceiba.tarifa;

import com.ceiba.BasePrueba;
import com.ceiba.dominio.excepcion.ExcepcionValorObligatorio;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class TarifaTest {

    @Test
    void deberiaCrearTarifaExitosa() {
        var tarifa = new TarifaTestDataBuilder()
                .conId(1l)
                .conNombre("VAPOR O AGUA CALIENTE")
                .conLimpiezaProfunda(1)
                .conCostoPorMetroCuadrado(15)
                .conCodigo("W001")
                .conTiempoHoraSecado(24).reconstruir();

        Assertions.assertEquals(1l, tarifa.getId());
        Assertions.assertEquals("VAPOR O AGUA CALIENTE", tarifa.getNombre());
        Assertions.assertEquals(1, tarifa.getLimpiezaProfunda());
        Assertions.assertEquals(15, tarifa.getCostoPorMetroCuadrado());
        Assertions.assertEquals(24, tarifa.getTiempoHoraSecado());
    }

    @Test
    void reconstruirTarifaSinIdDeberiaLanzarError() {
        BasePrueba.assertThrows(() -> new TarifaTestDataBuilder()
                        .conNombre("VAPOR O AGUA CALIENTE")
                        .reconstruir(),
                ExcepcionValorObligatorio.class,
                "Id de la tarifa es requerido");
    }

    @Test
    void reconstruirTarifaSinNombreDeberiaLanzarError() {
        BasePrueba.assertThrows(() -> new TarifaTestDataBuilder()
                        .conId(1l)
                        .reconstruir(),
                ExcepcionValorObligatorio.class,
                "Nombre de la tarifa es requerido");
    }

    @Test
    void reconstruirTarifaSinCodigoDeberiaLanzarError() {
        BasePrueba.assertThrows(() -> new TarifaTestDataBuilder()
                        .conId(1l)
                        .conNombre("VAPOR O AGUA CALIENTE")
                        .reconstruir(),
                ExcepcionValorObligatorio.class,
                "Codigo de la tarifa es requerido");
    }

    @Test
    void reconstruirTarifaSinTiempoHoraSecadoDeberiaLanzarError() {
        BasePrueba.assertThrows(() -> new TarifaTestDataBuilder()
                        .conId(1l)
                        .conNombre("VAPOR O AGUA CALIENTE")
                        .conCodigo("W001")
                        .reconstruir(),
                ExcepcionValorObligatorio.class,
                "Tiempo hora de secado de la tarifa es requerido");
    }

    @Test
    void reconstruirCostoMetroCuadradoHoraSecadoDeberiaLanzarError() {
        BasePrueba.assertThrows(() -> new TarifaTestDataBuilder()
                        .conId(1l)
                        .conNombre("VAPOR O AGUA CALIENTE")
                        .conCodigo("W001")
                        .conTiempoHoraSecado(24)
                        .reconstruir(),
                ExcepcionValorObligatorio.class,
                "Costo por metro cuadrado de la tarifa es requerido");
    }

    @Test
    void reconstruirLimpiezaProfundaSecadoDeberiaLanzarError() {
        BasePrueba.assertThrows(() -> new TarifaTestDataBuilder()
                        .conId(1l)
                        .conNombre("VAPOR O AGUA CALIENTE")
                        .conCodigo("W001")
                        .conTiempoHoraSecado(24)
                        .conCostoPorMetroCuadrado(15)
                        .reconstruir(),
                ExcepcionValorObligatorio.class,
                "Limpieza profunda de la tarifa es requerido");
    }


}
