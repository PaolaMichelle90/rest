package com.CuentaCliente.rest.Repositories;

import com.CuentaCliente.rest.Models.CuentaModel;
import com.CuentaCliente.rest.Models.MovimientoModel;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;

@Repository
public interface MovimientoRepository extends CrudRepository<MovimientoModel, Long> {
    public abstract ArrayList<MovimientoModel> findByCuenta(Integer cuenta);
}
