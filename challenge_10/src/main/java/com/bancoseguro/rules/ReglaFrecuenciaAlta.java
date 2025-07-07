package com.bancoseguro.rules;

import com.bancoseguro.model.Transaccion;
import com.bancoseguro.util.Config;

import java.util.List;

public class ReglaFrecuenciaAlta {
    private final Config config;

    public ReglaFrecuenciaAlta(Config config) {
        this.config = config;
    }

    /**
     * Verifica si el cliente realizó más de 3 transacciones en los últimos 60 segundos.
     */
    public boolean esSospechosa(Transaccion t, List<Transaccion> historial) {
        long ventanaTiempo = config.getVentanaFrecuenciaSegundos() * 1000L; // segundos a ms
        long limiteInferior = t.getTimestamp() - ventanaTiempo;

        long count = historial.stream()
                .filter(tr -> tr.getTimestamp() >= limiteInferior && tr.getTimestamp() <= t.getTimestamp())
                .count();

        return count > config.getLimiteTransaccionesFrecuencia();
    }
}
