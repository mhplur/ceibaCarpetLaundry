package com.ceiba.cita;

import com.ceiba.cita.modelo.entidad.Cita;
import com.ceiba.client.entidad.Client;
import com.ceiba.tarifa.entidad.Tarifa;

import java.time.LocalDate;
import java.time.LocalTime;

public class CitaTestDataBuilder {

    private Long id;

    private Client client;

    private Tarifa tarifa;

    private LocalDate fechaCita;

    private LocalTime horaCita;

    private String horario;

    private Integer estado;

    private Double costo;

    public CitaTestDataBuilder conCitaPorDefecto() {
        this.id = 1l;
        this.client = new Client(1l, "001", "MILTON PAREDES", "QUITO");
        this.tarifa = new Tarifa(1l, "VAPOR O AGUA CALIENTE", "W001", 24, 15, 1);
        this.fechaCita = LocalDate.parse("2022-09-17");
        this.horaCita = LocalTime.parse("08:00:00");
        this.horario = "DIA";
        this.estado = 1;
        this.costo = 15.0;
        return this;
    }

    public CitaTestDataBuilder conId(Long id) {
        this.id = id;
        return this;
    }

    public CitaTestDataBuilder conClient(Client client) {
        this.client = client;
        return this;
    }

    public CitaTestDataBuilder conTarifa(Tarifa tarifa) {
        this.tarifa = tarifa;
        return this;
    }

    public CitaTestDataBuilder conFechaCita(LocalDate fechaCita) {
        this.fechaCita = fechaCita;
        return this;
    }

    public CitaTestDataBuilder conHoraCita(LocalTime horaCita) {
        this.horaCita = horaCita;
        return this;
    }

    public CitaTestDataBuilder conHorario(String horario) {
        this.horario = horario;
        return this;
    }

    public CitaTestDataBuilder conEstado(Integer estado) {
        this.estado = estado;
        return this;
    }

    public CitaTestDataBuilder conCosto(Double costo) {
        this.costo = costo;
        return this;
    }

    public Cita crear() {
        return Cita.crear(new SolicitarCitaTestDataBuilder()
                .conClient(client)
                .conTarifa(tarifa)
                .conFechaCita(fechaCita)
                .conHoraCita(horaCita)
                .conHorario(horario)
                .build());
    }


    public Cita reconstruir() {
        return Cita.reconstruir(id, client, tarifa, fechaCita, horaCita, horario, estado, costo);
    }


}
