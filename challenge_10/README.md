# Reto 10: Validador de Transacciones Bancarias - Modernizacion Java a Node.js

## Descripción
En una organización del sector financiero, se identificó la necesidad de modernizar un sistema crítico de validación de transacciones bancarias. El sistema actual está desarrollado en Java y utiliza múltiples reglas de negocio para detectar transacciones sospechosas, pero la organización quiere migrar a tecnologías más modernas y escalables.

Tu misión es tomar el código Java existente del sistema de validación de transacciones y migrarlo completamente a Node.js, manteniendo toda la funcionalidad original pero aplicando buenas prácticas de desarrollo moderno. El sistema debe detectar transacciones sospechosas basándose en tres criterios principales: monto elevado, país de riesgo y frecuencia alta de transacciones.

Este ejercicio simula un caso real de migración tecnológica dentro de una organización, donde el objetivo no es solo que el programa funcione, sino que también sea mantenible, escalable y aproveche las características modernas de JavaScript/Node.js.

**Desafío:** Migrar el código Java a Node.js manteniendo la misma funcionalidad, estructura y lógica de validación.

## Prerrequisitos
- [Node.js v18+](https://nodejs.org/en/download/) (incluye npm)
- [Java v21](https://www.oracle.com/co/java/technologies/downloads/) (para referencia del código original)

## Estructura del proyecto
```
transaccion-validator-nodejs/
├── src/
│   ├── models/
│   │   ├── Cliente.js
│   │   └── Transaccion.js
│   ├── rules/
│   │   ├── ReglaMontoElevado.js
│   │   ├── ReglaPaisRiesgoso.js
│   │   └── ReglaFrecuenciaAlta.js
│   ├── services/
│   │   └── TransaccionService.js
│   ├── utils/
│   │   ├── Config.js
│   │   └── ConfigLoader.js
│   └── main.js
├── package.json
└── README.md
```

## Criterios de aceptación funcionales
- El código de validación de transacciones debe estar completamente migrado a Node.js.
- El sistema debe mantener las tres reglas de validación: monto elevado, país riesgoso y frecuencia alta.
- **Debes mantener exactamente las mismas reglas de negocio implementadas en el código Java entregado.**
- El programa debe funcionar correctamente con parámetros de línea de comandos.
- **Debes implementar la lógica de validación utilizando las reglas de negocio en JavaScript.**

### Casos de prueba sugeridos
| Escenario | Descripción |
|-----------|-------------|
| Transacción con monto elevado | Debe ser marcada como "Sospechosa por monto". |
| Transacción desde país riesgoso | Debe ser marcada como "Sospechosa por país". |
| Transacción con frecuencia alta | Debe ser marcada como "Requiere revisión manual por frecuencia". |
| Transacción válida | Debe ser marcada como "Transacción válida". |
| Múltiples factores de riesgo | Debe ser rechazada por el primer factor encontrado. |
| Datos incompletos o inválidos | Debe manejarse apropiadamente con mensajes de error. |

- Puedes agregar otros casos que consideres relevantes para asegurar la robustez de la lógica.

### Criterios de aceptación técnicos
- El código debe ejecutarse sin errores en Node.js.
- La lógica debe utilizar eficientemente los métodos implementados en las clases de reglas.
- Debe implementar correctamente las tres reglas de validación.
- Debe funcionar correctamente con parámetros de línea de comandos.

### Ejemplo de ejecución
Ejecuta el programa desde la carpeta del proyecto:
```bash
# Ejecutar con parámetros específicos
node src/main.js <id> <clienteId> <monto> <pais> <timestamp>

# Ejemplos de casos de prueba
node src/main.js 1 123 15000 Pacificolandia 1751849926647  # Monto elevado
node src/main.js 2 456 500 Obscuristan 1751849926647      # País riesgoso
node src/main.js 3 789 100 Verdelandia 1751849926647      # Transacción válida
```

La salida debe mostrar los resultados de la validación de transacciones para los casos de prueba implementados.

## Importante: Mantener Valores del Código Java

**Debes mantener exactamente los mismos valores de configuración del código Java original:**

- **Umbral de monto**: El mismo valor configurado en el código Java
- **Países riesgosos**: La misma lista de países del código Java
- **Límite de transacciones por frecuencia**: El mismo número configurado en Java
- **Ventana de tiempo para frecuencia**: El mismo tiempo en segundos del código Java
- **Mensajes de respuesta**: Los mismos textos exactos que retorna el código Java

**No cambies ningún valor de configuración, moderniza el programa a Node.js**


### Ejemplos de prueba en Java:
```bash

java -cp target/classes com.bancoseguro.Main 1 123 15000 Pacificolandia 1751849926647


java -cp target/classes com.bancoseguro.Main 2 456 500 Obscuristan 1751849926647


java -cp target/classes com.bancoseguro.Main 3 789 100 Verdelandia 1751849926647
```


## Instrucciones de implementación del ejercicio
1. Clona el repositorio base del hackathon:
   ```bash
   git clone <URL_DEL_REPOSITORIO>
   cd transaccion-validator-nodejs
   ```
2. **Analiza cuidadosamente el código Java original proporcionado para entender la lógica de validación y las reglas de negocio.**
3. **Migra completamente el código Java a Node.js, manteniendo exactamente las mismas reglas y configuraciones:**
   - Modelos de datos (Cliente, Transacción)
   - Reglas de negocio (ReglaMontoElevado, ReglaPaisRiesgoso, ReglaFrecuenciaAlta)
   - Servicio de validación (TransaccionService)
   - Configuración del sistema (Config, ConfigLoader)
   - Programa principal con parámetros de línea de comandos
4. **Asegúrate de que los valores de configuración (umbrales, países, límites) sean idénticos a los del código Java.**
5. Asegúrate de que el código ejecute correctamente con los parámetros requeridos.
6. Realiza commit de tus cambios:
   ```bash
   git add .
   git commit -m "Migra sistema de validación de transacciones de Java a Node.js"
   git push
   ```
7. Sube tu solución según las instrucciones del hackathon.


## Observaciones
- **Mantén exactamente la funcionalidad y reglas del sistema Java entregado.**
- **No modifiques los valores de configuración (umbrales, países riesgosos, límites) del código original.**
- El código debe ser claro, legible y fácil de mantener.
- Valida que la lógica se comporte de forma consistente frente a distintas condiciones de entrada.
- Utiliza las características modernas de JavaScript/Node.js para mejorar la legibilidad.
- Implementa correctamente el manejo de parámetros de línea de comandos.
- Asegúrate de que todas las reglas de validación funcionen correctamente.

## Recursos útiles
- [Guía de refactorización de condicionales](https://refactoring.guru/es/replace-nested-conditional-with-guard-clauses)
- [Documentación oficial de Node.js](https://nodejs.org/en/docs/)
- [Guía de ES6 Modules](https://developer.mozilla.org/en-US/docs/Web/JavaScript/Guide/Modules)
