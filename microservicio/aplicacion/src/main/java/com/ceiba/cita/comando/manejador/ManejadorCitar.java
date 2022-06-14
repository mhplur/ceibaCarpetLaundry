package com.ceiba.cita.comando.manejador;

import com.ceiba.ComandoRespuesta;
import com.ceiba.cita.ComandoSolicitarCita;
import com.ceiba.cita.comando.fabrica.FabricaCitar;
import com.ceiba.cita.servicio.ServicioCitar;
import com.ceiba.manejador.ManejadorComandoRespuesta;
import org.springframework.stereotype.Component;

@Component
public class ManejadorCitar implements ManejadorComandoRespuesta<ComandoSolicitarCita, ComandoRespuesta<Long>> {

    private final FabricaCitar fabricaCitar;

    private final ServicioCitar servicioCitar;

    public ManejadorCitar(FabricaCitar fabricaCitar, ServicioCitar servicioCitar) {
        this.fabricaCitar = fabricaCitar;
        this.servicioCitar = servicioCitar;
    }

    @Override
    public ComandoRespuesta<Long> ejecutar(ComandoSolicitarCita comandoSolicitarCita) {
        return new ComandoRespuesta<>(servicioCitar.ejecutar(fabricaCitar.crear(comandoSolicitarCita)));
    }
}
