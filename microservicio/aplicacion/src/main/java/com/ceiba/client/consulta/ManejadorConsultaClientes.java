package com.ceiba.client.consulta;

import com.ceiba.client.entidad.Client;
import com.ceiba.client.puerto.RepositorioClient;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class ManejadorConsultaClientes {


    private final RepositorioClient repositorioClient;

    public ManejadorConsultaClientes(RepositorioClient repositorioClient){
        this.repositorioClient = repositorioClient;
    }

    public List<Client> ejecutar(){
        return repositorioClient.obtenerTodos();
    }
}
