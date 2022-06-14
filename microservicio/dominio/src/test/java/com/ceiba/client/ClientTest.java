package com.ceiba.client;

import com.ceiba.BasePrueba;
import com.ceiba.dominio.excepcion.ExcepcionValorObligatorio;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class ClientTest {

    @Test
    void deberiaCrearClientExitoso() {
        var client = new ClientTestDataBuilder()
                .conId(1l)
                .conIdentificacionPersonal("001")
                .conNombre("MILTON PAREDES")
                .conDireccion("QUITO").reconstruir();
        Assertions.assertEquals(1l, client.getId());
        Assertions.assertEquals("001", client.getIdentificacionPersonal());
        Assertions.assertEquals("MILTON PAREDES", client.getNombre());
        Assertions.assertEquals("QUITO", client.getDireccion());
    }

    @Test
    void reconstruirClientSinIdDeberiaLanzarError() {
        BasePrueba.assertThrows(() -> new ClientTestDataBuilder()
                        .conIdentificacionPersonal("001")
                        .conDireccion("QUITO")
                        .conNombre("MILTON PAREDES").reconstruir(),
                ExcepcionValorObligatorio.class,
                "Id del cliente es requerida");
    }

    @Test
    void reconstruirClientSinIdentificacionPersonalDeberiaLanzarError() {
        BasePrueba.assertThrows(() -> new ClientTestDataBuilder()
                        .conId(1l)
                        .conDireccion("QUITO")
                        .conNombre("MILTON PAREDES").reconstruir(),
                ExcepcionValorObligatorio.class,
                "Identificacion del cliente es requerida");
    }

    @Test
    void reconstruirClientSinNombreDeberiaLanzarError() {
        BasePrueba.assertThrows(() -> new ClientTestDataBuilder()
                        .conId(1l)
                        .conDireccion("QUITO")
                        .conIdentificacionPersonal("001").reconstruir(),
                ExcepcionValorObligatorio.class,
                "Nombre del Cliente es requerido");
    }

    @Test
    void reconstruirClientSinDireccionDeberiaLanzarError() {
        BasePrueba.assertThrows(() -> new ClientTestDataBuilder()
                        .conId(1l)
                        .conIdentificacionPersonal("001")
                        .conNombre("MILTON PAREDES").reconstruir(),
                ExcepcionValorObligatorio.class,
                "Direccion del cliente es requerido");
    }


}
