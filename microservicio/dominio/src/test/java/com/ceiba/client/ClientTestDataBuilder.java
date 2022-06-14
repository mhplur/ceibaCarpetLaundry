package com.ceiba.client;

import com.ceiba.client.entidad.Client;

public class ClientTestDataBuilder {

    private Long id;

    private String identificacionPersonal;

    private String nombre;

    private String direccion;

    public ClientTestDataBuilder conClientPorDefecto() {
        this.id = 1l;
        this.identificacionPersonal = "001";
        this.nombre = "MILTON PAREDES";
        this.direccion = "QUITO";
        return this;
    }

    public ClientTestDataBuilder conId(Long id) {
        this.id = id;
        return this;
    }


    public ClientTestDataBuilder conIdentificacionPersonal(String identificacionPersonal) {
        this.identificacionPersonal = identificacionPersonal;
        return this;
    }

    public ClientTestDataBuilder conNombre(String nombre) {
        this.nombre = nombre;
        return this;
    }

    public ClientTestDataBuilder conDireccion(String direccion) {
        this.direccion = direccion;
        return this;
    }

    public Client reconstruir() {
        return Client.reconstruir(id, identificacionPersonal, nombre, direccion);
    }
}
