package com.ceiba.cita.adaptador.repositorio;

import com.ceiba.cita.modelo.entidad.Cita;
import com.ceiba.cita.puerto.RepositorioCita;
import com.ceiba.client.puerto.RepositorioClient;
import com.ceiba.infraestructura.jdbc.MapperResult;
import com.ceiba.tarifa.puerto.RepositorioTarifa;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.LocalTime;

@Component
public class MapeoCita implements RowMapper<Cita>, MapperResult {


    private final RepositorioClient repositorioClient;

    private final RepositorioTarifa repositorioTarifa;


    public MapeoCita(RepositorioClient repositorioClient, RepositorioTarifa repositorioTarifa) {
        this.repositorioClient = repositorioClient;
        this.repositorioTarifa = repositorioTarifa;
    }

    @Override
    public Cita mapRow(ResultSet resultSet, int rowNum) throws SQLException {
        var id = resultSet.getLong("id");
        var idCliente = resultSet.getLong("id_client");
        var idTarifa = resultSet.getLong("id_tarifa");
        var fechaCita = resultSet.getString("fecha_cita");
        var horaCita = resultSet.getString("hora_cita");
        var horario = resultSet.getString("horario");
        var estado = resultSet.getInt("estado");
        var costo = resultSet.getDouble("costo");

        return Cita.reconstruir(id, repositorioClient.obtenerPorId(idCliente),
                repositorioTarifa.obtenerPorId(idTarifa), LocalDate.parse(fechaCita),
                LocalTime.parse(horaCita), horario, estado, costo);
    }


}
