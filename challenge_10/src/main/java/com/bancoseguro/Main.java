package com.bancoseguro;

import com.bancoseguro.model.Transaccion;
import com.bancoseguro.service.TransaccionService;
import com.bancoseguro.util.ConfigLoader;

public class Main {
    public static void main(String[] args) {
        // Validar argumentos
        if (args.length != 5) {
            System.out.println("Uso: java Main <id> <clienteId> <monto> <pais> <timestamp>");
            System.out.println("Ejemplo: java Main 1 123 15000 Obscuristan 1751849926647");
            System.out.println();
            System.out.println("Países riesgosos disponibles: Obscuristan, Peligrolandia, Riesgovania");
            System.out.println("Países seguros disponibles: Pacificolandia, Verdelandia");
            return;
        }

        try {
            // Parsear argumentos
            int id = Integer.parseInt(args[0]);
            int clienteId = Integer.parseInt(args[1]);
            double monto = Double.parseDouble(args[2]);
            String pais = args[3];
            long timestamp = Long.parseLong(args[4]);

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
            System.err.println("Error: Formato de número inválido en los argumentos");
            System.err.println("Uso: java Main <id> <clienteId> <monto> <pais> <timestamp>");
        }
    }
}
