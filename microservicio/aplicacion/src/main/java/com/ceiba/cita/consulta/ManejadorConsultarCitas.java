package com.ceiba.cita.consulta;

import com.ceiba.cita.modelo.dto.CitaResumenDto;
import com.ceiba.cita.puerto.dao.DaoCita;
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
