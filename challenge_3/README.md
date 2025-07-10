
# Reto 3: API Gestión de Tareas

## Descripción

Debes crear una aplicación backend sencilla en C# utilizando ASP.NET Core Web API para gestionar una lista de tareas. La API debe exponer endpoints REST para crear, listar, completar y eliminar tareas, almacenando los datos en memoria (no persistente). El objetivo es practicar el diseño de servicios REST y la validación de datos usando pruebas con Postman.

## Prerrequisitos

- [.NET SDK 8.0](https://versionsof.net/core/8.0/)
- Sistema operativo: Windows, macOS o Linux
- Postman para pruebas de la API

## Estructura del Proyecto

```
challenge_3/
├── Controllers/
│   └── TareasController.cs
├── Models/
│   └── Tarea.cs
├── Properties/
│   └── launchSettings.json
├── Program.cs
├── TareasApi.csproj
├── README.md
└── ...
```

## Criterios de aceptación

1. La API debe exponer los siguientes endpoints:
   - `GET /tareas`: Listar todas las tareas.
   - `POST /tareas`: Crear una nueva tarea.
   - `PUT /tareas/{id}/completar`: Marcar una tarea como completada.
   - `DELETE /tareas/{id}`: Eliminar una tarea por su ID.
2. El almacenamiento de tareas debe ser en memoria (no persistente).
3. Todas las respuestas deben tener formato JSON y usar los códigos de estado HTTP estándar.
4. El modelo de tarea debe incluir: id, título, descripción, completada (bool).
5. El código debe estar en la carpeta `challenge_3` y compilar correctamente.

### Criterios de Aceptación Técnicos
- El programa debe estar implementado en C# con ASP.NET Core Web API.
- El código fuente debe estar en el repositorio GitHub suministrado en una carpeta con nombre _challenge_3_.
- El archivo principal debe llamarse `Program.cs` y estar en la raíz de la carpeta.
- La API debe ejecutarse en HTTP (no HTTPS) y en el puerto 5000.
- El código fuente debe ejecutarse correctamente y cumplir todos los criterios de aceptación funcionales.

### Ejemplo de Ejecución

Ejecuta la aplicación desde la terminal, dentro de la carpeta del proyecto:

```sh
dotnet restore
dotnet build
dotnet run
```

La API debe estar disponible en:

```
http://localhost:5000
```

## Instrucciones de implementación del ejercicio

1. Omite los pasos 1 a 3 si ya los ejecutaste. De lo contrario, clona el repositorio:
   https://github.com/SoftwareOne-Hackaton-Demo/swo-hackathon-template.git
2. Clona el repositorio asignado para tu equipo.
3. Copia y pega el contenido del repositorio https://github.com/SoftwareOne-Hackaton-Demo/swo-hackathon-template al repositorio asignado a tu equipo.
4. En la carpeta correspondiente al reto, implementa los endpoints y la lógica de almacenamiento en memoria según los criterios funcionales.
5. Asegúrate de que la API use el puerto 5000 por HTTP.
6. Prueba todos los endpoints usando Postman.
7. Asegúrate de cumplir con los criterios funcionales y técnicos descritos arriba.
8. Una vez finalizado, guarda los cambios y realiza commit y push de tu solución.
9. Finalmente, en el aplicativo de hackathon, envía el ejercicio correspondiente a challenge 3 para su revisión.

## Notas importantes
- El almacenamiento de tareas es en memoria (no persistente).
- La API debe ejecutarse únicamente en HTTP (no HTTPS) y en el puerto 5000.
- Se sugiere realizar las pruebas usando Postman.
- El código fuente debe compilar y cumplir todos los criterios funcionales y técnicos.

## Observaciones
- Se debe validar que los endpoints respondan correctamente y que la estructura de la respuesta sea la esperada.

## Recurso útil
- [Documentación oficial de ASP.NET Core](https://learn.microsoft.com/es-es/aspnet/core/?view=aspnetcore-7.0)
