# Reto 10: Validador de Transacciones Bancarias - Migración Java a Node.js

## Descripción
Este reto simula la migración de un sistema crítico de validación de transacciones bancarias de Java a Node.js. El sistema detecta transacciones sospechosas basándose en tres criterios principales: monto elevado, país de riesgo y frecuencia alta de transacciones.

**Objetivo:** Migrar el código Java existente a Node.js manteniendo exactamente la misma funcionalidad, reglas de negocio y valores de configuración.

## Estructura del Proyecto
```
challenge_10/
├── transaccion-validator-java/     # Código base en Java (referencia)
└── transaccion-validator-nodejs/   # Implementación en Node.js (a desarrollar)
```

## Prerrequisitos
- [Node.js v18+](https://nodejs.org/en/download/)
- [Java v21](https://www.oracle.com/co/java/technologies/downloads/)

## Ejecución

### Java (Código de referencia)
```bash
cd transaccion-validator-java

# Compilar
javac -cp src/main/java -d target/classes src/main/java/com/bancoseguro/**/*.java

# Ejecutar
java -cp target/classes com.bancoseguro.Main <id> <clienteId> <monto> <pais> <timestamp>
```


# Ejecutar
node src/main.js <id> <clienteId> <monto> <pais> <timestamp>


## Ejemplos de Uso

### Casos de Prueba Válidos

# Transacción con monto elevado
java -cp target/classes com.bancoseguro.Main 1 123 15000 Pacificolandia 1751849926647
node src/main.js 1 123 15000 Pacificolandia 1751849926647

# Transacción desde país riesgoso
java -cp target/classes com.bancoseguro.Main 2 456 500 Obscuristan 1751849926647
node src/main.js 2 456 500 Obscuristan 1751849926647

# Transacción válida
java -cp target/classes com.bancoseguro.Main 3 789 100 Verdelandia 1751849926647
node src/main.js 3 789 100 Verdelandia 1751849926647


### Manejo de Errores
```bash
# Parámetros insuficientes
java -cp target/classes com.bancoseguro.Main 1 123
node src/main.js 1 123

# ID inválido
java -cp target/classes com.bancoseguro.Main abc 123 15000 Obscuristan 1751849926647
node src/main.js abc 123 15000 Obscuristan 1751849926647

# Monto inválido
java -cp target/classes com.bancoseguro.Main 1 123 abc Obscuristan 1751849926647
node src/main.js 1 123 abc Obscuristan 1751849926647

# ClienteId inválido
java -cp target/classes com.bancoseguro.Main 1 abc 15000 Obscuristan 1751849926647
node src/main.js 1 abc 15000 Obscuristan 1751849926647

# Timestamp inválido
java -cp target/classes com.bancoseguro.Main 1 123 15000 Obscuristan abc
node src/main.js 1 123 15000 Obscuristan abc

# Valores negativos
java -cp target/classes com.bancoseguro.Main -1 123 15000 Obscuristan 1751849926647
node src/main.js -1 123 15000 Obscuristan 1751849926647

# País vacío
java -cp target/classes com.bancoseguro.Main 1 123 15000 "  " 1751849926647
node src/main.js 1 123 15000 "  " 1751849926647
```

## Reglas de Validación

1. **Monto Elevado**: Transacciones que superan el umbral configurado
2. **País Riesgoso**: Transacciones desde países clasificados como riesgosos
3. **Frecuencia Alta**: Más de 3 transacciones del mismo cliente en 60 segundos

## Criterios de Aceptación

### Funcionales
- Migración completa del código Java a Node.js
- Mantener exactamente las mismas reglas de negocio
- Conservar los mismos valores de configuración (umbrales, países, límites)
- Funcionamiento correcto con parámetros de línea de comandos
- Manejo robusto de errores con mensajes específicos

### Técnicos
- Código ejecutable sin errores en Node.js
- Estructura modular manteniendo la separación de responsabilidades
- Manejo apropiado de parámetros inválidos o faltantes
- Validación de tipos y valores de entrada

## Países Ficticios Utilizados
- **Riesgosos**: Obscuristan, Peligrolandia, Riesgovania
- **Seguros**: Pacificolandia, Verdelandia

## Instrucciones de Implementación
1. Analiza el código Java en `transaccion-validator-java/`
2. Implementa la migración en `transaccion-validator-nodejs/`
3. Mantén exactamente los mismos valores de configuración
4. Asegúrate de que ambas versiones produzcan resultados idénticos
5. Valida el manejo de errores en ambas implementaciones

## Importante
- **NO modifiques** los valores de configuración del código Java original
- **Mantén** los mismos mensajes de salida y validación
- **Replica** la estructura de clases y responsabilidades en Node.js
- **Valida** que ambas versiones manejen errores de forma consistente
