package com.ceiba.cita.consulta;

import com.ceiba.cita.modelo.entidad.Cita;
import com.ceiba.cita.puerto.RepositorioCita;
import org.springframework.stereotype.Component;

@Component
public class ManejadorConsultaCitasPorId {

    private final RepositorioCita repositorioCita;

    public ManejadorConsultaCitasPorId(RepositorioCita repositorioCita) {
        this.repositorioCita = repositorioCita;
    }

    public Cita ejecutar(Long id){
        return repositorioCita.obtenerPorId(id);
    }
}
