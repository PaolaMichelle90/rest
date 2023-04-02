package com.CuentaCliente.rest.Repositories;
import java.util.ArrayList;
import java.util.Optional;
import java.util.OptionalInt;

import com.CuentaCliente.rest.Models.CuentaModel;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CuentaRepository extends CrudRepository<CuentaModel, Long> {
    public abstract ArrayList<CuentaModel> findByPrioridad(Integer prioridad);
    public abstract Optional<CuentaModel> findByCuenta(Integer cuenta);
}
