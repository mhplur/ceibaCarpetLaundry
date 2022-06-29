package com.ceiba.cita.controlador;

import com.ceiba.cita.consulta.ManejadorConsultaCitasPorId;
import com.ceiba.cita.consulta.ManejadorConsultarCitas;
import com.ceiba.cita.modelo.dto.CitaResumenDto;
import com.ceiba.cita.modelo.entidad.Cita;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


@RestController
@RequestMapping("/cita")
@Tag(name = "Controlador consulta cita")
public class ConsultaControladorCita {

    private final ManejadorConsultarCitas manejadorConsultarCitas;

    private final ManejadorConsultaCitasPorId manejadorConsultaCitasPorId;

    public ConsultaControladorCita(ManejadorConsultarCitas manejadorConsultarCitas,
            ManejadorConsultaCitasPorId manejadorConsultaCitasPorId) {
        this.manejadorConsultarCitas = manejadorConsultarCitas;
        this.manejadorConsultaCitasPorId = manejadorConsultaCitasPorId;
    }

    @GetMapping("activa")
    @Operation(summary = "Obtener", description = "Metodo utilizado para obtener todas las citas que se encuentren activas ")
    public List<CitaResumenDto> obtenerTodas() {
        return manejadorConsultarCitas.ejecutar();
    }

    @GetMapping("obtenerPorId/{id}")
    @Operation(summary = "Buscar", description = "Metodo utilizado para buscar una Cita por su id")
    public Cita obtenerPorId(@PathVariable("id") Long id) {
        return this.manejadorConsultaCitasPorId.ejecutar(id);
    }

}
