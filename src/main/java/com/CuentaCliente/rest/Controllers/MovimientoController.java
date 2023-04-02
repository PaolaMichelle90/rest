package com.CuentaCliente.rest.Controllers;

import com.CuentaCliente.rest.Models.CuentaModel;
import com.CuentaCliente.rest.Models.MovimientoModel;
import com.CuentaCliente.rest.Services.CuentaService;
import com.CuentaCliente.rest.Services.MovimientoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Optional;

@RestController
@RequestMapping("/movimiento")
public class MovimientoController {
    @Autowired
    MovimientoService movimientoService;
    @GetMapping()
    public ArrayList<MovimientoModel> obtenerUsuarios(){
        return movimientoService.obtenerMovimientos();
    }
    @PostMapping()
    public MovimientoModel guardarMovimiento(@RequestBody MovimientoModel movimiento){
        return this.movimientoService.guardarMovimiento(movimiento);
    }
    @GetMapping( path = "/{id}")
    public Optional<MovimientoModel> obtenerMovimientoPorId(@PathVariable("id") Long id) {
        return this.movimientoService.obtenerPorId(id);
    }

    @GetMapping("/query")
    public ArrayList<MovimientoModel> obtenerMovimientoPorCuenta(@RequestParam("cuenta") Integer cuenta){
        return this.movimientoService.obtenerPorCuenta(cuenta);
    }


    @DeleteMapping( path = "/{id}")
    public String eliminarPorId(@PathVariable("id") Long id){
        boolean ok = this.movimientoService.eliminarMovimiento(id);
        if (ok){
            return "Se eliminó el registro " + id;
        }else{
            return "No pudo eliminar el registro " + id;
        }
    }
}
