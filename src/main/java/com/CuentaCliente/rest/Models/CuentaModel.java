package com.CuentaCliente.rest.Models;

import jakarta.persistence.*;

/* Se crea la tabla cuenta con sus campos
*
* ID - valor autoincrementable
CUENTA - cuenta cliente asignado
MONEDA - moneda de la cuenta 0:BS, 1:USD
NOMBRE_CUENTA - nombre de la cuenta cliente
ESTADO - estado de la cuenta ACTIVE, HOLD
SALDO_ANT - valor del saldo anterior
SALDO - valor del saldo actual de la cuenta
* */
@Entity
@Table(name = "cuenta")
public class CuentaModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(unique = true, nullable = false)
    private Long id;
    private Integer cuenta;
    private Integer moneda;
    private Integer es_nueva;
    private String nombre_cuenta;
    private String estado;
    private double saldo_ant;
    private double saldo;

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

    public Integer getEs_nueva() {
        return es_nueva;
    }

    public void setEs_nueva(Integer es_nueva) {
        this.es_nueva = es_nueva;
    }

    public String getNombre_cuenta() {
        return nombre_cuenta;
    }

    public void setNombre_cuenta(String nombre_cuenta) {
        this.nombre_cuenta = nombre_cuenta;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public double getSaldo_ant() {
        return saldo_ant;
    }

    public void setSaldo_ant(double saldo_ant) {
        this.saldo_ant = saldo_ant;
    }

    public double getSaldo() {
        return saldo;
    }

    public void setSaldo(double saldo) {
        this.saldo = saldo;
    }

}
