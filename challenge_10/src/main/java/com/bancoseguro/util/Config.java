package com.bancoseguro.util;

import java.util.List;

public class Config {
    private double umbralMonto;
    private List<String> paisesRiesgosos;
    private int limiteTransaccionesFrecuencia; // ejemplo: 3
    private int ventanaFrecuenciaSegundos;     // ejemplo: 60 segundos

    public Config(double umbralMonto, List<String> paisesRiesgosos, int limiteTransaccionesFrecuencia, int ventanaFrecuenciaSegundos) {
        this.umbralMonto = umbralMonto;
        this.paisesRiesgosos = paisesRiesgosos;
        this.limiteTransaccionesFrecuencia = limiteTransaccionesFrecuencia;
        this.ventanaFrecuenciaSegundos = ventanaFrecuenciaSegundos;
    }

    public double getUmbralMonto() {
        return umbralMonto;
    }

    public List<String> getPaisesRiesgosos() {
        return paisesRiesgosos;
    }

    public int getLimiteTransaccionesFrecuencia() {
        return limiteTransaccionesFrecuencia;
    }

    public int getVentanaFrecuenciaSegundos() {
        return ventanaFrecuenciaSegundos;
    }
}
