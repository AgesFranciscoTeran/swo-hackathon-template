# Reto 8: Simplificación de Condicionales en Evaluador de Riesgo de Crédito

## Descripción
Recibirás una clase Java con lógica de evaluación de riesgo crediticio que contiene condicionales complejos y poco optimizados. Tu objetivo es refactorizar el código para simplificar los condicionales, mejorando la legibilidad y mantenibilidad, utilizando funciones auxiliares en una clase separada.

## Prerrequisitos
- [Java v21](https://www.oracle.com/co/java/technologies/downloads/)
- Sistema operativo: Windows, macOS o Linux.

## Estructura del proyecto
```
swo-hackaton-challenge-8/
├── src/
│   └── main/java/
│       ├── EvaluadorRiesgoCredito.java   # Código original con condicionales no optimizados
│       ├── ReglasNegocio.java           # Clase para simplificar la lógica de negocio
│       └── README.md
└── 
```

> **Nota:** Debes realizar la refactorización en `EvaluadorRiesgoCredito.java` y crear/usar funciones auxiliares en `ReglasNegocio.java` para simplificar la lógica.

## Criterios de aceptación funcionales
- El código de evaluación de riesgo debe estar en `EvaluadorRiesgoCredito.java`.
- La lógica de negocio simplificada debe implementarse en métodos auxiliares dentro de `ReglasNegocio.java`.
- El código debe ser más legible, fácil de mantener y sin condicionales anidados innecesarios.
- El programa debe seguir funcionando correctamente y producir los mismos resultados que la versión original.

### Casos de prueba sugeridos
| Escenario | Descripción |
|-----------|-------------|
| Cliente con buen historial y bajo riesgo | Debe ser aprobado. |
| Cliente con historial dudoso | Debe ser rechazado. |
| Cliente con ingresos insuficientes | Debe ser rechazado. |
| Cliente con múltiples factores de riesgo | Debe ser rechazado. |
| Cliente con todos los requisitos cumplidos | Debe ser aprobado. |
| Cliente con datos nulos o incompletos | Debe manejarse apropiadamente. |

- Puedes agregar otros casos que consideres relevantes para asegurar la robustez de la lógica.

### Criterios de aceptación técnicos
- El código debe compilar sin errores.
- La lógica debe estar correctamente separada entre las dos clases.
- No debe haber condicionales anidados innecesarios en `EvaluadorRiesgoCredito.java`.

### Ejemplo de ejecución
Compila y ejecuta el programa desde la carpeta `src/main/java/`:
```
javac EvaluadorRiesgoCredito.java ReglasNegocio.java
java EvaluadorRiesgoCredito
```
> **Importante:** Debes realizar la compilación manualmente antes de ejecutar el programa, asegurándote de que no existan errores de compilación.

La salida debe mostrar los resultados de la evaluación de riesgo para los casos de prueba implementados.

## Instrucciones de implementación del ejercicio
1. Clona el repositorio base del hackathon:
   ```
   git clone <URL_DEL_REPOSITORIO>
   cd swo-hackaton-challenge-8
   ```
2. Verifica que tienes los archivos `EvaluadorRiesgoCredito.java` y `ReglasNegocio.java` en:
   ```
   src/main/java/
   ```
3. Refactoriza el código, moviendo la lógica de negocio a métodos auxiliares en `ReglasNegocio.java`.
4. Asegúrate de que el código compile y funcione correctamente.
5. Realiza commit de tus cambios:
   ```
   git add src/main/java/EvaluadorRiesgoCredito.java src/main/java/ReglasNegocio.java
   git commit -m "Refactoriza condicionales y simplifica lógica de negocio"
   git push
   ```
6. Sube tu solución según las instrucciones del hackathon.

## Observaciones
- No modifiques la funcionalidad original, solo simplifica la lógica.
- El código debe ser claro, legible y fácil de mantener.
- Valida que la lógica se comporte de forma consistente frente a distintas condiciones de entrada.

## Recursos útiles
- [Guía de refactorización de condicionales en Java](https://refactoring.guru/es/replace-nested-conditional-with-guard-clauses)
- [Documentación oficial de Java](https://docs.oracle.com/en/java/)
