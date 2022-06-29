package com.ceiba.cita;

import com.ceiba.factura.modelo.dto.ResumenFacturaDTO;
import com.ceiba.factura.modelo.entidad.EstadoFactura;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

public class ResumenFacturaDtoTest {

    @Test
    void deberiaConstruirSatisfactoriamente(){
        ResumenFacturaDTO resumenFacturaDTO = new ResumenFacturaDTO(
                1L, new BigDecimal(5), EstadoFactura.ACTIVA
        );
        Assertions.assertEquals(1L, resumenFacturaDTO.getId());
        Assertions.assertEquals(new BigDecimal(5), resumenFacturaDTO.getValorTotal());
        Assertions.assertEquals(EstadoFactura.ACTIVA, resumenFacturaDTO.getEstado());

    }
}
