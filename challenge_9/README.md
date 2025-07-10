# Reto 9: Optimización de Consultas SQL

## Descripción
En el sistema de gestión de solicitudes de crédito vehicular, el equipo técnico ha identificado varias consultas SQL complejas y poco eficientes, relacionadas con reportes y análisis operativos. El modelo relacional es robusto y presenta múltiples relaciones entre entidades, simulando un entorno financiero realista. Sin embargo, la documentación es limitada y los scripts de carga pueden presentar ciertas inconsistencias típicas de ambientes productivos.

Tu reto consiste en estudiar y optimizar las consultas proporcionadas, mejorando su rendimiento y claridad sin alterar el resultado lógico esperado. Deberás analizar la estructura del modelo (disponible en CreateDB.sql), revisar las consultas originales (QueryDB.sql) y proponer una versión optimizada en el archivo QueryOptDB.sql, justificando brevemente los cambios implementados.

Sugerencia: Puedes visualizar el modelo relacional en dbdiagram.io para facilitar tu análisis antes de abordar las consultas.
## Prerrequisitos
- Sistema operativo: Windows, macOS o Linux.

## Estructura del proyecto
```
challenge_9/
├── CreateDB.sql            # Script con la estructura del modelo relacional (MER)
├── InsertDB.sql            # Script con inserts simulados
├── QueryDB.sql             # Consultas originales (mal optimizadas)
├── QueryOptDB.sql          # Tu versión optimizada (archivo de entrega)
└── README.md

```

## Criterios de aceptación

- El archivo QueryOptDB.sql debe contener versiones optimizadas y comentadas de todas las consultas originales, garantizando que el código cuente con buenas prácticas de codificación de consultas en SQL para que no afecte su rendimiento y/o escalabilidad.
- Cada consulta debe mantener el resultado lógico esperado y su intención original.

### Criterios de aceptación técnicos
- Las nuevas consultas deben poderse ejecutar en un motor de base de datos SQL Server.
- El archivo de entrega debe estar comentado y organizado (usa comentarios -- para justificar cambios).
- No debe haber subconsultas correlacionadas innecesarias, funciones que impidan el uso de índices ni JOINs irrelevantes.
- Se valora el uso de GROUP BY, CTEs, funciones de ventana o técnicas modernas de SQL Server.
- Verifica y soluciona cualquier otra mala práctica en la codificación de las consultas que afecte su rendimiento y mantenibilidad.

## Instrucciones de implementación del ejercicio
1. Omite los pasos 1 a 3 si ya los ejecutaste. De lo contrario, clona el repositorio:
   https://github.com/SoftwareOne-Hackaton-Demo/swo-hackathon-template.git
2. Clona el repositorio asignado para tu equipo.
3. Copia y pega el contenido del repositorio https://github.com/SoftwareOne-Hackaton-Demo/swo-hackathon-template al repositorio asignado a tu equipo.
4. En la carpeta correspondiente al reto, revisa el archivo CreateDB.sql para analizar el modelo y las relaciones.
5. Estudia las consultas originales en QueryDB.sql y comprende su propósito.
6. Refactoriza y comenta tus versiones optimizadas en QueryOptDB.sql, incluyendo los casos de prueba.
7. Realiza commit y push de tus cambios.
8. Finalmente, en el aplicativo de hackathon, envía el ejercicio correspondiente a challenge 9 para su revisión.

## Observaciones
Se evaluará la claridad, justificación y eficiencia de las consultas optimizadas.

Puedes documentar cualquier ambigüedad o detalle relevante encontrado en el modelo o en las consultas originales.



## Recursos Útiles

Optimización de consultas SQL en SQL Server

dbdiagram.io para visualizar modelos relacionales

Use the Index, Luke!

DB Fiddle para SQL Server online