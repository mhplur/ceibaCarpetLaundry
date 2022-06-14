package com.ceiba.cita.controlador;

import com.ceiba.ComandoRespuesta;
import com.ceiba.cita.ComandoCancelar;
import com.ceiba.cita.ComandoSolicitarCita;
import com.ceiba.cita.comando.manejador.ManejadorCancelar;
import com.ceiba.cita.comando.manejador.ManejadorCitar;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/cita")
@Tag(name = "Controlador comando cita")
public class ComandoControladorCita {

    private final ManejadorCancelar manejadorCancelar;

    private final ManejadorCitar manejadorCitar;

    public ComandoControladorCita(ManejadorCancelar manejadorCancelar, ManejadorCitar manejadorCitar) {
        this.manejadorCancelar = manejadorCancelar;
        this.manejadorCitar = manejadorCitar;
    }

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping
    @Operation(summary = "Tomar cita", description = "Metodo utilizado para poder tomar una cita")
    public ComandoRespuesta<Long> tomarCita(@RequestBody ComandoSolicitarCita comandoSolicitarCita) {
        return this.manejadorCitar.ejecutar(comandoSolicitarCita);
    }

    @PostMapping("cancelar/{id-cita}")
    @Operation(summary = "Cancelar", description = "Metodo utilizado para aunlar una cita")
    public void cancelar(@PathVariable("id-cita") Long idCita) {
        this.manejadorCancelar.ejecutar(new ComandoCancelar(idCita));
    }


}
