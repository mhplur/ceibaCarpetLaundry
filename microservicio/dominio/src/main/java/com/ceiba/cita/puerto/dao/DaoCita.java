package com.ceiba.cita.puerto.dao;

import com.ceiba.cita.modelo.dto.CitaResumenDto;

import java.util.List;

public interface DaoCita {

    List<CitaResumenDto> obtenerCitaResumenActivas();
}
