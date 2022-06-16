package com.ceiba.cita.modelo.entidad;

import com.ceiba.client.entidad.Client;
import com.ceiba.dominio.ValidadorArgumento;
import com.ceiba.dominio.excepcion.ExcepcionValorInvalido;
import com.ceiba.tarifa.entidad.Tarifa;
import lombok.AllArgsConstructor;

import java.time.LocalDate;
import java.time.LocalTime;

@AllArgsConstructor
public class Cita {

    private Long id;

    private Client client;

    private Tarifa tarifa;

    private LocalDate fechaCita;

    private LocalTime horaCita;

    private String horario;

    private Integer estado;

    private Double costo;

    public Cita() {
        super();
    }

    public Cita(Client client, Tarifa tarifa, LocalDate fechaCita, LocalTime horaCita, String horario, Integer estado, Double costo) {
        this.client = client;
        this.tarifa = tarifa;
        this.fechaCita = fechaCita;
        this.horaCita = horaCita;
        this.horario = horario;
        this.estado = estado;
        this.costo = costo;
    }

    public Cita(Client client, Tarifa tarifa, LocalDate fechaCita, LocalTime horaCita, String horario) {
        this.client = client;
        this.tarifa = tarifa;
        this.fechaCita = fechaCita;
        this.horaCita = horaCita;
        this.horario = horario;
    }

    public static Cita crear(SolicitarCita solicitarCita) {
        ValidadorArgumento.validarObligatorio(solicitarCita.getCliente(), "Cliente de la cita es requerido");
        ValidadorArgumento.validarObligatorio(solicitarCita.getTarifa(), "Tarifa de la cita es requerido");
        ValidadorArgumento.validarObligatorio(solicitarCita.getFechaCita(), "Fecha de la cita es requerido");
        ValidadorArgumento.validarObligatorio(solicitarCita.getHoraCita(), "Hora de la cita es requerido");
        ValidadorArgumento.validarObligatorio(solicitarCita.getHorario(), "Horario de la cita es requerido");
        return new Cita(solicitarCita.getCliente(), solicitarCita.getTarifa(),
                solicitarCita.getFechaCita(), solicitarCita.getHoraCita(),
                solicitarCita.getHorario());
    }

    public static Cita reconstruir(Long id, Client client, Tarifa tarifa, LocalDate fechaCita, LocalTime horaCita, String horario, Integer estado, Double costo) {
        ValidadorArgumento.validarObligatorio(id, "Id de la cita es requerido");
        ValidadorArgumento.validarObligatorio(client, "Cliente de la cita es requerido");
        ValidadorArgumento.validarObligatorio(tarifa, "Tarifa de la cita es requerido");
        ValidadorArgumento.validarObligatorio(fechaCita, "Fecha de la cita es requerido");
        ValidadorArgumento.validarObligatorio(horaCita, "Hora de la cita es requerido");
        ValidadorArgumento.validarObligatorio(horario, "Horario de la cita es requerido");
        ValidadorArgumento.validarObligatorio(estado, "Estado de la cita es requerido");
        ValidadorArgumento.validarObligatorio(costo, "Costo de la cita es requerido");
        return new Cita(id, client, tarifa, fechaCita, horaCita, horario, estado, costo);
    }

    public void cancelar() {
        if (this.estado == 0) {
            throw new ExcepcionValorInvalido("La cita ya se encuentra cancelada ");
        }
        this.estado = 0;
    }

    public Long getId() {
        return id;
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    public Tarifa getTarifa() {
        return tarifa;
    }

    public LocalDate getFechaCita() {
        return fechaCita;
    }

    public LocalTime getHoraCita() {
        return horaCita;
    }

    public String getHorario() {
        return horario;
    }

    public Integer getEstado() {
        return estado;
    }

    public void setEstado(Integer estado) {
        this.estado = estado;
    }

    public Double getCosto() {
        return costo;
    }

    public void setCosto(Double costo) {
        this.costo = costo;
    }
}
