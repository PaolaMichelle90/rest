package com.CuentaCliente.rest.Models;

import jakarta.persistence.*;

/* Clase de la tabla Movimiento
* ID - identificador del registro auto incrementable,
CUENTA - número de cuenta,
TIPO - especifica si se trata de débito (D) o crédito (C)
ESTADO - indica si la transacción fue correcta (N) o rechazada (R),
MONEDA_MTO - moneda del depósito o retiro 0: Bs, 1: USD
VALOR_ANT decimal(18,2),
VALOR valor del movimiento
* */

@Entity
@Table(name = "Movimiento")
public class MovimientoModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(unique = true, nullable = false)
    private Long id;
    private Integer cuenta;
    private Integer moneda;
    private String tipo;
    private String estado;
    private double valor_ant;
    private double valor;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }


    public Integer getCuenta() {
        return cuenta;
    }

    public void setCuenta(Integer cuenta) {
        this.cuenta = cuenta;
    }

    public Integer getMoneda() {
        return moneda;
    }

    public void setMoneda(Integer moneda) {
        this.moneda = moneda;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public double getValor_ant() {
        return valor_ant;
    }

    public void setValor_ant(double valor_ant) {
        this.valor_ant = valor_ant;
    }

    public double getValor() {
        return valor;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }
}
