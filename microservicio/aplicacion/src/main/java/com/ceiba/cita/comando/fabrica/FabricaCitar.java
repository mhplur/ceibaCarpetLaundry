package com.ceiba.cita.comando.fabrica;

import com.ceiba.cita.ComandoSolicitarCita;
import com.ceiba.cita.modelo.entidad.Cita;
import com.ceiba.cita.modelo.entidad.SolicitarCita;
import com.ceiba.client.puerto.RepositorioClient;
import com.ceiba.tarifa.puerto.RepositorioTarifa;
import org.springframework.stereotype.Component;

@Component
public class FabricaCitar {

    private final RepositorioClient repositorioClient;

    private final RepositorioTarifa repositorioTarifa;

    public FabricaCitar(RepositorioClient repositorioClient, RepositorioTarifa repositorioTarifa) {
        this.repositorioClient = repositorioClient;
        this.repositorioTarifa = repositorioTarifa;
    }

    public SolicitarCita crear(ComandoSolicitarCita comandoSolicitarCita) {
        return new SolicitarCita(
                repositorioClient.obtenerPorId(comandoSolicitarCita.getIdCliente()),
                repositorioTarifa.obtenerPorId(comandoSolicitarCita.getIdTarifa())
                , comandoSolicitarCita.getFechaCita(), comandoSolicitarCita.getHoraCita(), comandoSolicitarCita.getHorario()
                , comandoSolicitarCita.getMetrosCuadrados());
    }
}
