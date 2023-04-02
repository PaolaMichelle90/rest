package com.CuentaCliente.rest.Services;

import com.CuentaCliente.rest.Models.CuentaModel;
import com.CuentaCliente.rest.Repositories.CuentaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Optional;

@Service
public class CuentaService {
    @Autowired
    CuentaRepository cuentaRepository;

    public ArrayList<CuentaModel> obtenerCuentas() {
        return (ArrayList<CuentaModel>) cuentaRepository.findAll();
    }

    public CuentaModel guardarCuenta(CuentaModel cuenta) {
        // Se inicializa el registro de la cuenta
        cuenta.setEstado("ACTIVE");
        cuenta.setSaldo_ant(0);
        cuenta.setSaldo(0);
        cuenta.setEs_nueva(0); // 0 es cuenta nueva
        return cuentaRepository.save(cuenta);
    }

    public Optional<CuentaModel> obtenerPorId(Long id) {
        return cuentaRepository.findById(id);
    }

    public Optional<CuentaModel> obtenerPorCuenta(Integer cuenta) {
        return cuentaRepository.findByCuenta(cuenta);
    }

    public ArrayList<CuentaModel> obtenerPorPrioridad(Integer prioridad) {
        return cuentaRepository.findByPrioridad(prioridad);
    }

    public boolean eliminarCuenta(Long id) {
        try {
            cuentaRepository.deleteById(id);
            return true;
        } catch (Exception err) {
            return false;
        }
    }
    // Verifica si corresponde el deposito a la cuenta cliente según las validaciones enviadas
    public static boolean depositoEfectivo(double monto, Integer moneda, Integer cuenta){
        CuentaModel cuentaModel = new CuentaModel();
        cuentaModel.getClass();
        if (moneda == cuentaModel.getMoneda()){
            double saldo_temp=cuentaModel.getSaldo()+monto;
            if (cuentaModel.getEstado()=="HOLD" && saldo_temp>=0){
                cuentaModel.setEstado("ACTIVE");
            }
            cuentaModel.setSaldo_ant(cuentaModel.getSaldo());
            cuentaModel.setSaldo(cuentaModel.getSaldo()+monto);
            return true;
        } else {
            return false;
        }
    }
    // Verifica si corresponde el retiro a la cuenta cliente según las validaciones enviadas
    public static boolean retiroEfectivo(double monto, Integer moneda, Integer cuenta){
        CuentaModel cuentaModel = new CuentaModel();
        cuentaModel.getClass();
        if (moneda == cuentaModel.getMoneda() && cuentaModel.getEstado()!="HOLD"){
            if (cuentaModel.getEs_nueva() == 0) {
                if (monto >cuentaModel.getSaldo()){
                    cuentaModel.setEstado("HOLD");
                }
                cuentaModel.setSaldo_ant(cuentaModel.getSaldo());
                cuentaModel.setSaldo(cuentaModel.getSaldo()-monto);
                cuentaModel.setEs_nueva(1);// 1 indica que ya se hizo el primer retiro
                return true;
            } else {
                double saldo_temp=cuentaModel.getSaldo()-monto;
                if (saldo_temp >=0){
                    cuentaModel.setSaldo_ant(cuentaModel.getSaldo());
                    cuentaModel.setSaldo(cuentaModel.getSaldo()-monto);
                    return true;
                } else {
                    return false;
                }
            }

        }
        else {
            return false;
        }
    }
}

