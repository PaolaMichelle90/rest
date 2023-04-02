package com.CuentaCliente.rest.Controllers;

import com.CuentaCliente.rest.Models.CuentaModel;
import com.CuentaCliente.rest.Repositories.CuentaRepository;
import com.CuentaCliente.rest.Services.CuentaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Optional;

@RestController
@RequestMapping("/cuenta")
public class CuentaController {
    @Autowired
    CuentaService cuentaService;
    @GetMapping()
    public ArrayList<CuentaModel> obtenerUsuarios(){
        return cuentaService.obtenerCuentas();
    }
    @PostMapping()
    public CuentaModel guardarCuenta(@RequestBody CuentaModel cuenta){
        return this.cuentaService.guardarCuenta(cuenta);
    }
    @GetMapping( path = "/{id}")
    public Optional<CuentaModel> obtenerCuentaPorId(@PathVariable("id") Long id) {
        return this.cuentaService.obtenerPorId(id);
    }


    @GetMapping("/query")
    public ArrayList<CuentaModel> obtenerCuentaPorPrioridad(@RequestParam("prioridad") Integer prioridad){
        return this.cuentaService.obtenerPorPrioridad(prioridad);
    }

    @DeleteMapping( path = "/{id}")
    public String eliminarPorId(@PathVariable("id") Long id){
        boolean ok = this.cuentaService.eliminarCuenta(id);
        if (ok){
            return "Se eliminó la cuenta con id " + id;
        }else{
            return "No pudo eliminar la cuenta con id" + id;
        }
    }

}
