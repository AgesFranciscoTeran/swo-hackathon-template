package com.bancoseguro.service;

import com.bancoseguro.model.Transaccion;
import com.bancoseguro.rules.ReglaFrecuenciaAlta;
import com.bancoseguro.rules.ReglaMontoElevado;
import com.bancoseguro.rules.ReglaPaisRiesgoso;
import com.bancoseguro.util.Config;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class TransaccionService {
    private final Config config;
    private final List<Transaccion> transacciones = new ArrayList<>();

    // Reglas
    private final ReglaMontoElevado reglaMontoElevado;
    private final ReglaPaisRiesgoso reglaPaisRiesgoso;
    private final ReglaFrecuenciaAlta reglaFrecuenciaAlta;

    public TransaccionService(Config config) {
        this.config = config;
        this.reglaMontoElevado = new ReglaMontoElevado(config);
        this.reglaPaisRiesgoso = new ReglaPaisRiesgoso(config);
        this.reglaFrecuenciaAlta = new ReglaFrecuenciaAlta(config);
    }

    /**
     * Registra la transacción y valida si es sospechosa usando las reglas de negocio.
     * @param t Transacción a procesar
     * @return Resultado de la validación
     */
    public String registrarYValidar(Transaccion t) {
        // Agregar a la lista interna
        transacciones.add(t);

        // Validar por monto
        if (reglaMontoElevado.esSospechosa(t)) {
            return "Sospechosa por monto";
        }
        // Validar por país riesgoso
        if (reglaPaisRiesgoso.esSospechosa(t)) {
            return "Sospechosa por pais";
        }
        // Validar por frecuencia alta para ese cliente
        List<Transaccion> historialCliente = obtenerTransaccionesPorCliente(t.getClienteId());
        if (reglaFrecuenciaAlta.esSospechosa(t, historialCliente)) {
            return "Requiere revision manual por frecuencia";
        }

        return "Transaccion valida";
    }

    /**
     * Obtiene todas las transacciones para un cliente específico.
     * @param clienteId ID del cliente
     * @return Lista de transacciones del cliente
     */
    public List<Transaccion> obtenerTransaccionesPorCliente(int clienteId) {
        return transacciones.stream()
                .filter(t -> t.getClienteId() == clienteId)
                .collect(Collectors.toList());
    }
}
