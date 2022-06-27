package com.ceiba.cita.servicio;

import com.ceiba.cita.modelo.entidad.Cita;
import com.ceiba.cita.modelo.entidad.HorarioPrecio;
import com.ceiba.cita.modelo.entidad.SolicitarCita;
import com.ceiba.cita.puerto.repositorio.RepositorioCita;

import java.util.List;

public class ServicioCitar {

    private static final String CONS_HORARIO_DIA = "DIA";
    private static final String CONS_HORARIO_NOCHE = "NOCHE";

    private final RepositorioCita repositorioCita;

    public ServicioCitar(RepositorioCita repositorioCita) {
        this.repositorioCita = repositorioCita;
    }

    public Long ejecutar(SolicitarCita solicitarCita) {
        if (UtilTime.checkAllRangeTime(solicitarCita.getHoraCita())) {
            var cita = Cita.crear(solicitarCita);
            cita.setEstado(1);
            cita.setCosto(getCost(solicitarCita));
            return repositorioCita.guardar(cita);
        }
        //TODO ADD EXCEPTION
        return 0l;
    }

    private Double getCost(SolicitarCita solicitarCita) {
        List<Cita> citas = repositorioCita.obtenerTodasActivas();
        boolean existeCitaPrevia = false;
        for (Cita cita : citas) {
            if (cita.getClient().getId() == solicitarCita.getCliente().getId()) {
                existeCitaPrevia = true;
                break;
            }
        }

        String horario = solicitarCita.getHorario();
        Integer costoPorMetroCuadrado = solicitarCita.getTarifa().getCostoPorMetroCuadrado();
        Double cost;
        if (existeCitaPrevia) {
            cost = getCostDiscount(costoPorMetroCuadrado, horario);
        } else {
            cost = getCostNormal(costoPorMetroCuadrado, horario);
        }

        return cost * solicitarCita.getMetrosCuadrados();
    }


    private Double getCostDiscount(Integer costoPorMetroCuadrado, String horario) {
        if (horario.equals(CONS_HORARIO_DIA)) {
            return costoPorMetroCuadrado - (costoPorMetroCuadrado * HorarioPrecio.DIA_DESCUENTO.getPorcentaje());
        } else if (horario.equals(CONS_HORARIO_NOCHE)) {
            return costoPorMetroCuadrado - (costoPorMetroCuadrado * HorarioPrecio.NOCHE_DESCUENTO.getPorcentaje()) + HorarioPrecio.NOCHE_DESCUENTO.getCostoAdicional();
        }
        return 0.0;
    }

    private Double getCostNormal(Integer squareMeterRate, String horario) {
        if (horario.equals(CONS_HORARIO_DIA)) {
            return Double.valueOf(squareMeterRate);
        } else if (horario.equals(CONS_HORARIO_NOCHE)) {
            return Double.valueOf(squareMeterRate + HorarioPrecio.NOCHE.getCostoAdicional());
        }
        return 0.0;
    }
}
