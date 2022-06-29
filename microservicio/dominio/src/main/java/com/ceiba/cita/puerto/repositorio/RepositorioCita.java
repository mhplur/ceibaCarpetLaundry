package com.ceiba.cita.puerto.repositorio;

import com.ceiba.cita.modelo.entidad.Cita;

import java.util.List;

public interface RepositorioCita {

    List<Cita> obtenerTodasActivas();

    Long guardar(Cita cita);

    Cita obtenerPorId(Long id);

    void actualizarEstado(Cita cita);
}
