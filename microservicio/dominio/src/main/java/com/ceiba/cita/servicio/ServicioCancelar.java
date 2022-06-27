package com.ceiba.cita.servicio;

import com.ceiba.cita.modelo.entidad.Cita;
import com.ceiba.cita.puerto.repositorio.RepositorioCita;
import com.ceiba.dominio.ValidadorArgumento;

public class ServicioCancelar {

    private final RepositorioCita repositorioCita;

    public ServicioCancelar(RepositorioCita repositorioCita) {
        this.repositorioCita = repositorioCita;
    }

    public void ejecutar(Cita cita) {
        ValidadorArgumento.validarObligatorio(cita, "No es posible cancelar la cita");
        cita.cancelar();
        repositorioCita.actualizarEstado(cita);
    }
}
