package com.ceiba.cita.modelo.entidad;

import com.ceiba.client.entidad.Client;
import com.ceiba.tarifa.entidad.Tarifa;
import lombok.AllArgsConstructor;
import lombok.Getter;

import java.time.LocalDate;
import java.time.LocalTime;

@Getter
@AllArgsConstructor
public class SolicitarCita {

    private Client cliente;
    private Tarifa tarifa;
    private LocalDate fechaCita;
    private LocalTime horaCita;
    private String horario;
    private Integer metrosCuadrados;
}
