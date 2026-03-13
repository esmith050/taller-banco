package com.banco;

public class cuentaCorriente extends cuenta {

    private float sobregiro = 0;

    public cuentaCorriente(float saldo, float tasa) {
        super(saldo, tasa);
    }

    @Override
    public void retirar(float cantidad) {

        if (cantidad <= saldo) {
            saldo -= cantidad;
        } else {
            sobregiro += cantidad - saldo;
            saldo = 0;
        }

        numRetiros++;
    }

    @Override
    public void consignar(float cantidad) {

        if (sobregiro > 0) {

            if (cantidad > sobregiro) {
                float restante = cantidad - sobregiro;
                sobregiro = 0;
                saldo += restante;
            } else {
                sobregiro -= cantidad;
            }

        } else {
            super.consignar(cantidad);
        }
    }

    @Override
    public void extractoMensual() {
        super.extractoMensual();
    }

    public void imprimir() {
        System.out.println("Saldo: " + saldo);
        System.out.println("Comision mensual: " + comisionMensual);
        System.out.println("Transacciones: " + (numConsignaciones + numRetiros));
        System.out.println("Sobregiro: " + sobregiro);
    }
}