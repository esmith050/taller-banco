package com.banco;

public class Main {

    public static void main(String[] args) {

    cuentaAhorro cuenta = new cuentaAhorro(15000, 12);

        cuenta.consignar(2000);
        cuenta.retirar(2000);
        cuenta.retirar(1000);
        cuenta.retirar(1000);
        cuenta.retirar(1000);
        cuenta.retirar(1000);

        cuenta.extractoMensual();

        cuenta.imprimir();
    }
}