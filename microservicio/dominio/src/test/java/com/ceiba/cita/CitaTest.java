package com.ceiba.cita;

import com.ceiba.BasePrueba;
import com.ceiba.cita.modelo.entidad.Cita;
import com.ceiba.client.entidad.Client;
import com.ceiba.dominio.excepcion.ExcepcionValorInvalido;
import com.ceiba.dominio.excepcion.ExcepcionValorObligatorio;
import com.ceiba.tarifa.entidad.Tarifa;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.time.LocalTime;

public class CitaTest {

    @Test
    void deberiaCrearCitaExistosa() {
        Client client = new Client(1l, "001", "MILTON PAREDES", "QUITO");
        Tarifa tarifa = new Tarifa(1l, "VAPOR O AGUA CALIENTE", "W001", 24, 15, 1);
        var cita = new CitaTestDataBuilder()
                .conId(1l)
                .conClient(client)
                .conTarifa(tarifa)
                .conFechaCita(LocalDate.parse("2022-09-17"))
                .conHoraCita(LocalTime.parse("08:00:00"))
                .conHorario("DIA")
                .conEstado(1)
                .conCosto(15.0)
                .conMetrosCuadrados(1).reconstruir();

        Assertions.assertEquals(1l, cita.getId());
        deberiaCrearTarifaExitosa(tarifa, cita);
        deberiaCrearClienteExitosa(client, cita);
        Assertions.assertEquals(LocalDate.parse("2022-09-17"), cita.getFechaCita());
        Assertions.assertEquals(LocalTime.parse("08:00:00"), cita.getHoraCita());
        Assertions.assertEquals("DIA", cita.getHorario());
        Assertions.assertEquals(1, cita.getEstado());
        Assertions.assertEquals(15.0, cita.getCosto());
        Assertions.assertEquals(1, cita.getMetrosCuadrados());

    }

    private void deberiaCrearClienteExitosa(Client client, Cita cita) {
        Assertions.assertEquals(client.getId(), cita.getClient().getId());
        Assertions.assertEquals(client.getNombre(), cita.getClient().getNombre());
        Assertions.assertEquals(client.getIdentificacionPersonal(), cita.getClient().getIdentificacionPersonal());
        Assertions.assertEquals(client.getDireccion(), cita.getClient().getDireccion());
    }

    private void deberiaCrearTarifaExitosa(Tarifa tarifa, Cita cita) {
        Assertions.assertEquals(tarifa.getId(), cita.getTarifa().getId());
        Assertions.assertEquals(tarifa.getNombre(), cita.getTarifa().getNombre());
        Assertions.assertEquals(tarifa.getCodigo(), cita.getTarifa().getCodigo());
        Assertions.assertEquals(tarifa.getTiempoHoraSecado(), cita.getTarifa().getTiempoHoraSecado());
        Assertions.assertEquals(tarifa.getCostoPorMetroCuadrado(), cita.getTarifa().getCostoPorMetroCuadrado());
        Assertions.assertEquals(tarifa.getLimpiezaProfunda(), cita.getTarifa().getLimpiezaProfunda());
    }

    @Test
    void reconstruirCitaSinIdDeberiaLanzarError() {
        BasePrueba.assertThrows(() -> new CitaTestDataBuilder()
                        .conClient(new Client(1l, "001", "MILTON PAREDES", "QUITO"))
                        .conTarifa(new Tarifa(1l, "VAPOR O AGUA CALIENTE", "W001", 24, 15, 1))
                        .conFechaCita(LocalDate.parse("2022-09-17"))
                        .conHoraCita(LocalTime.parse("08:00:00"))
                        .conEstado(1)
                        .conCosto(15.0)
                        .reconstruir(),
                ExcepcionValorObligatorio.class,
                "Id de la cita es requerido");
    }

    @Test
    void reconstruirCitaSinClienteDeberiaLanzarError() {
        BasePrueba.assertThrows(() -> new CitaTestDataBuilder()
                        .conId(1l)
                        .conTarifa(new Tarifa(1l, "VAPOR O AGUA CALIENTE", "W001", 24, 15, 1))
                        .conFechaCita(LocalDate.parse("2022-09-17"))
                        .conHoraCita(LocalTime.parse("08:00:00"))
                        .conEstado(1)
                        .conCosto(15.0)
                        .reconstruir(),
                ExcepcionValorObligatorio.class,
                "Cliente de la cita es requerido");
    }

    @Test
    void reconstruirCitaSinTarifaDeberiaLanzarError() {
        BasePrueba.assertThrows(() -> new CitaTestDataBuilder()
                        .conId(1l)
                        .conClient(new Client(1l, "001", "MILTON PAREDES", "QUITO"))
                        .conFechaCita(LocalDate.parse("2022-09-17"))
                        .conHoraCita(LocalTime.parse("08:00:00"))
                        .conEstado(1)
                        .conCosto(15.0)
                        .reconstruir(),
                ExcepcionValorObligatorio.class,
                "Tarifa de la cita es requerido");
    }

    @Test
    void reconstruirCitaConFechaCitaMenorDiaActualDeberiaLanzarError() {
        BasePrueba.assertThrows(() -> new CitaTestDataBuilder()
                        .conId(1l)
                        .conClient(new Client(1l, "001", "MILTON PAREDES", "QUITO"))
                        .conTarifa(new Tarifa(1l, "VAPOR O AGUA CALIENTE", "W001", 24, 15, 1))
                        .conFechaCita(LocalDate.parse("2022-06-24"))
                        .conHoraCita(LocalTime.parse("08:00:00"))
                        .conEstado(1)
                        .conCosto(15.0)
                        .reconstruir(),
                ExcepcionValorInvalido.class,
                "Fecha de Cita no puede ser anterior a la fecha actual");
    }

