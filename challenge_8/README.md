# Reto 8: Simplificación de Condicionales en Evaluador de Riesgo de Crédito

## Descripción
En una organización del sector financiero, se identificó un componente crítico del sistema de evaluación crediticia que contiene una gran cantidad de condicionales anidados, reglas duplicadas y malas prácticas de codificación. Este componente ha crecido sin una estructura clara, dificultando su mantenimiento, escalabilidad y validación de cambios.

Tu misión es tomar ese código legado —específicamente la clase `EvaluadorRiesgoCredito`— y refactorizarlo aplicando buenas prácticas de desarrollo. Deberás organizar la lógica dispersa, separar responsabilidades en funciones auxiliares y mejorar la legibilidad sin modificar el comportamiento del sistema.

Este ejercicio simula un caso real de modernización de código dentro de una organización, donde el objetivo no es solo que el programa funcione, sino que también sea mantenible, escalable y fácil de entender para otros desarrolladores.

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

> **Nota:** La clase `ReglasNegocio.java` ya contiene la lógica de negocio implementada. Tu tarea es refactorizar `EvaluadorRiesgoCredito.java` para optimizar las consultas utilizando estos métodos.

## Criterios de aceptación funcionales
- El código de evaluación de riesgo debe estar en `EvaluadorRiesgoCredito.java`.
- El código debe ser más legible, fácil de mantener y sin condicionales anidados innecesarios.
- El programa debe seguir funcionando correctamente y producir los mismos resultados que la versión original.
- **Debes optimizar las consultas en `EvaluadorRiesgoCredito.java` utilizando los métodos ya disponibles en `ReglasNegocio.java`.**

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
- La lógica debe utilizar eficientemente los métodos ya implementados en `ReglasNegocio.java`.
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
1. Omite los pasos 1 a 3 si ya los ejecutaste. De lo contrario, clona el repositorio:
   https://github.com/SoftwareOne-Hackaton-Demo/swo-hackathon-template.git
2. Clona el repositorio asignado para tu equipo.
3. Copia y pega el contenido del repositorio https://github.com/SoftwareOne-Hackaton-Demo/swo-hackathon-template al repositorio asigando a tu equipo.
4. En la carpeta correspondiente al reto, verifica que tienes los archivos `EvaluadorRiesgoCredito.java` y `ReglasNegocio.java` en:
   ```
   src/main/java/
   ```
5. Refactoriza el código en `EvaluadorRiesgoCredito.java`, optimizando las consultas y utilizando los métodos ya disponibles en `ReglasNegocio.java`.
6. Asegúrate de que el código compile y funcione correctamente.
7. Realiza commit y push de tus cambios.
8. Finalmente, en el aplicativo de hackaton, envía el ejercicio correspondiente a challenge 8 para su revisión.

## Observaciones
- No modifiques la funcionalidad original, solo simplifica la lógica.
- El código debe ser claro, legible y fácil de mantener.
- Valida que la lógica se comporte de forma consistente frente a distintas condiciones de entrada.

## Recursos útiles
- [Guía de refactorización de condicionales en Java](https://refactoring.guru/es/replace-nested-conditional-with-guard-clauses)
- [Documentación oficial de Java](https://docs.oracle.com/en/java/)
