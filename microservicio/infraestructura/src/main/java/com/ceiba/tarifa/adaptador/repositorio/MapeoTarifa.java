package com.ceiba.tarifa.adaptador.repositorio;

import com.ceiba.infraestructura.jdbc.MapperResult;
import com.ceiba.tarifa.entidad.Tarifa;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

import java.sql.ResultSet;
import java.sql.SQLException;

@Component
public class MapeoTarifa implements RowMapper<Tarifa>, MapperResult {


    @Override
    public Tarifa mapRow(ResultSet resultSet, int rowNum) throws SQLException {
        var id = resultSet.getLong("id");
        var nombre = resultSet.getString("nombre");
        var codigo = resultSet.getString("codigo");
        var tiempoHoraSecado = resultSet.getInt("tiempo_hora_secado");
        var costoPorMetroCuadrado = resultSet.getInt("costo_por_metro_cuadrado");
        var limpiezaProfunda = resultSet.getInt("limpieza_profunda");
        return new Tarifa(id, nombre, codigo, tiempoHoraSecado, costoPorMetroCuadrado, limpiezaProfunda);
    }
}
