package com.ceiba.cita.adaptador.dao;

import com.ceiba.cita.modelo.dto.CitaResumenDto;
import com.ceiba.cita.puerto.dao.DaoCita;
import com.ceiba.infraestructura.jdbc.CustomNamedParameterJdbcTemplate;
import com.ceiba.infraestructura.jdbc.sqlstatement.SqlStatement;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class DaoCitaH2 implements DaoCita {

    private final CustomNamedParameterJdbcTemplate customNamedParameterJdbcTemplate;
    private final MapeoCitaResumen mapeoCitaResumen;

    @SqlStatement(namespace = "cita", value = "obtenertodasactivas")
    private static String sqlObtenerTodasActivas;

    public DaoCitaH2(CustomNamedParameterJdbcTemplate customNamedParameterJdbcTemplate, MapeoCitaResumen mapeoCitaResumen) {
        this.customNamedParameterJdbcTemplate = customNamedParameterJdbcTemplate;
        this.mapeoCitaResumen = mapeoCitaResumen;
    }

    @Override
    public List<CitaResumenDto> obtenerCitaResumenActivas() {
        return this.customNamedParameterJdbcTemplate.getNamedParameterJdbcTemplate()
                .query(sqlObtenerTodasActivas, mapeoCitaResumen);
    }
}
