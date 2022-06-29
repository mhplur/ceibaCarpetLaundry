package com.ceiba.tarifa.controlador;

import com.ceiba.tarifa.consulta.ManejadorConsultaTarifaPorCodigo;
import com.ceiba.tarifa.consulta.ManejadorConsultaTarifaPorId;
import com.ceiba.tarifa.entidad.Tarifa;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/tarifa")
@Tag(name = "Controlador consulta tarifa")
public final class ConsultaControladorTarifa {

    private final ManejadorConsultaTarifaPorCodigo manejadorConsultaTarifaPorCodigo;

    private final ManejadorConsultaTarifaPorId manejadorConsultaTarifaPorId;

    public ConsultaControladorTarifa(ManejadorConsultaTarifaPorCodigo manejadorConsultaTarifaPorCodigo,
                                      ManejadorConsultaTarifaPorId manejadorConsultaTarifaPorId) {
        this.manejadorConsultaTarifaPorCodigo = manejadorConsultaTarifaPorCodigo;
        this.manejadorConsultaTarifaPorId = manejadorConsultaTarifaPorId;
    }

    @GetMapping("obtenerPorCodigo/{codigo}")
    @Operation(summary = "Buscar", description = "Metodo utilizado para buscar una Tarifa por su codigo")
    public Tarifa obtenerPorCodigo(@PathVariable("codigo") String codigo) {
        return this.manejadorConsultaTarifaPorCodigo.ejecutar(codigo);
    }

    @GetMapping("obtenerPorId/{id}")
    @Operation(summary = "Buscar", description = "Metodo utilizado para buscar una Tarifa por su id")
    public Tarifa obtenerPorId(@PathVariable("id") Long id) {
        return this.manejadorConsultaTarifaPorId.ejecutar(id);
    }
}
