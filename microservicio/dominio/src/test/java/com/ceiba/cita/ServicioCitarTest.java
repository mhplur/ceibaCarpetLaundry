package com.ceiba.cita;

import com.ceiba.cita.modelo.entidad.Cita;
import com.ceiba.cita.puerto.repositorio.RepositorioCita;
import com.ceiba.cita.servicio.ServicioCitar;
import com.ceiba.client.entidad.Client;
import com.ceiba.tarifa.entidad.Tarifa;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.ArgumentCaptor;
import org.mockito.Mockito;

import java.time.LocalDate;
import java.time.LocalTime;

public class ServicioCitarTest {

    @Test
    void deberiaCitarYAlmacenarunaCita() {
        Client client = new Client(1l, "001", "MILTON PAREDES", "QUITO");
        Tarifa tarifa = new Tarifa(1l, "VAPOR O AGUA CALIENTE", "W001", 24, 15, 1);
        var solicitarCita = new SolicitarCitaTestDataBuilder()
                .conClient(client)
                .conTarifa(tarifa)
                .conFechaCita(LocalDate.parse("2022-09-17"))
                .conHoraCita(LocalTime.parse("08:00:00"))
                .conHorario("DIA")
                .conMetrosCuadrado(2)
                .build();

        var repositorioCita = Mockito.mock(RepositorioCita.class);
        Mockito.when(repositorioCita.guardar(Mockito.any())).thenReturn(1l);

        var servicioCitar = new ServicioCitar(repositorioCita);
        var idCitaCreada = servicioCitar.ejecutar(solicitarCita);

        ArgumentCaptor<Cita> captorCita = ArgumentCaptor.forClass(Cita.class);
        Mockito.verify(repositorioCita, Mockito.times(1)).guardar(captorCita.capture());
        Assertions.assertEquals(client, captorCita.getValue().getClient());
        Assertions.assertEquals(tarifa, captorCita.getValue().getTarifa());
        Assertions.assertEquals(30, captorCita.getValue().getCosto());
        Assertions.assertEquals(LocalDate.parse("2022-09-17"), captorCita.getValue().getFechaCita());
        Assertions.assertEquals(LocalTime.parse("08:00:00"), captorCita.getValue().getHoraCita());
        Assertions.assertEquals("DIA", captorCita.getValue().getHorario());
        Assertions.assertEquals(2, captorCita.getValue().getMetrosCuadrados());
        Assertions.assertEquals(1, captorCita.getValue().getEstado());
        Assertions.assertEquals(1L, idCitaCreada);
    }
}
