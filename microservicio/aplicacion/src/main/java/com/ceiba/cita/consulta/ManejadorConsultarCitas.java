package com.ceiba.cita.consulta;

import com.ceiba.cita.modelo.dto.CitaResumenDto;
import com.ceiba.cita.modelo.entidad.Cita;
import com.ceiba.cita.puerto.dao.DaoCita;
import com.ceiba.cita.puerto.repositorio.RepositorioCita;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class ManejadorConsultarCitas {

    private final DaoCita daoCita;

    public ManejadorConsultarCitas(DaoCita daoCita) {
        this.daoCita = daoCita;
    }

    public List<CitaResumenDto> ejecutar() {
        return daoCita.obtenerCitaResumenActivas();
    }
}
