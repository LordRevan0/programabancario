package com.Revan;

public class CuentaLargoPlazo extends Cuenta {

    public final double PENALTI = 0.05;

    public boolean retirar(double monto){
        monto += monto * PENALTI;
        return super.retirar(monto);
    }

}
