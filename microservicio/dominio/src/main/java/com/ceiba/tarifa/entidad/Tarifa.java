package com.ceiba.tarifa.entidad;

import com.ceiba.dominio.ValidadorArgumento;
import lombok.AllArgsConstructor;

@AllArgsConstructor
public class Tarifa {
    private Long id;

    private String nombre;

    private String codigo;

    private Integer tiempoHoraSecado;

    private Integer costoPorMetroCuadrado;

    private Integer limpiezaProfunda;

    public static Tarifa reconstuir(Long id, String nombre, String codigo, Integer tiempoHoraSecado, Integer costoPorMetroCuadrado, Integer limpiezaProfunda) {
        ValidadorArgumento.validarObligatorio(id, "Id de la tarifa es requerido");
        ValidadorArgumento.validarObligatorio(nombre, "Nombre de la tarifa es requerido");
        ValidadorArgumento.validarObligatorio(codigo, "Codigo de la tarifa es requerido");
        ValidadorArgumento.validarObligatorio(tiempoHoraSecado, "Tiempo hora de secado de la tarifa es requerido");
        ValidadorArgumento.validarObligatorio(costoPorMetroCuadrado, "Costo por metro cuadrado de la tarifa es requerido");
        ValidadorArgumento.validarObligatorio(limpiezaProfunda, "Limpieza profunda de la tarifa es requerido");
        return new Tarifa(id, nombre, codigo, tiempoHoraSecado, costoPorMetroCuadrado, limpiezaProfunda);
    }

    public Long getId() {
        return id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public Integer getTiempoHoraSecado() {
        return tiempoHoraSecado;
    }

    public Integer getCostoPorMetroCuadrado() {
        return costoPorMetroCuadrado;
    }

    public Integer getLimpiezaProfunda() {
        return limpiezaProfunda;
    }

}
