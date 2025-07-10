# Reto 14: Documentar API reserva de turnos

## Descripción
Una entidad requiere implementar una API REST en Java que permita gestionar reservas de turnos para atención presencial en oficinas físicas. Esta solución debe permitir a los usuarios:

- Crear turnos de atención.

- Consultar la disponibilidad por sede y servicio.

- Cancelar y reprogramar turnos existentes.

- Registrar la llegada del cliente a la oficina.

Actualmente, se necesita generar la documentación técnica detallada para esta futura API, como base para su posterior desarrollo. El objetivo de este reto es que los participantes diseñen y documenten esta API desde cero, siguiendo las buenas prácticas del estándar OpenAPI 3.0 (Swagger). La documentación será utilizada por otros equipos técnicos para su futura implementación y mantenimiento.


## Prerrequisitos
- Swagger / OpenAPI 3.0
- Editor compatible con YAML (VS Code)
- Conceptos básicos de diseño de APIs REST

## Criterios de aceptación

- La documentación debe estar en el repositorio o entregarse como archivo separado:
```
challenge_14
├── README.md
└── documentacion_api.yaml
```

- El archivo debe validar correctamente con herramientas como Swagger Editor.

- Debe presentarse de manera estructurada y profesional.

### Criterios de aceptación técnicos
- Los endpoints que deben ser documentados: 
    - Creación de turnos
    - Consultar disponibilidad
    - Cancelar turno
    - Reprogramar turno
    - Registrar llegada del cliente

- La documentación de los endpoints debe incluir:
    - Descripción de la operación.
    - Parámetros (query, path, body) con sus tipos y ejemplos.
    - Ejemplo de request y response con estructura JSON.
    - Códigos de respuesta HTTP esperados (200, 400, 404, 500).

- La documentación debe incluir el esquema de autenticación apikey.
- El archivo debe cumplir con el estándar OpenAPI 3.0 sin errores de validación.

## Observaciones

- Es fundamental definir claramente los ejemplos de request y response para cada endpoint, ya que esto facilita la implementación y las pruebas por parte de los desarrolladores.
- Validar el archivo YAML en Swagger Editor antes de entregarlo ayuda a evitar errores de sintaxis y asegurar la compatibilidad con herramientas de documentación y generación de código.

## Recursos Útiles

- [Swagger Editor (Online)](https://editor.swagger.io/) – Herramienta interactiva para crear, visualizar y validar especificaciones OpenAPI 3.0.
- [OpenAPI Specification 3.0 Documentation](https://swagger.io/specification/) – Documentación oficial y ejemplos para estructurar correctamente el archivo YAML.
