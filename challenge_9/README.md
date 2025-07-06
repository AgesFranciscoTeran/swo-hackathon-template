# Reto 9: Optimización Consultas SQL

##  Descripción
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

El archivo QueryOptDB.sql debe contener versiones optimizadas y comentadas de todas las consultas originales.

Cada consulta debe mantener el resultado lógico esperado y su intención original.

### Criterios de aceptación técnicos
El archivo de entrega debe estar comentado y organizado (usa comentarios -- para justificar cambios).

No debe haber subconsultas correlacionadas innecesarias, funciones que impidan el uso de índices ni JOINs irrelevantes.

Se valora el uso de GROUP BY, CTEs, funciones de ventana o técnicas modernas de SQL Server.

## Instrucciones de implementación del ejercicio
Clona el repositorio del hackathon:

git clone <URL_DEL_REPOSITORIO>
cd challenge_9

Revisa el archivo CreateDB.sql para analizar el modelo y las relaciones.

Estudia las consultas originales en QueryDB.sql y comprende su propósito.

Refactoriza y comenta tus versiones optimizadas en QueryOptDB.sql, incluyendo los casos de prueba.

Realiza commit de tus cambios:

git add QueryOptDB.sql
git commit -m "Optimización y documentación de consultas SQL"
git push

Sube tu solución final siguiendo las instrucciones del hackathon.




## Observaciones
Se evaluará la claridad, justificación y eficiencia de las consultas optimizadas.

Puedes documentar cualquier ambigüedad o detalle relevante encontrado en el modelo o en las consultas originales.

## Recursos Útiles

Optimización de consultas SQL en SQL Server

dbdiagram.io para visualizar modelos relacionales

Use the Index, Luke!

DB Fiddle para SQL Server online