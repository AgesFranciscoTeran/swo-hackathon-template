
# hackaton-challenge-4

## Descripción

Debes crear una aplicación sencilla en Node.js que procese información de empleados almacenada en un archivo empleados.json. El programa debe filtrar empleados activos del departamento IT, agruparlos por ciudad y mostrar la información en consola. El objetivo es practicar el manejo de archivos JSON, filtrado y agrupación de datos en memoria usando JavaScript.

## Prerequisitos

- Node.js y npm instalados en tu sistema.
- Sistema operativo: Windows, macOS o Linux.

## Estructura del Proyecto

```
challenge_4/
├── INDEX.js
├── empleados.json
├── package.json
└── ...
```

### Criterios de aceptación funcionales

1. El programa debe leer el archivo empleados.json ubicado en la raíz del proyecto.
2. El archivo principal debe llamarse `INDEX.js` y estar en la raíz de la carpeta.
3. Si el archivo no existe, debe mostrar exactamente:
   - `No se encontró el archivo empleados.json`
4. Si el archivo existe pero el contenido no es un JSON válido, debe mostrar exactamente:
   - `Error al parsear JSON`
5. Debe filtrar empleados cuyo campo `activo` sea `true` y `departamento` sea exactamente "IT".
6. Los empleados filtrados deben agruparse por ciudad y mostrarse en consola siguiendo el formato especificado.
7. Si no hay empleados que cumplan los criterios, no debe mostrar ninguna ciudad ni empleado.
8. El código debe estar en la carpeta `challenge_4` y ejecutarse correctamente con Node.js.

**Criterios de Aceptación Técnicos:**
- El programa debe estar implementado en Node.js usando JavaScript.
- El código fuente debe estar en el repositorio GitHub suministrado en una carpeta con nombre _challenge_4_.
- El archivo principal debe llamarse `INDEX.js` y estar en la raíz de la carpeta.
- El archivo empleados.json debe estar presente en la raíz del proyecto.
- El archivo package.json debe incluir el script "start" para ejecutar el programa con `npm start`.
- El código fuente debe ejecutarse correctamente y cumplir todos los criterios de aceptación funcionales.

### Ejemplo de Ejecución

Ejecuta la aplicación desde la terminal, dentro de la carpeta del proyecto:

```sh
npm install
npm start
```

### Instrucciones de implementación del ejercicio

1. Clona la carpeta correspondiente a challenge_4 desde el repositorio:
   https://github.com/SoftwareOne-Hackaton-Demo/swo-hackathon-template/tree/main
2. Crea el archivo empleados.json en la raíz del proyecto con la estructura y datos de ejemplo proporcionados.
3. Implementa la lógica para leer, filtrar y agrupar los empleados según los criterios funcionales en el archivo `INDEX.js`.
4. Asegúrate de cumplir con los criterios funcionales y técnicos descritos arriba.
5. Una vez finalizado, guarda los cambios y realiza commit y push de tu solución usando los siguientes comandos dentro de la carpeta `challenge_4`:
   ```sh
   git add .
   git commit -m "Solución challenge 4"
   git push
   ```
6. Finalmente, en el aplicativo de hackaton, envía el ejercicio correspondiente a challenge 4 para su revisión.

### Notas importantes
- El archivo empleados.json debe estar correctamente formado y en la raíz del proyecto.
- Todos los datos deben procesarse en memoria, sin uso de bases de datos ni almacenamiento externo.
- La solución debe ejecutarse únicamente por consola, sin requerir interfaz gráfica ni servicios web.
- El código fuente debe ejecutarse correctamente y cumplir todos los criterios funcionales y técnicos.

### Observación
Se debe validar que la salida cumpla exactamente con el formato especificado y que los errores se muestren según lo solicitado.

### Recursos útiles
- [Documentación oficial de Node.js](https://nodejs.org/es/docs/)
- [Guía de estilo de JavaScript](https://developer.mozilla.org/es/docs/Web/JavaScript/Guide)
- [Introducción a JSON](https://www.json.org/json-es.html)
- [Manejo de archivos en Node.js](https://nodejs.dev/learn/leer-y-escribir-archivos-json-en-nodejs)
- [Curso básico de Node.js](https://www.freecodecamp.org/learn/back-end-development-and-apis/introduction-to-nodejs)

#### JSON 

```json
[
  { "id": 1, "nombre": "Ana Torres", "edad": 30, "ciudad": "Bogotá", "departamento": "IT", "activo": true },
  { "id": 2, "nombre": "Luis Ramírez", "edad": 22, "ciudad": "Medellín", "departamento": "Ventas", "activo": true },
  { "id": 3, "nombre": "Carla Gómez", "edad": 27, "ciudad": "Bogotá", "departamento": "Marketing", "activo": false },
  { "id": 4, "nombre": "Pedro Ríos", "edad": 40, "ciudad": "Cali", "departamento": "IT", "activo": true },
  { "id": 5, "nombre": "Laura Sánchez", "edad": 35, "ciudad": "Medellín", "departamento": "IT", "activo": true },
  { "id": 6, "nombre": "Mario Pérez", "edad": 45, "ciudad": "Cali", "departamento": "Finanzas", "activo": true },
  { "id": 7, "nombre": "Lucía Herrera", "edad": 29, "ciudad": "Bogotá", "departamento": "IT", "activo": false },
  { "id": 8, "nombre": "Javier Molina", "edad": 32, "ciudad": "Barranquilla", "departamento": "IT", "activo": true },
  { "id": 9, "nombre": "Sofía Castro", "edad": 26, "ciudad": "Bogotá", "departamento": "Recursos Humanos", "activo": true },
  { "id": 10, "nombre": "Andrés Peña", "edad": 38, "ciudad": "Cali", "departamento": "IT", "activo": false }
]
```

