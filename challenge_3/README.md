
# Reto 3: API de gestion de tareas

## Descripción:

Desarrollar una aplicación backend que permita gestionar una lista de tareas a través de una API Rest. Esta solución busca reforzar conceptos clave de desarrollo de servicios REST, como el diseño de endpoints, manejo de datos en memoria, y pruebas usando herramientas como Postman.

El objetivo no es construir una solución completa con base de datos ni interfaz gráfica, sino enfocarse en la lógica de negocio y en cómo se expone a través de una API REST básica.

## Categoría: Construcción Código Nuevo

## Prerequisitos:
- Git [Git - Downloads](https://git-scm.com/downloads)
- .NET 8 [Channel 8.0 - .NET Core - Versions of .NET](https://versionsof.net/core/8.0/)
- (Opcional) [Postman API Platform](https://www.postman.com/)

## Criterios de Aceptación Funcionales

### Crear una nueva tarea
* Debe existir un endpoint **POST {{baseUrl}}/tareas** para la creación de una nueva tarea mediante el envío de un objeto json en el body con la siguiente estructura: 
````
{
   "titulo": "<Titulo de la tarea a crear>",
   "descripcion": "<Descripcion de la tarea a crear>"
}
````
* En la petición del método **POST {{baseUrl}}/tareas**, el campo "titulo" es obligatorio y no debe estar vacío. Si el campo se encuentra vacío, se debera generar la siguiente respuesta: 

````
HTTP/1.1 400 Bad Request
Content-Type: application/json

{   
   "error": "El titulo es obligatorio." 
}
````
* Cuando una petición al método **POST {{baseUrl}}/tareas** es exitosa, debe responder:

````
201 Created
Content-Type: application/json

{   
   "id": <número entero generado automáticamente>,
   "titulo": "<Titulo de la tarea a creada>",
   "descripcion": "<Descripcion de la tarea a creada>",
   "completada": <true o false>
}
````
### Listar Todas las Tareas

* Debe existir un segundo método que permita la consulta de todas las tareas existentes mediante el endpoint **GET {{baseUrl}}/tareas**. La respuesta debe ser un arreglo en formato JSON que incluya, por cada tarea, los siguientes campos: id,  titulo, descripcion y completada. Esta debe ser su estructura:

````
200 OK 
Content-Type: application/json

[{   
   "id": <número entero generado automáticamente>,
   "titulo": "<Titulo de la tarea a creada>",
   "descripcion": "<Descripcion de la tarea a creada>",
   "completada": <true o false>
}]
````

### Marcar una tarea como completada

* Adicionalmente la API debe tener un método que permita marcar una tarea como completada utilizando el endpoint **PUT {{baseUrl}}/tareas/{id}**. Este método debe validar si la tarea existe o no a partir de su "id". Si la tarea existe, debe marcarla como completada en true y responder lo siguiente:

````
204 No Content
````

* Si en la ejecución del método **PUT {{baseUrl}}/tareas/{id}** se identifica que el "id" no existe, debe dar la siguiente respuesta:

````
404 Not Found
Content-Type: application/json

{
  "error": "Tarea no encontrada."
}
````
### Eliminar Tarea
* Debe exisitir un método en la API que permita eliminar una tarea específica utilizando el endpoint "DELETE {{baseUrl}}/tareas/{id}". Este método debe validar si la tarea existe o no a partir de su "id". Si la tarea existe, debe eliminar el recurso y responder lo siguiente:

````
204 No Content
````

* Si en la ejecución del método **DELETE {{baseUrl}}/tareas/{id}** se identifica que el "id" no existe, debe dar la siguiente respuesta:

````
404 Not Found
Content-Type: application/json

{
  "error": "Tarea no encontrada."
}
````

## Criterios de Aceptación Técnicos:
*   La solución debe estar implementada en **C#** utilizando **ASP.NET Core Web API** con el SDK 8.0.
*   La solución debe estar almacenada en el repositorio de GitHub suministrado, en una carpeta con nombre `challenge-3`.
*   La solución debe llamarse "TareasApi.sln" y estar ubicado en la raíz de la carpeta previamente mencionada. Adicionalmente debe contener un proyecto llamado TareasAPI (TareasApi/TareasApi.csproj), con la implementación correspondiente. Este proyecto debe ser el startup de la solución implementada.
*   El proyecto debe ser compilable y ejecutable utilizando los comandos estándar de .NET: dotnet restore, dotnet build y dotnet run
*   La API debe ejecutarse en **modo desarrollo (dev)** exclusivamente sobre **HTTP (no HTTPS)**, con la verificación de certificados SSL deshabilitada.
*   El archivo "launchSettings.json" debe estar configurado para exponer la API en el puerto **5000**, mediante protocolo **HTTP**.    
*   La solución debe compilarse sin errores y ejecutarse correctamente en entorno local.
*   La API debe cumplir satisfactoriamente con todos los criterios de aceptación funcionales definidos.

## Ejemplo de ejecución:

### Crear una nueva tarea

Comando Ejecutado

````
curl -X POST http://localhost:5000/tareas \
  -H "Content-Type: application/json" \
  -d '{
    "titulo": "Comprar leche",
    "descripcion": "Ir al supermercado"
  }'
````

Respuesta esperada

````
`HTTP/1.1 201 Created
Content-Type: application/json

{
  "id": 1,
  "titulo": "Comprar leche",
  "descripcion": "Ir al supermercado",
  "completada": false
}`
````
### Listar todas las tareas

Comando Ejecutado

`curl http://localhost:5000/tareas`

Respuesta esperada

````
HTTP/1.1 200 OK
Content-Type: application/json

[
  {
    "id": 1,
    "titulo": "Comprar leche",
    "descripcion": "Ir al supermercado",
    "completada": false
  }
]`
````

### Marcar una tarea como completada

Comando Ejecutado

````
curl -X PATCH http://localhost:5000/tareas/1 \
  -H "Content-Type: application/json" \
  -d '{
    "completada": true
  }'
````

Respuesta esperada

`HTTP/1.1 204 No Content`

### Eliminar una tarea

Comando Ejecutado

`curl -X DELETE http://localhost:5000/tareas/1`

Respuesta esperada

`HTTP/1.1 204 No Content`

## Casos de Prueba

### 1. POST /tareas - Crear una nueva tarea exitosamente

**Descripción:** Verificar que se puede crear una nueva tarea con título y descripción válidos.

**Precondiciones:** 
- La API está ejecutándose en http://localhost:5000
- No existen tareas previamente creadas

**Pasos:**
1. Enviar petición POST a http://localhost:5000/tareas
2. Incluir en el body: `{"titulo": "Comprar pan", "descripcion": "Ir a la panadería de la esquina"}`
3. Establecer header Content-Type: application/json

**Resultado esperado:**
- Código de respuesta: 201 Created
- Content-Type: application/json
- Body de respuesta: 
```json
{
  "id": 1,
  "titulo": "Comprar pan",
  "descripcion": "Ir a la panadería de la esquina",
  "completada": false
}
```

### 2. POST /tareas - Error por título vacío

**Descripción:** Verificar que la API rechaza la creación de una tarea cuando el título está vacío.

**Precondiciones:** 
- La API está ejecutándose en http://localhost:5000

**Pasos:**
1. Enviar petición POST a http://localhost:5000/tareas
2. Incluir en el body: `{"titulo": "", "descripcion": "Descripción válida"}`
3. Establecer header Content-Type: application/json

**Resultado esperado:**
- Código de respuesta: 400 Bad Request
- Content-Type: application/json
- Body de respuesta: 
```json
{
  "error": "El titulo es obligatorio."
}
```

### 3. POST /tareas - Error por título faltante

**Descripción:** Verificar que la API rechaza la creación de una tarea cuando el título no está presente.

**Precondiciones:** 
- La API está ejecutándose en http://localhost:5000

**Pasos:**
1. Enviar petición POST a http://localhost:5000/tareas
2. Incluir en el body: `{"descripcion": "Descripción sin título"}`
3. Establecer header Content-Type: application/json

**Resultado esperado:**
- Código de respuesta: 400 Bad Request
- Content-Type: application/json
- Body de respuesta: 
```json
{
  "error": "El titulo es obligatorio."
}
```

### 4. POST /tareas - Crear tarea solo con título

**Descripción:** Verificar que se puede crear una tarea proporcionando solo el título (descripción opcional).

**Precondiciones:** 
- La API está ejecutándose en http://localhost:5000

**Pasos:**
1. Enviar petición POST a http://localhost:5000/tareas
2. Incluir en el body: `{"titulo": "Hacer ejercicio"}`
3. Establecer header Content-Type: application/json

**Resultado esperado:**
- Código de respuesta: 201 Created
- Content-Type: application/json
- Body de respuesta: 
```json
{
  "id": 2,
  "titulo": "Hacer ejercicio",
  "descripcion": null,
  "completada": false
}
```

### 5. GET /tareas - Listar tareas vacías

**Descripción:** Verificar que la API retorna una lista vacía cuando no existen tareas.

**Precondiciones:** 
- La API está ejecutándose en http://localhost:5000
- No existen tareas creadas

**Pasos:**
1. Enviar petición GET a http://localhost:5000/tareas

**Resultado esperado:**
- Código de respuesta: 200 OK
- Content-Type: application/json
- Body de respuesta: `[]`

### 6. GET /tareas - Listar todas las tareas

**Descripción:** Verificar que la API retorna todas las tareas existentes.

**Precondiciones:** 
- La API está ejecutándose en http://localhost:5000
- Existen 2 tareas creadas previamente

**Pasos:**
1. Crear tarea 1: POST /tareas con `{"titulo": "Tarea 1", "descripcion": "Primera tarea"}`
2. Crear tarea 2: POST /tareas con `{"titulo": "Tarea 2", "descripcion": "Segunda tarea"}`
3. Enviar petición GET a http://localhost:5000/tareas

**Resultado esperado:**
- Código de respuesta: 200 OK
- Content-Type: application/json
- Body de respuesta: 
```json
[
  {
    "id": 1,
    "titulo": "Tarea 1",
    "descripcion": "Primera tarea",
    "completada": false
  },
  {
    "id": 2,
    "titulo": "Tarea 2",
    "descripcion": "Segunda tarea",
    "completada": false
  }
]
```

### 7. PUT /tareas/{id} - Marcar tarea como completada exitosamente

**Descripción:** Verificar que se puede marcar una tarea existente como completada.

**Precondiciones:** 
- La API está ejecutándose en http://localhost:5000
- Existe una tarea con id = 1

**Pasos:**
1. Crear una tarea: POST /tareas con `{"titulo": "Tarea a completar", "descripcion": "Descripción"}`
2. Enviar petición PUT a http://localhost:5000/tareas/1

**Resultado esperado:**
- Código de respuesta: 204 No Content
- Sin contenido en el body

### 8. PUT /tareas/{id} - Error tarea no encontrada

**Descripción:** Verificar que la API retorna error 404 cuando se intenta marcar como completada una tarea que no existe.

**Precondiciones:** 
- La API está ejecutándose en http://localhost:5000
- No existe una tarea con id = 999

**Pasos:**
1. Enviar petición PUT a http://localhost:5000/tareas/999

**Resultado esperado:**
- Código de respuesta: 404 Not Found
- Content-Type: application/json
- Body de respuesta: 
```json
{
  "error": "Tarea no encontrada."
}
```

### 9. DELETE /tareas/{id} - Eliminar tarea exitosamente

**Descripción:** Verificar que se puede eliminar una tarea existente.

**Precondiciones:** 
- La API está ejecutándose en http://localhost:5000
- Existe una tarea con id = 1

**Pasos:**
1. Crear una tarea: POST /tareas con `{"titulo": "Tarea a eliminar", "descripcion": "Para eliminar"}`
2. Enviar petición DELETE a http://localhost:5000/tareas/1
3. Verificar con GET /tareas que la tarea ya no existe

**Resultado esperado:**
- Código de respuesta: 204 No Content
- Sin contenido en el body
- La tarea no debe aparecer en GET /tareas

### 10. DELETE /tareas/{id} - Error tarea no encontrada

**Descripción:** Verificar que la API retorna error 404 cuando se intenta eliminar una tarea que no existe.

**Precondiciones:** 
- La API está ejecutándose en http://localhost:5000
- No existe una tarea con id = 999

**Pasos:**
1. Enviar petición DELETE a http://localhost:5000/tareas/999

**Resultado esperado:**
- Código de respuesta: 404 Not Found
- Content-Type: application/json
- Body de respuesta: 
```json
{
  "error": "Tarea no encontrada."
}
```

### 11. Flujo completo - CRUD de tareas

**Descripción:** Verificar el flujo completo de operaciones CRUD en el orden correcto.

**Precondiciones:** 
- La API está ejecutándose en http://localhost:5000
- No existen tareas previas

**Pasos:**
1. GET /tareas - Verificar lista vacía
2. POST /tareas - Crear tarea 1: `{"titulo": "Tarea 1", "descripcion": "Primera"}`
3. POST /tareas - Crear tarea 2: `{"titulo": "Tarea 2", "descripcion": "Segunda"}`
4. GET /tareas - Verificar que existen 2 tareas
5. PUT /tareas/1 - Marcar tarea 1 como completada
6. GET /tareas - Verificar que tarea 1 está completada
7. DELETE /tareas/2 - Eliminar tarea 2
8. GET /tareas - Verificar que solo existe tarea 1 completada

**Resultado esperado:**
- Todas las operaciones deben ejecutarse exitosamente
- Los estados intermedios deben ser consistentes
- Al final debe quedar solo la tarea 1 marcada como completada

### 12. Validación de auto-incremento de IDs

**Descripción:** Verificar que los IDs se generan automáticamente y son únicos e incrementales.

**Precondiciones:** 
- La API está ejecutándose en http://localhost:5000
- No existen tareas previas

**Pasos:**
1. POST /tareas - Crear tarea: `{"titulo": "Tarea A"}`
2. POST /tareas - Crear tarea: `{"titulo": "Tarea B"}`
3. POST /tareas - Crear tarea: `{"titulo": "Tarea C"}`
4. GET /tareas - Verificar los IDs asignados

**Resultado esperado:**
- Primera tarea debe tener id = 1
- Segunda tarea debe tener id = 2
- Tercera tarea debe tener id = 3
- Los IDs deben ser únicos y secuenciales

**Estructura del proyecto:** 

challenge_3/
├── Controllers/
│   └── TareasController.cs
├── Models/
│   └── Tarea.cs
├── Properties/
│   └── launchSettings.json
├── Program.cs
├── TareasApi.csproj
├── TareasApi.sln
└── README.md

**Solucion:** 
[Tarea.cs](/.attachments/Tarea-d04f0b66-9ade-4893-95a2-ac0b750586a6.cs)_



