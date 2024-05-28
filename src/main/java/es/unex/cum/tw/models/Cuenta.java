package es.unex.cum.tw.models;

import java.time.LocalDate;

public class Cuenta
{
    private int id_cuenta;
    private String numero_cuenta;
    private double saldo;
    private LocalDate fecha_creacion;

    public Cuenta(){
        this.id_cuenta = 0;
        this.numero_cuenta = "";
        this.saldo = 0.0d;
        this.fecha_creacion = LocalDate.now();
    }

    public Cuenta(int id_cuenta, String numero_cuenta, double saldo, LocalDate fecha_creacion) {
        this.id_cuenta = id_cuenta;
        this.numero_cuenta = numero_cuenta;
        this.saldo = saldo;
        this.fecha_creacion = fecha_creacion;
    }

    public Cuenta(String numero_cuenta, double saldo, LocalDate fecha_creacion) {
        this.numero_cuenta = numero_cuenta;
        this.saldo = saldo;
        this.fecha_creacion = fecha_creacion;
    }

    public int getId_cuenta() {
        return id_cuenta;
    }

    public void setId_cuenta(int id_cuenta) {
        this.id_cuenta = id_cuenta;
    }

    public String getNumero_cuenta() {
        return numero_cuenta;
    }

    public void setNumero_cuenta(String numero_cuenta) {
        this.numero_cuenta = numero_cuenta;
    }

    public double getSaldo() {
        return saldo;
    }

    public void setSaldo(double saldo) {
        this.saldo = saldo;
    }

    public LocalDate getFecha_creacion() {
        return fecha_creacion;
    }

    public void setFecha_creacion(LocalDate fecha_creacion) {
        this.fecha_creacion = fecha_creacion;
    }


}
