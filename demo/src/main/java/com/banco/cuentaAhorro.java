package com.banco;

public class cuentaAhorro extends cuenta {

    private boolean activa;

    public cuentaAhorro(float saldo, float tasa) {
        super(saldo, tasa);
        this.activa = saldo >= 10000;
    }

    @Override
    public void consignar(float cantidad) {
        if (activa) {
            super.consignar(cantidad);
        } else {
            System.out.println("La cuenta está inactiva, no se puede consignar.");
        }
    }

    @Override
    public void retirar(float cantidad) {
        if (activa) {
            super.retirar(cantidad);
        } else {
            System.out.println("La cuenta está inactiva, no se puede retirar.");
        }
    }

    @Override
    public void extractoMensual() {

        if (numRetiros > 4) {
            comisionMensual += (numRetiros - 4) * 1000;
        }

        super.extractoMensual();

        activa = saldo >= 10000;
    }

    @Override
    public void imprimir() {
        System.out.println("Saldo: " + saldo);
        System.out.println("Comision mensual: " + comisionMensual);
        System.out.println("Transacciones: " + (numConsignaciones + numRetiros));
        System.out.println("Cuenta activa: " + activa);
    }
}