package com.ceiba.client.controlador;

import com.ceiba.client.consulta.ManejadorConsultaClientes;
import com.ceiba.client.consulta.ManejadorConsultaClientesPorId;
import com.ceiba.client.consulta.ManejadorConsultaClientesPorIdentificacionPersonal;
import com.ceiba.client.entidad.Client;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = {"http://localhost:4200"})
@RestController
@RequestMapping("/cliente")
@Tag(name = "Controlador consulta client")
public final class ConsultaControladorClient {

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

    @GetMapping()
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
