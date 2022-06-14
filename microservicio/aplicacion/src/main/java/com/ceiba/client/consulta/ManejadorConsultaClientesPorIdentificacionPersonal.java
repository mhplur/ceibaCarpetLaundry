package com.ceiba.client.consulta;

import com.ceiba.client.entidad.Client;
import com.ceiba.client.puerto.RepositorioClient;
import org.springframework.stereotype.Component;

@Component
public class ManejadorConsultaClientesPorIdentificacionPersonal {

    private final RepositorioClient repositorioClient;

    public ManejadorConsultaClientesPorIdentificacionPersonal(RepositorioClient repositorioClient) {
        this.repositorioClient = repositorioClient;
    }

    public Client ejecutar(String identificacionPersonal) {
        return repositorioClient.obtenerPorIdentificacionPersonal(identificacionPersonal);
    }
}
