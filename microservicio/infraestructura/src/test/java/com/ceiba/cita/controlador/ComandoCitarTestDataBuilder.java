package com.ceiba.cita.controlador;

import com.ceiba.cita.ComandoSolicitarCita;

import java.time.LocalDate;
import java.time.LocalTime;

public class ComandoCitarTestDataBuilder {

    private Long idClient;

    private Long idTarifa;

    private LocalDate fechaCita;
    private LocalTime horaCita;
    private String horario;


    public ComandoCitarTestDataBuilder crearPorDefecto() {
        this.idClient = 1l;
        this.idTarifa = 1l;
        this.fechaCita = LocalDate.parse("2022-06-14");
        this.horaCita = LocalTime.parse("08:00:00");
        this.horario = "DIA";
        return this;
    }

    public ComandoSolicitarCita build() {
        return new ComandoSolicitarCita(this.idClient, this.idTarifa, this.fechaCita, this.horaCita, this.horario);
    }
}
