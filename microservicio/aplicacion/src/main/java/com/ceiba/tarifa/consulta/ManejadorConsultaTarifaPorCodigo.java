package com.ceiba.tarifa.consulta;

import com.ceiba.tarifa.entidad.Tarifa;
import com.ceiba.tarifa.puerto.RepositorioTarifa;
import org.springframework.stereotype.Component;

@Component
public class ManejadorConsultaTarifaPorCodigo {

    private final RepositorioTarifa repositorioTarifa;

    public ManejadorConsultaTarifaPorCodigo(RepositorioTarifa repositorioTarifa) {
        this.repositorioTarifa = repositorioTarifa;
    }

    public Tarifa ejecutar(String codigo){
        return repositorioTarifa.obtenerPorCodigo(codigo);
    }
}
