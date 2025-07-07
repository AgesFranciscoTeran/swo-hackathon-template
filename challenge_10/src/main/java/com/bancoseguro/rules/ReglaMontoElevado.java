package com.bancoseguro.rules;

import com.bancoseguro.model.Transaccion;
import com.bancoseguro.util.Config;

public class ReglaMontoElevado {
    private final Config config;

    public ReglaMontoElevado(Config config) {
        this.config = config;
    }

    public boolean esSospechosa(Transaccion t) {
        return t.getMonto() > config.getUmbralMonto();
    }
}
