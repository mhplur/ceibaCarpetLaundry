package com.ceiba.client.controlador;

import com.ceiba.client.consulta.ManejadorConsultaClientes;
import com.ceiba.client.consulta.ManejadorConsultaClientesPorId;
import com.ceiba.client.consulta.ManejadorConsultaClientesPorIdentificacionPersonal;
import com.ceiba.client.entidad.Client;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/cliente")
@Tag(name = "Controlador consulta client")
public class ConsultaControladorClient {

    private final ManejadorConsultaClientes manejadorConsultaClientes;

    private final ManejadorConsultaClientesPorIdentificacionPersonal manejadorConsultaClientesPorIdentificacionPersonal;

    private final ManejadorConsultaClientesPorId manejadorConsultaClientesPorId;

    private ConsultaControladorClient(ManejadorConsultaClientes manejadorConsultaClientes,
                                      ManejadorConsultaClientesPorIdentificacionPersonal manejadorConsultaClientesPorIdentificacionPersonal,
    ManejadorConsultaClientesPorId manejadorConsultaClientesPorId) {
        this.manejadorConsultaClientes = manejadorConsultaClientes;
        this.manejadorConsultaClientesPorIdentificacionPersonal = manejadorConsultaClientesPorIdentificacionPersonal;
        this.manejadorConsultaClientesPorId = manejadorConsultaClientesPorId;
    }

    @GetMapping("todos")
    @Operation(summary = "Todos", description = "Metodo utilizado para consultar todos los clientes")
    public List<Client> obtenerTodos() {
        return manejadorConsultaClientes.ejecutar();
    }

    @GetMapping("obtenerPorIdentificacionPersonal/{identificacion-personal}")
    @Operation(summary = "Buscar", description = "Metodo utilizado para buscar un Cliente por su identificacion personal")
    public Client obtenerPorIdentificacionPersonal(@PathVariable("identificacion-personal") String identificacionPersonal) {
        return this.manejadorConsultaClientesPorIdentificacionPersonal.ejecutar(identificacionPersonal);
    }

    @GetMapping("obtenerPorId/{id}")
    @Operation(summary = "Buscar", description = "Metodo utilizado para buscar un Cliente por su id")
    public Client obtenerPorId(@PathVariable("id") Long id) {
        return this.manejadorConsultaClientesPorId.ejecutar(id);
    }
}
