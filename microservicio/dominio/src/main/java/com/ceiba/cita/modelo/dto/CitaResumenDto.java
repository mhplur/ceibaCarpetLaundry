package com.ceiba.cita.modelo.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalTime;

@AllArgsConstructor
@Getter
public class CitaResumenDto {

    private Long id;
    private String clienteNombre;
    private String tarifaNombre;
    private LocalDate fechaCita;
    private LocalTime horaCita;
    private String horario;
    private Integer estado;
    private Double costo;
    private Integer metrosCuadrados;

}
