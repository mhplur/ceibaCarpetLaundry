package com.ceiba.tarifa.adaptador.repositorio;

import com.ceiba.infraestructura.jdbc.CustomNamedParameterJdbcTemplate;
import com.ceiba.infraestructura.jdbc.EjecucionBaseDeDatos;
import com.ceiba.infraestructura.jdbc.sqlstatement.SqlStatement;
import com.ceiba.tarifa.entidad.Tarifa;
import com.ceiba.tarifa.puerto.RepositorioTarifa;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.stereotype.Repository;

@Repository
public class RepositorioTarifaH2 implements RepositorioTarifa {

    private final CustomNamedParameterJdbcTemplate customNamedParameterJdbcTemplate;

    private final MapeoTarifa mapeoTarifa;

    @SqlStatement(namespace = "tarifa", value = "obtenerporcodigo")
    private String sqlObtenerPorCodigo;

    @SqlStatement(namespace = "tarifa", value = "obtenerporid")
    private String sqlObtenerPorId;

    public RepositorioTarifaH2(CustomNamedParameterJdbcTemplate customNamedParameterJdbcTemplate, MapeoTarifa mapeoTarifa) {
        this.customNamedParameterJdbcTemplate = customNamedParameterJdbcTemplate;
        this.mapeoTarifa = mapeoTarifa;
    }

    @Override
    public Tarifa obtenerPorCodigo(String codigo) {
        MapSqlParameterSource paramSource = new MapSqlParameterSource();
        paramSource.addValue("codigo", codigo);

        return EjecucionBaseDeDatos.obtenerUnObjetoONull(() -> this.customNamedParameterJdbcTemplate.getNamedParameterJdbcTemplate()
                .queryForObject(sqlObtenerPorCodigo, paramSource, mapeoTarifa));
    }

    @Override
    public Tarifa obtenerPorId(Long id) {
        MapSqlParameterSource paramSource = new MapSqlParameterSource();
        paramSource.addValue("id", id);

        return EjecucionBaseDeDatos.obtenerUnObjetoONull(() -> this.customNamedParameterJdbcTemplate.getNamedParameterJdbcTemplate()
                .queryForObject(sqlObtenerPorId, paramSource, mapeoTarifa));
    }


}
