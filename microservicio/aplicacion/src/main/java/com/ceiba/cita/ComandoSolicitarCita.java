package com.ceiba.cita;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
import java.time.LocalTime;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ComandoSolicitarCita {
    private Long idCliente;
    private Long idTarifa;
    private LocalDate fechaCita;
    private LocalTime horaCita;
    private String horario;
}
