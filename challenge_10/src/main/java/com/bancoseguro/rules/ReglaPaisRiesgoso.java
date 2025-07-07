package com.bancoseguro.rules;

import com.bancoseguro.model.Transaccion;
import com.bancoseguro.util.Config;

public class ReglaPaisRiesgoso {
    private final Config config;

    public ReglaPaisRiesgoso(Config config) {
        this.config = config;
    }

    public boolean esSospechosa(Transaccion t) {
        return config.getPaisesRiesgosos().contains(t.getPais());
    }
}
