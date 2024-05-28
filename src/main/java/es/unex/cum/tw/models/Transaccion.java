package es.unex.cum.tw.models;

import java.time.LocalDate;

public class Transaccion {
    private int id_transaccion;
    private int id_cuenta;
    private double monto;
    private String tipo_transaccion;
    private LocalDate fecha_transaccion;

    public Transaccion(){
        this.id_transaccion = 0;
        this.id_cuenta = 0;
        this.monto = 0.0d;
        this.tipo_transaccion = "";
        this.fecha_transaccion = LocalDate.now();
    }

    public Transaccion(int id_transaccion, int id_cuenta, double monto, String tipo_transaccion, LocalDate fecha_transaccion) {
        this.id_transaccion = id_transaccion;
        this.id_cuenta = id_cuenta;
        this.monto = monto;
        this.tipo_transaccion = tipo_transaccion;
        this.fecha_transaccion = fecha_transaccion;
    }

    public Transaccion(int id_cuenta, double monto, String tipo_transaccion, LocalDate fecha_transaccion) {
        this.id_cuenta = id_cuenta;
        this.monto = monto;
        this.tipo_transaccion = tipo_transaccion;
        this.fecha_transaccion = fecha_transaccion;
    }

    public int getId_transaccion() {
        return id_transaccion;
    }

    public void setId_transaccion(int id_transaccion) {
        this.id_transaccion = id_transaccion;
    }

    public int getId_cuenta() {
        return id_cuenta;
    }

    public void setId_cuenta(int id_cuenta) {
        this.id_cuenta = id_cuenta;
    }

    public double getMonto() {
        return monto;
    }

    public void setMonto(double monto) {
        this.monto = monto;
    }

    public String getTipo_transaccion() {
        return tipo_transaccion;
    }

    public void setTipo_transaccion(String tipo_transaccion) {
        this.tipo_transaccion = tipo_transaccion;
    }

    public LocalDate getFecha_transaccion() {
        return fecha_transaccion;
    }

    public void setFecha_transaccion(LocalDate fecha_transaccion) {
        this.fecha_transaccion = fecha_transaccion;
    }
}
