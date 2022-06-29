package com.ceiba.client.consulta;

import com.ceiba.client.entidad.Client;
import com.ceiba.client.puerto.RepositorioClient;
import org.springframework.stereotype.Component;

@Component
public class ManejadorConsultaClientesPorId {

    private final RepositorioClient repositorioClient;

    public ManejadorConsultaClientesPorId(RepositorioClient repositorioClient){
        this.repositorioClient = repositorioClient;
    }

    public Client ejecutar(Long id){
        return repositorioClient.obtenerPorId(id);
    }
}