    @Test
    void reconstruirCitaSinFechaCitaDeberiaLanzarError() {
        BasePrueba.assertThrows(() -> new CitaTestDataBuilder()
                        .conId(1l)
                        .conClient(new Client(1l, "001", "MILTON PAREDES", "QUITO"))
                        .conTarifa(new Tarifa(1l, "VAPOR O AGUA CALIENTE", "W001", 24, 15, 1))
                        .conHoraCita(LocalTime.parse("08:00:00"))
                        .conEstado(1)
                        .conCosto(15.0)
                        .reconstruir(),
                ExcepcionValorObligatorio.class,
                "Fecha de Cita es requerida");
    }

    @Test
    void reconstruirCitaSinHoraCitaDeberiaLanzarError() {
        BasePrueba.assertThrows(() -> new CitaTestDataBuilder()
                        .conId(1l)
                        .conClient(new Client(1l, "001", "MILTON PAREDES", "QUITO"))
                        .conTarifa(new Tarifa(1l, "VAPOR O AGUA CALIENTE", "W001", 24, 15, 1))
                        .conFechaCita(LocalDate.parse("2022-09-17"))
                        .conEstado(1)
                        .conCosto(15.0)
                        .reconstruir(),
                ExcepcionValorObligatorio.class,
                "Hora de la cita es requerido");
    }

    @Test
    void reconstruirCitaSinHorarioDeberiaLanzarError() {
        BasePrueba.assertThrows(() -> new CitaTestDataBuilder()
                        .conId(1l)
                        .conClient(new Client(1l, "001", "MILTON PAREDES", "QUITO"))
                        .conTarifa(new Tarifa(1l, "VAPOR O AGUA CALIENTE", "W001", 24, 15, 1))
                        .conFechaCita(LocalDate.parse("2022-09-17"))
                        .conHoraCita(LocalTime.parse("08:00:00"))
                        .conCosto(15.0)
                        .conEstado(1)
                        .reconstruir(),
                ExcepcionValorObligatorio.class,
                "Horario de la cita es requerido");
    }


    @Test
    void reconstruirCitaSinEstadoDeberiaLanzarError() {
        BasePrueba.assertThrows(() -> new CitaTestDataBuilder()
                        .conId(1l)
                        .conClient(new Client(1l, "001", "MILTON PAREDES", "QUITO"))
                        .conTarifa(new Tarifa(1l, "VAPOR O AGUA CALIENTE", "W001", 24, 15, 1))
                        .conFechaCita(LocalDate.parse("2022-09-17"))
                        .conHoraCita(LocalTime.parse("08:00:00"))
                        .conHorario("DIA")
                        .conCosto(15.0)
                        .reconstruir(),
                ExcepcionValorObligatorio.class,
                "Estado de la cita es requerido");
    }

    @Test
    void reconstruirCitaSinCostoDeberiaLanzarError() {
        BasePrueba.assertThrows(() -> new CitaTestDataBuilder()
                        .conId(1l)
                        .conClient(new Client(1l, "001", "MILTON PAREDES", "QUITO"))
                        .conTarifa(new Tarifa(1l, "VAPOR O AGUA CALIENTE", "W001", 24, 15, 1))
                        .conFechaCita(LocalDate.parse("2022-09-17"))
                        .conHoraCita(LocalTime.parse("08:00:00"))
                        .conHorario("DIA")
                        .conEstado(1)
                        .reconstruir(),
                ExcepcionValorObligatorio.class,
                "Costo de la cita es requerido");
    }

    @Test
    void reconstruirCitaSinMetrosCuadradosDeberiaLanzarError() {
        BasePrueba.assertThrows(() -> new CitaTestDataBuilder()
                        .conId(1l)
                        .conClient(new Client(1l, "001", "MILTON PAREDES", "QUITO"))
                        .conTarifa(new Tarifa(1l, "VAPOR O AGUA CALIENTE", "W001", 24, 15, 1))
                        .conFechaCita(LocalDate.parse("2022-09-17"))
                        .conHoraCita(LocalTime.parse("08:00:00"))
                        .conHorario("DIA")
                        .conEstado(1)
                        .conCosto(15.0)
                        .reconstruir(),
                ExcepcionValorObligatorio.class,
                "Numero de metros cuadrados es requerido");
    }

    @Test
    void deberiaCancelarCitaExitosamente() {
        Client client = new Client(1l, "001", "MILTON PAREDES", "QUITO");
        Tarifa tarifa = new Tarifa(1l, "VAPOR O AGUA CALIENTE", "W001", 24, 15, 1);
        var cita = new CitaTestDataBuilder()
                .conId(1l)
                .conClient(client)
                .conTarifa(tarifa)
                .conFechaCita(LocalDate.parse("2022-09-17"))
                .conHoraCita(LocalTime.parse("08:00:00"))
                .conHorario("DIA")
                .conEstado(1)
                .conCosto(15.0)
                .conMetrosCuadrados(1).reconstruir();

        cita.cancelar();
        Assertions.assertEquals(0, cita.getEstado());
    }
}