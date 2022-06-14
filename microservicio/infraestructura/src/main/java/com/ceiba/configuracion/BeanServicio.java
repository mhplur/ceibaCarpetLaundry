package com.ceiba.configuracion;

import com.ceiba.cita.puerto.RepositorioCita;
import com.ceiba.cita.servicio.ServicioCancelar;
import com.ceiba.cita.servicio.ServicioCitar;
import com.ceiba.factura.puerto.repositorio.RepositorioFactura;
import com.ceiba.factura.servicio.ServicioAnular;
import com.ceiba.factura.servicio.ServicioFacturar;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class BeanServicio {


    @Bean
    public ServicioFacturar servicioFacturar(RepositorioFactura repositorioFactura) {
        return new ServicioFacturar(repositorioFactura);
    }

    @Bean
    public ServicioAnular servicioAnular(RepositorioFactura repositorioFactura) {
        return new ServicioAnular(repositorioFactura);
    }

    @Bean
    public ServicioCancelar servicioCancelar(RepositorioCita repositorioCita) {
        return new ServicioCancelar(repositorioCita);
    }

    @Bean
    public ServicioCitar servicioCitar(RepositorioCita repositorioCita) {
        return new ServicioCitar(repositorioCita);
    }


}
