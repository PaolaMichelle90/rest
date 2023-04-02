package com.CuentaCliente.rest.Services;

import com.CuentaCliente.rest.Models.CuentaModel;
import com.CuentaCliente.rest.Models.MovimientoModel;
import com.CuentaCliente.rest.Repositories.CuentaRepository;
import com.CuentaCliente.rest.Repositories.MovimientoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Optional;

@Service
public class MovimientoService {
    @Autowired
    MovimientoRepository movimientoRepository;
    CuentaService cuentaService;
    public ArrayList<MovimientoModel> obtenerMovimientos() {
        return (ArrayList<MovimientoModel>) movimientoRepository.findAll();
    }
    // Se validará si corresponde guardar el movimiento registrado
    public MovimientoModel guardarMovimiento(MovimientoModel movimiento) {
        boolean ok = false;
        
         if(movimiento.getTipo() == "D"){
            ok = CuentaService.depositoEfectivo(movimiento.getValor(), movimiento.getMoneda(), movimiento.getCuenta());
        }
        if(movimiento.getTipo() == "C"){
            ok =  CuentaService.retiroEfectivo(movimiento.getValor(), movimiento.getMoneda(), movimiento.getCuenta());
        }
        if (ok == true){
            movimiento.setEstado("N");
        } else {
            movimiento.setEstado("R");
        }
        return movimientoRepository.save(movimiento);
    }

    public Optional<MovimientoModel> obtenerPorId(Long id) {
        return movimientoRepository.findById(id);
    }


    public ArrayList<MovimientoModel> obtenerPorCuenta(Integer cuenta) {
        return movimientoRepository.findByCuenta(cuenta);
    }

    public boolean eliminarMovimiento(Long id) {
        try {
            movimientoRepository.deleteById(id);
            return true;
        } catch (Exception err) {
            return false;
        }
    }
}
