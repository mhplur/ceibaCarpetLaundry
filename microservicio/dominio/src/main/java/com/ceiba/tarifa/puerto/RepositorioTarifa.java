package com.ceiba.tarifa.puerto;

import com.ceiba.tarifa.entidad.Tarifa;

public interface RepositorioTarifa {
    Tarifa obtenerPorCodigo(String codigo);

    Tarifa obtenerPorId(Long id);

}
