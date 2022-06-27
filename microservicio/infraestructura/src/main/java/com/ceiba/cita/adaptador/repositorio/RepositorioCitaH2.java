package com.ceiba.cita.adaptador.repositorio;

import com.ceiba.cita.modelo.dto.CitaResumenDto;
import com.ceiba.cita.modelo.entidad.Cita;
import com.ceiba.cita.puerto.repositorio.RepositorioCita;
import com.ceiba.infraestructura.jdbc.CustomNamedParameterJdbcTemplate;
import com.ceiba.infraestructura.jdbc.EjecucionBaseDeDatos;
import com.ceiba.infraestructura.jdbc.sqlstatement.SqlStatement;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class RepositorioCitaH2 implements RepositorioCita {

    private final CustomNamedParameterJdbcTemplate customNamedParameterJdbcTemplate;

    private final MapeoCita mapeoCita;

    @SqlStatement(namespace = "cita", value = "crear")
    private static String sqlCrear;

    @SqlStatement(namespace = "cita", value = "actualizarestado")
    private static String sqlActualizarEstado;

    @SqlStatement(namespace = "cita", value = "obtenertodasactivas")
    private static String sqlObtenerTodasActivas;

    @SqlStatement(namespace = "cita", value = "obtenerporid")
    private static String sqlObtenerPorId;


    public RepositorioCitaH2(CustomNamedParameterJdbcTemplate customNamedParameterJdbcTemplate,
                             MapeoCita mapeoCita) {
        this.customNamedParameterJdbcTemplate = customNamedParameterJdbcTemplate;
        this.mapeoCita = mapeoCita;
    }


    @Override
    public List<Cita> obtenerTodasActivas() {
        return this.customNamedParameterJdbcTemplate.getNamedParameterJdbcTemplate()
                .query(sqlObtenerTodasActivas, mapeoCita);
    }

    @Override
    public Long guardar(Cita cita) {
        MapSqlParameterSource paramSource = new MapSqlParameterSource();
        paramSource.addValue("id_client", cita.getClient().getId());
        paramSource.addValue("id_tarifa", cita.getTarifa().getId());
        paramSource.addValue("fecha_cita", cita.getFechaCita());
        paramSource.addValue("hora_cita", cita.getHoraCita());
        paramSource.addValue("horario", cita.getHorario());
        paramSource.addValue("estado", cita.getEstado());
        paramSource.addValue("costo", cita.getCosto());
        paramSource.addValue("metros_cuadrados", cita.getMetrosCuadrados());
        return this.customNamedParameterJdbcTemplate.crear(paramSource, sqlCrear);
    }


    @Override
    public Cita obtenerPorId(Long id) {
        MapSqlParameterSource paramSource = new MapSqlParameterSource();
        paramSource.addValue("id", id);

        return EjecucionBaseDeDatos.obtenerUnObjetoONull(() -> this.customNamedParameterJdbcTemplate.getNamedParameterJdbcTemplate()
                .queryForObject(sqlObtenerPorId, paramSource, mapeoCita));
    }

    @Override
    public void actualizarEstado(Cita cita) {
        MapSqlParameterSource paramSource = new MapSqlParameterSource();
        paramSource.addValue("id", cita.getId());
        paramSource.addValue("estado", cita.getEstado());
        this.customNamedParameterJdbcTemplate.getNamedParameterJdbcTemplate().update(sqlActualizarEstado, paramSource);
    }
}
