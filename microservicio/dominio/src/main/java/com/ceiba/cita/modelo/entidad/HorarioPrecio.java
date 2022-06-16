package com.ceiba.cita.modelo.entidad;

import lombok.Getter;

@Getter
public enum HorarioPrecio {
    NOCHE(0.0, 5),
    DIA_DESCUENTO(0.1, 0),
    NOCHE_DESCUENTO(0.1, 3);

    private Double porcentaje;

    private Integer costoAdicional;

    private int hola;

    private HorarioPrecio(Double porcentaje, Integer costoAdicional) {

        this.porcentaje = porcentaje;
        this.costoAdicional = costoAdicional;
    }

}
