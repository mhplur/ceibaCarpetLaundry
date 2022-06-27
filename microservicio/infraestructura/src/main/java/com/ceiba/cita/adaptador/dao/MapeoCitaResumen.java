package com.ceiba.cita.adaptador.dao;

import com.ceiba.cita.modelo.dto.CitaResumenDto;
import com.ceiba.client.puerto.RepositorioClient;
import com.ceiba.factura.modelo.dto.ResumenFacturaDTO;
import com.ceiba.infraestructura.jdbc.MapperResult;
import com.ceiba.tarifa.puerto.RepositorioTarifa;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.LocalTime;

@Component
public class MapeoCitaResumen implements RowMapper<CitaResumenDto>, MapperResult {

    private final RepositorioClient repositorioClient;

    private final RepositorioTarifa repositorioTarifa;

    public MapeoCitaResumen(RepositorioClient repositorioClient, RepositorioTarifa repositorioTarifa) {
        this.repositorioClient = repositorioClient;
        this.repositorioTarifa = repositorioTarifa;
    }

    @Override
    public CitaResumenDto mapRow(ResultSet resultSet, int rowNum) throws SQLException {
        var id = resultSet.getLong("id");
        var idCliente = resultSet.getLong("id_client");
        var idTarifa = resultSet.getLong("id_tarifa");
        var fechaCita = resultSet.getString("fecha_cita");
        var horaCita = resultSet.getString("hora_cita");
        var horario = resultSet.getString("horario");
        var estado = resultSet.getInt("estado");
        var costo = resultSet.getDouble("costo");
        var metrosCuadrados = resultSet.getInt("metros_cuadrados");

        return new CitaResumenDto(id, repositorioClient.obtenerPorId(idCliente).getNombre(),
                repositorioTarifa.obtenerPorId(idTarifa).getNombre(), LocalDate.parse(fechaCita),
                LocalTime.parse(horaCita), horario, estado, costo, metrosCuadrados);
    }

}
