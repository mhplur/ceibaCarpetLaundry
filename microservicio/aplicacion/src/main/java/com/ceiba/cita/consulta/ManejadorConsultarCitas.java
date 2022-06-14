package com.ceiba.cita.consulta;

import com.ceiba.cita.modelo.entidad.Cita;
import com.ceiba.cita.puerto.RepositorioCita;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class ManejadorConsultarCitas {

    private final RepositorioCita repositorioCita;

    public ManejadorConsultarCitas(RepositorioCita repositorioCita) {
        this.repositorioCita = repositorioCita;
    }

    public List<Cita> ejecutar() {
        return repositorioCita.obtenerTodasActivas();
    }
}
