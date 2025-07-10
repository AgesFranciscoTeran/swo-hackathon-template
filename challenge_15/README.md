# Reto 15: Swagger API Consulta de Productos

## Descripción
Cuentas con una API para la consulta avanzada de un catálogo de productos, desarrollada por un becario en Java puro (sin frameworks como Spring Boot) y ubicada en la carpeta `src/main/java/com/ejemplo/catalogo/`.

Sin embargo, esta API no cuenta con documentación técnica ni funcional. Por lo tanto, tu reto consiste en analizar el código fuente existente y generar la documentación completa de la API utilizando Swagger/OpenAPI. El objetivo es que cualquier persona o equipo pueda comprender, consumir e integrar la API fácilmente a partir de la especificación generada, sin necesidad de revisar el código Java.

No es necesario implementar ni compilar la lógica en Java: solo debes entregar el archivo `openapi.yaml` correctamente documentado y validado.

## Prerrequisitos
- Java 21 instalado y configurado en el PATH.

- Apache Maven o Gradle (recomendado para build y dependencias).

- Conocimientos básicos de Java, Servlets, REST y OpenAPI.

- Editor de código o IDE (IntelliJ, Eclipse, VSCode, etc.).

## Estructura del proyecto
```
challenge-15/
├── src/
│   └── main/
│       └── java/
│           └── com/
│               └── ejemplo/
│                   └── catalogo/
│                       ├── controller/
│                       │    └── ProductoController.java
│                       ├── dto/
│                       │    ├── ProductoRequest.java
│                       │    └── ProductoResponse.java
│                       ├── model/
│                       │    ├── Categoria.java
│                       │    └── Producto.java
│                       ├── service/
│                       │    └── ProductoService.java
│                       ├── util/
│                       │    └── JsonUtil.java
│                       └── CatalogoApplication.java
├── pom.xml
├── openapi.yaml  -- este archivo es el que debes generar
├── README.md
└── ...

```

## Criterios de aceptación

### Funcionales
- El archivo `openapi.yaml` debe documentar exhaustivamente todos los endpoints disponibles en la API entregada,incluyendo:

  - Debe documentar exhaustivamente todos los endpoints definidos en la API propuesta, incluyendo:
  - Método HTTP y ruta de cada endpoint.
  - Descripción clara de la operación.
  - Parámetros de entrada (query, path, body) con tipos, restricciones y ejemplos.
  - Modelos de datos (request y response), incluyendo objetos anidados, atributos, tipos y restricciones.
  - Códigos de respuesta HTTP esperados (200, 400, 404, 500) y sus descripciones.
  - Ejemplos válidos de request y response para al menos dos endpoints principales.
  - Parámetros de filtros y paginación definidos y descritos en los endpoints correspondientes.
  - Restricciones y validaciones reflejadas en la especificación (campos requeridos, valores mínimos/máximos, longitudes, etc.).

- Cada endpoint debe incluir el método HTTP, la ruta, descripción, parámetros de entrada y posibles códigos de respuesta.
- Los parámetros de filtros y paginación deben estar definidos y descritos claramente en cada endpoint correspondiente.
- Los modelos de datos (request y response), incluyendo los objetos anidados, deben estar completamente especificados con sus atributos, tipos y restricciones.
- Las validaciones presentes en la API (como restricciones de longitud, valores numéricos mínimos, campos obligatorios, etc.) deben reflejarse en la especificación.
- La documentación debe incluir al menos un ejemplo de solicitud y uno de respuesta para cada endpoint principal.

### Técnicos
- El archivo `openapi.yaml` debe estar en formato OpenAPI 3.0 y contener sintaxis YAML válida.
- La especificación debe cubrir la totalidad de la API provista, sin omitir endpoints, parámetros o modelos utilizados por el sistema.
- Todos los modelos, parámetros y respuestas deben coincidir con los definidos en el código de la API entregada.
- El archivo debe poder abrirse sin errores en Swagger Editor o Swagger UI.
- El archivo `openapi.yaml` debe estar ubicado en la raíz del proyecto y ser el único entregable requerido por el participante.
- Deben incluirse ejemplos de request y response válidos en al menos dos endpoints de la especificación.
- Los parámetros y modelos deben incluir, cuando corresponda, las restricciones y validaciones implementadas en el código (ej: campos requeridos, valores mínimos/máximos).

## Instrucciones de implementación del ejercicio
1. Si ya tienes el repositorio base, omite los pasos 1 a 3. Si no, clona el repositorio:
https://github.com/SoftwareOne-Hackaton-Demo/swo-hackathon-template.git

2. Clona el repositorio asignado para tu equipo.

3. Copia y pega el contenido del repositorio https://github.com/SoftwareOne-Hackaton-Demo/swo-hackathon-template al repositorio asignado a tu equipo.

4. Implementa la solución siguiendo la estructura y requisitos descritos arriba.

5. Sube los archivos de validación y la estructura del proyecto al repositorio de tu equipo.


## Observaciones
- No es necesario implementar ni compilar la lógica en Java, solo entregar el archivo `openapi.yaml` correctamente documentado.
- Valida tu archivo `openapi.yaml` en Swagger Editor para asegurar que no tenga errores de sintaxis ni advertencias.
- Asegúrate de que todos los endpoints, parámetros, modelos y ejemplos reflejen fielmente la API propuesta.
- Incluye restricciones y validaciones en los modelos (campos requeridos, longitudes, valores mínimos/máximos) según lo que se espera en la API.
- Utiliza ejemplos claros y realistas en los request y response para facilitar la comprensión de los consumidores de la API.
- El archivo `openapi.yaml` debe estar en la raíz del proyecto y ser el único entregable.
- Si tienes dudas sobre la estructura, consulta la documentación oficial de OpenAPI o revisa ejemplos en Swagger Editor.

## Recursos Útiles

- [Swagger Editor (Online)](https://editor.swagger.io/) – Para crear, validar y visualizar tu archivo openapi.yaml.
- [OpenAPI Specification 3.0 Documentation](https://swagger.io/specification/) – Referencia oficial para estructurar tu especificación OpenAPI.
