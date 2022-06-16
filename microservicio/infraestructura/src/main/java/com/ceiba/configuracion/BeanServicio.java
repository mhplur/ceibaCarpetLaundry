package com.ceiba.configuracion;

import com.ceiba.cita.puerto.RepositorioCita;
import com.ceiba.cita.servicio.ServicioCancelar;
import com.ceiba.cita.servicio.ServicioCitar;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class BeanServicio {

    @Bean
    public ServicioCancelar servicioCancelar(RepositorioCita repositorioCita) {
        return new ServicioCancelar(repositorioCita);
    }

    @Bean
    public ServicioCitar servicioCitar(RepositorioCita repositorioCita) {
        return new ServicioCitar(repositorioCita);
    }


}
