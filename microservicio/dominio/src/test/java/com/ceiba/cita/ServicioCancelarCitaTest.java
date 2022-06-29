package com.ceiba.cita;

import com.ceiba.cita.modelo.entidad.Cita;
import com.ceiba.cita.puerto.repositorio.RepositorioCita;
import com.ceiba.cita.servicio.ServicioCancelar;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.ArgumentCaptor;
import org.mockito.Mockito;

public class ServicioCancelarCitaTest {

    @Test
    void deberiaCancelarExitosamente() {
        var repositorioCita = Mockito.mock(RepositorioCita.class);
        Mockito.when(repositorioCita.guardar(Mockito.any())).thenReturn(1l);

        var cita = new CitaTestDataBuilder().conCitaPorDefecto().reconstruir();
        var servicioCancelar = new ServicioCancelar(repositorioCita);

        servicioCancelar.ejecutar(cita);

        ArgumentCaptor<Cita> captorCita = ArgumentCaptor.forClass(Cita.class);
        Mockito.verify(repositorioCita, Mockito.times(1)).actualizarEstado(captorCita.capture());

        Assertions.assertEquals(0, captorCita.getValue().getEstado());

    }
}
