package com.bancoseguro.util;

import java.util.Arrays;


public class ConfigLoader {
    /**
     * Simula la carga de configuración, puedes cambiarlo para leer de un archivo si lo prefieres.
     */
    public static Config cargar() {
        double umbralMonto = 10000.0;
var paisesRiesgosos = Arrays.asList("Obscuristan", "Peligrolandia", "Riesgovania");
        int limiteTransaccionesFrecuencia = 3;
        int ventanaFrecuenciaSegundos = 60;

        return new Config(
                umbralMonto,
                paisesRiesgosos,
                limiteTransaccionesFrecuencia,
                ventanaFrecuenciaSegundos
        );
    }
}
