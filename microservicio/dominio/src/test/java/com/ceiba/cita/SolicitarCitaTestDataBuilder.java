package com.ceiba.cita;

import com.ceiba.cita.modelo.entidad.SolicitarCita;
import com.ceiba.client.entidad.Client;
import com.ceiba.tarifa.entidad.Tarifa;

import java.time.LocalDate;
import java.time.LocalTime;

public class SolicitarCitaTestDataBuilder {

    private Client cliente;
    private Tarifa tarifa;
    private LocalDate fechaCita;
    private LocalTime horaCita;
    private String horario;
    private Integer metrosCuadrados;


    public SolicitarCitaTestDataBuilder conClient(Client client) {
        this.cliente = client;
        return this;
    }

    public SolicitarCitaTestDataBuilder conTarifa(Tarifa tarifa) {
        this.tarifa = tarifa;
        return this;
    }

    public SolicitarCitaTestDataBuilder conFechaCita(LocalDate fechaCita) {
        this.fechaCita = fechaCita;
        return this;
    }

    public SolicitarCitaTestDataBuilder conHoraCita(LocalTime horaCita) {
        this.horaCita = horaCita;
        return this;
    }

    public SolicitarCitaTestDataBuilder conHorario(String horario) {
        this.horario = horario;
        return this;
    }

    public SolicitarCitaTestDataBuilder conMetrosCuadrado(Integer metrosCuadrados) {
        this.metrosCuadrados = metrosCuadrados;
        return this;
    }


    public SolicitarCita build() {
        return new SolicitarCita(cliente, tarifa, fechaCita, horaCita, horario, metrosCuadrados);
    }

}
