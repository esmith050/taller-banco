package com.banco;

public class cuenta {

    protected float saldo;
    protected int numConsignaciones = 0;
    protected int numRetiros = 0;
    protected float tasaAnual;
    protected float comisionMensual = 0;

    public cuenta(float saldo, float tasa) {
        this.saldo = saldo;
        this.tasaAnual = tasa;
    }

    public void consignar(float cantidad) {
        saldo += cantidad;
        numConsignaciones++;
    }

    public void retirar(float cantidad) {
        if (cantidad <= saldo) {
            saldo -= cantidad;
            numRetiros++;
        } else {
            System.out.println("No hay suficiente saldo");
        }
    }

    public void calcularInteres() {
        float interesMensual = (saldo * tasaAnual / 100) / 12;
        saldo += interesMensual;
    }

    public void extractoMensual() {
        saldo -= comisionMensual;
        calcularInteres();
    }

    public void imprimir() {
        System.out.println("Saldo: " + saldo);
        System.out.println("Consignaciones: " + numConsignaciones);
        System.out.println("Retiros: " + numRetiros);
        System.out.println("Tasa anual: " + tasaAnual);
        System.out.println("Comision mensual: " + comisionMensual);
    }
}