package com.ceiba.tarifa;

import com.ceiba.tarifa.entidad.Tarifa;

public class TarifaTestDataBuilder {

    private Long id;

    private String nombre;

    private String codigo;

    private Integer tiempoHoraSecado;

    private Integer costoPorMetroCuadrado;

    private Integer limpiezaProfunda;

    public TarifaTestDataBuilder conTarifaPorDefecto() {
        this.id = 1l;
        this.nombre = "VAPOR O AGUA CALIENTE";
        this.codigo = "W001";
        this.tiempoHoraSecado = 24;
        this.costoPorMetroCuadrado = 15;
        this.limpiezaProfunda = 1;
        return this;
    }

    public TarifaTestDataBuilder conId(Long id) {
        this.id = id;
        return this;
    }

    public TarifaTestDataBuilder conNombre(String nombre) {
        this.nombre = nombre;
        return this;
    }

    public TarifaTestDataBuilder conCodigo(String codigo){
        this.codigo = codigo;
        return this;
    }

    public TarifaTestDataBuilder conTiempoHoraSecado(Integer tiempoHoraSecado) {
        this.tiempoHoraSecado = tiempoHoraSecado;
        return this;
    }

    public TarifaTestDataBuilder conCostoPorMetroCuadrado(Integer costoPorMetroCuadrado) {
        this.costoPorMetroCuadrado = costoPorMetroCuadrado;
        return this;
    }

    public TarifaTestDataBuilder conLimpiezaProfunda(Integer limpiezaProfunda) {
        this.limpiezaProfunda = limpiezaProfunda;
        return this;
    }

    public Tarifa reconstruir() {
        return Tarifa.reconstuir(id, nombre, codigo, tiempoHoraSecado, costoPorMetroCuadrado, limpiezaProfunda);
    }
}
