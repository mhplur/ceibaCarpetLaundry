package com.ceiba.client.puerto;

import com.ceiba.client.entidad.Client;

import java.util.List;
import java.util.Optional;

public interface RepositorioClient {

    List<Client> obtenerTodos();

    Client obtenerPorIdentificacionPersonal(String identificacionPersonal);

    Client obtenerPorId(Long id);
}
