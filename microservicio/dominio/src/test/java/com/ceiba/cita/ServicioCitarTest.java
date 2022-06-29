package com.ceiba.cita;

import com.ceiba.cita.modelo.entidad.Cita;
import com.ceiba.cita.puerto.repositorio.RepositorioCita;
import com.ceiba.cita.servicio.ServicioCitar;
import com.ceiba.cita.servicio.UtilTime;
import com.ceiba.client.entidad.Client;
import com.ceiba.dominio.excepcion.ExcepcionValorInvalido;
import com.ceiba.tarifa.entidad.Tarifa;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.ArgumentCaptor;
import org.mockito.Mockito;

import java.time.LocalDate;
import java.time.LocalTime;

public class ServicioCitarTest {

    @Test
    void deberiaLanzarExcepcionPorParametroNulo() {
        Client client = new Client(1l, "001", "MILTON PAREDES", "QUITO");
        Tarifa tarifa = new Tarifa(1l, "VAPOR O AGUA CALIENTE", "W001", 24, 15, 1);
        var solicitarCita = new SolicitarCitaTestDataBuilder()
                .conClient(client)
                .conTarifa(tarifa)
                .conFechaCita(LocalDate.parse("2022-09-17"))
                .conHoraCita(LocalTime.parse("05:00:00"))
                .conHorario("DIA")
                .conMetrosCuadrado(2)
                .build();
        var repositorioCita = Mockito.mock(RepositorioCita.class);
        var servicioCitar = new ServicioCitar(repositorioCita);
        Assertions.assertThrows(ExcepcionValorInvalido.class, () -> servicioCitar.ejecutar(solicitarCita));
    }
}
