package com.ceiba.tarifa.consulta;

import com.ceiba.tarifa.entidad.Tarifa;
import com.ceiba.tarifa.puerto.RepositorioTarifa;
import org.springframework.stereotype.Component;

@Component
public class ManejadorConsultaTarifaPorId {

    private final RepositorioTarifa repositorioTarifa;

    public ManejadorConsultaTarifaPorId(RepositorioTarifa repositorioTarifa) {
        this.repositorioTarifa = repositorioTarifa;
    }

    public Tarifa ejecutar(Long id){
        return repositorioTarifa.obtenerPorId(id);
    }
}
