package com.ceiba.client.entidad;

import com.ceiba.dominio.ValidadorArgumento;
import lombok.AllArgsConstructor;

public class Client {

    private Long id;

    private String identificacionPersonal;

    private String nombre;

    private String direccion;

    public Client(Long id, String identificacionPersonal, String nombre, String direccion) {
        this.id = id;
        this.identificacionPersonal = identificacionPersonal;
        this.nombre = nombre;
        this.direccion = direccion;
    }

    public static Client reconstruir(Long id, String identificacionPersonal, String nombre, String direccion) {
        ValidadorArgumento.validarObligatorio(id, "Id del cliente es requerida");
        ValidadorArgumento.validarObligatorio(identificacionPersonal, "Identificacion del cliente es requerida");
        ValidadorArgumento.validarObligatorio(nombre, "Nombre del Cliente es requerido");
        ValidadorArgumento.validarObligatorio(direccion, "Direccion del cliente es requerido");
        return new Client(id, identificacionPersonal, nombre, direccion);
    }

    public Long getId() {
        return id;
    }

    public String getIdentificacionPersonal() {
        return identificacionPersonal;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDireccion() {
        return direccion;
    }

}

