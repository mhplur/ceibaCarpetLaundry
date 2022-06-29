package com.ceiba.client.adaptador.repositorio;

import com.ceiba.client.entidad.Client;
import com.ceiba.infraestructura.jdbc.MapperResult;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

import java.sql.ResultSet;
import java.sql.SQLException;

@Component
public class MapeoClient implements RowMapper<Client>, MapperResult {
    @Override
    public Client mapRow(ResultSet resultSet, int rowNum) throws SQLException {
        var id = resultSet.getLong("id");
        var identificacionPersonal = resultSet.getString("identificacion_personal");
        var nombre = resultSet.getString("nombre");
        var direccion = resultSet.getString("direccion");

        return new Client(id, identificacionPersonal, nombre, direccion);
    }
}
