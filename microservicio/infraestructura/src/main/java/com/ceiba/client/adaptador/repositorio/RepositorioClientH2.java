package com.ceiba.client.adaptador.repositorio;

import com.ceiba.client.entidad.Client;
import com.ceiba.client.puerto.RepositorioClient;
import com.ceiba.infraestructura.jdbc.CustomNamedParameterJdbcTemplate;
import com.ceiba.infraestructura.jdbc.EjecucionBaseDeDatos;
import com.ceiba.infraestructura.jdbc.sqlstatement.SqlStatement;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class RepositorioClientH2 implements RepositorioClient {
    //TODO OK
    private final CustomNamedParameterJdbcTemplate customNamedParameterJdbcTemplate;

    private final MapeoClient mapeoClient;

    @SqlStatement(namespace = "client", value = "obtenertodas")
    private String sqlObtenerTodas;

    @SqlStatement(namespace = "client", value = "obtenerporidentificacionpersonal")
    private String sqlObtenerPorIdentificacionPersonal;

    @SqlStatement(namespace = "client", value = "obtenerporid")
    private String sqlObtenerPorId;

    public RepositorioClientH2(CustomNamedParameterJdbcTemplate customNamedParameterJdbcTemplate, MapeoClient mapeoClient) {
        this.customNamedParameterJdbcTemplate = customNamedParameterJdbcTemplate;
        this.mapeoClient = mapeoClient;
    }

    @Override
    public List<Client> obtenerTodos() {
        return this.customNamedParameterJdbcTemplate.getNamedParameterJdbcTemplate()
                .query(sqlObtenerTodas, mapeoClient);
    }

    @Override
    public Client obtenerPorIdentificacionPersonal(String identificacionPersonal) {
        MapSqlParameterSource paramSource = new MapSqlParameterSource();
        paramSource.addValue("identificacionPersonal", identificacionPersonal);

        return EjecucionBaseDeDatos.obtenerUnObjetoONull(() -> this.customNamedParameterJdbcTemplate.getNamedParameterJdbcTemplate()
                .queryForObject(sqlObtenerPorIdentificacionPersonal, paramSource, mapeoClient));
    }

    @Override
    public Client obtenerPorId(Long id) {
        MapSqlParameterSource paramSource = new MapSqlParameterSource();
        paramSource.addValue("id", id);

        return EjecucionBaseDeDatos.obtenerUnObjetoONull(() -> this.customNamedParameterJdbcTemplate.getNamedParameterJdbcTemplate()
                .queryForObject(sqlObtenerPorId, paramSource, mapeoClient));
    }
}
