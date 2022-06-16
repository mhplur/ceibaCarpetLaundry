package com.ceiba.cita.comando.manejador;

import com.ceiba.cita.ComandoCancelar;
import com.ceiba.cita.puerto.RepositorioCita;
import com.ceiba.cita.servicio.ServicioCancelar;
import com.ceiba.manejador.ManejadorComando;
import org.springframework.stereotype.Component;

@Component
public class ManejadorCancelar implements ManejadorComando<ComandoCancelar> {

    private final ServicioCancelar servicioCancelar;
    private final RepositorioCita repositorioCita;

    public ManejadorCancelar(RepositorioCita repositorioCita, ServicioCancelar servicioCancelar) {
        this.servicioCancelar = servicioCancelar;
        this.repositorioCita = repositorioCita;
    }

    @Override
    public void ejecutar(ComandoCancelar comandoCancelar) {
        servicioCancelar.ejecutar(repositorioCita.obtenerPorId(comandoCancelar.getIdCita()));
    }
}
