package com.bancoseguro;

import com.bancoseguro.model.Transaccion;
import com.bancoseguro.service.TransaccionService;
import com.bancoseguro.util.ConfigLoader;

public class Main {
    public static void main(String[] args) {
        // Validar argumentos
        if (args.length != 5) {
            System.err.println("Error: Se requieren exactamente 5 parámetros: <id> <clienteId> <monto> <pais> <timestamp>");
            System.err.println("Uso: java Main <id> <clienteId> <monto> <pais> <timestamp>");
            System.err.println("Ejemplo: java Main 1 123 15000 Obscuristan 1751849926647");
            return;
        }

        try {
            // Parsear argumentos
            int id = Integer.parseInt(args[0]);
            int clienteId = Integer.parseInt(args[1]);
            double monto = Double.parseDouble(args[2]);
            String pais = args[3];
            long timestamp = Long.parseLong(args[4]);

            // Validar que no sean valores negativos
            if (id < 0 || clienteId < 0 || monto < 0 || timestamp < 0) {
                System.err.println("Error: Los valores numéricos no pueden ser negativos");
                System.err.println("Uso: java Main <id> <clienteId> <monto> <pais> <timestamp>");
                return;
            }

            // Validar que el país no esté vacío
            if (pais == null || pais.trim().isEmpty()) {
                System.err.println("Error: El país no puede estar vacío");
                System.err.println("Uso: java Main <id> <clienteId> <monto> <pais> <timestamp>");
                return;
            }

            // Cargar configuración
            var config = ConfigLoader.cargar();
            TransaccionService transaccionService = new TransaccionService(config);

            // Crear y procesar transacción
            Transaccion transaccion = new Transaccion(id, clienteId, monto, pais, timestamp);
            String resultado = transaccionService.registrarYValidar(transaccion);
            
            System.out.println("=== RESULTADO DE VALIDACIÓN ===");
            System.out.println("Transacción: " + transaccion.toString());
            System.out.println("Resultado: " + resultado);
            
        } catch (NumberFormatException e) {
            // Determinar qué parámetro causó el error
            String errorMessage = "Error: Formato de número inválido";
            try {
                Integer.parseInt(args[0]);
            } catch (NumberFormatException ex) {
                errorMessage = "Error: El ID debe ser un número válido";
            }
            
            try {
                if (errorMessage.equals("Error: Formato de número inválido")) {
                    Integer.parseInt(args[1]);
                }
            } catch (NumberFormatException ex) {
                errorMessage = "Error: El clienteId debe ser un número válido";
            }
            
            try {
                if (errorMessage.equals("Error: Formato de número inválido")) {
                    Double.parseDouble(args[2]);
                }
            } catch (NumberFormatException ex) {
                errorMessage = "Error: El monto debe ser un número válido";
            }
            
            try {
                if (errorMessage.equals("Error: Formato de número inválido")) {
                    Long.parseLong(args[4]);
                }
            } catch (NumberFormatException ex) {
                errorMessage = "Error: El timestamp debe ser un número válido";
            }
            
            System.err.println(errorMessage);
            System.err.println("Uso: java Main <id> <clienteId> <monto> <pais> <timestamp>");
        }
    }
}
