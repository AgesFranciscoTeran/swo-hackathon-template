
# Reto 4: Procesar texto en JSON

## Descripcion

Debes crear una aplicacion sencilla en Node.js que procese informacion de empleados almacenada en un archivo empleados.json. El programa debe filtrar empleados activos del departamento IT, agruparlos por ciudad y mostrar la informacion en consola. El objetivo es practicar el manejo de archivos JSON, filtrado y agrupacion de datos en memoria usando JavaScript.

## Prerrequisitos

- [Node.js v22](https://nodejs.org/en/download)
- [npm](https://docs.npmjs.com/downloading-and-installing-node-js-and-npm)
- Sistema operativo: Windows, macOS o Linux.

## Estructura del Proyecto

```
challenge_4/
├── Index.js
├── empleados.json
├── package.json
└── ...
```

## Criterios de aceptacion

1. El programa debe leer el archivo empleados.json ubicado en la raiz del proyecto.
2. El archivo principal debe llamarse `index.js` y estar en la raiz de la carpeta.
3. Si el archivo no existe, debe mostrar exactamente:
   - `No se encontro el archivo empleados.json`
4. Si el archivo existe pero el contenido no es un JSON valido, debe mostrar exactamente:
   - `Error al parsear JSON`
5. Debe filtrar empleados cuyo campo `activo` sea `true` y `departamento` sea exactamente "IT".
6. Los empleados filtrados deben agruparse por ciudad y mostrarse en consola siguiendo el formato especificado.
7. Si no hay empleados que cumplan los criterios, no debe mostrar ninguna ciudad ni empleado.
8. El codigo debe estar en la carpeta `challenge_4` y ejecutarse correctamente con Node.js.

### Criterios de Aceptacion Tecnicos
- El programa debe estar implementado en Node.js usando JavaScript.
- El codigo fuente debe estar en el repositorio GitHub suministrado en una carpeta con nombre _challenge_4_.
- El archivo principal debe llamarse `index.js` y estar en la raiz de la carpeta.
- El archivo empleados.json debe estar presente en la raiz del proyecto.
- El archivo package.json debe incluir el script "start" para ejecutar el programa con `npm start`.
- El codigo fuente debe ejecutarse correctamente y cumplir todos los criterios de aceptacion funcionales.

### Ejemplo de Ejecucion

Ejecuta la aplicacion desde la terminal, dentro de la carpeta del proyecto:

```sh
npm install
npm start
```
## Output referencial
```
Ciudad: Bogota
Empleados Marketing activos:
- Luis Acevedo (55 anos)
- Jeniffer Bastos (34 anos)

Ciudad: Cali
Empleados Marketing activos:
- Pablo Miranda (40 anos)

```

## Instrucciones de implementacion del ejercicio

1. Omite los pasos 1 a 3 si ya los ejecutaste. De lo contrario, clona el repositorio:
   https://github.com/SoftwareOne-Hackaton-Demo/swo-hackathon-template.git
2. Clona el repositorio asignado para tu equipo.
3. Copia y pega el contenido del repositorio https://github.com/SoftwareOne-Hackaton-Demo/swo-hackathon-template al repositorio asignado a tu equipo.
4. En la carpeta correspondiente al reto, crea el archivo empleados.json en la raiz del proyecto con la estructura y datos de ejemplo proporcionados.
5. Implementa la logica para leer, filtrar y agrupar los empleados según los criterios funcionales en el archivo `index.js`.
6. Asegúrate de cumplir con los criterios funcionales y tecnicos descritos arriba.
7. Una vez finalizado, guarda los cambios y realiza commit y push de tu solucion.
8. Finalmente, en el aplicativo de hackathon, envia el ejercicio correspondiente a challenge 4 para su revision.

## Notas importantes
- El archivo empleados.json debe estar correctamente formado y en la raiz del proyecto.
- Todos los datos deben procesarse en memoria, sin uso de bases de datos ni almacenamiento externo.
- La solucion debe ejecutarse únicamente por consola, sin requerir interfaz grafica ni servicios web.
- El codigo fuente debe ejecutarse correctamente y cumplir todos los criterios funcionales y tecnicos.

## Observaciones
- Se debe validar que la salida cumpla exactamente con el formato especificado y que los errores se muestren según lo solicitado.

## Recursos Útiles
- [Documentacion oficial de Node.js](https://nodejs.org/es/docs/)
- [Guia de estilo de JavaScript](https://developer.mozilla.org/es/docs/Web/JavaScript/Guide)
- [Introduccion a JSON](https://www.json.org/json-es.html)
- [Manejo de archivos en Node.js](https://nodejs.dev/learn/leer-y-escribir-archivos-json-en-nodejs)
- [Curso basico de Node.js](https://www.freecodecamp.org/learn/back-end-development-and-apis/introduction-to-nodejs)

### Datos de Ejemplo para empleados.json

```json
[
  { "id": 1, "nombre": "Ana Torres", "edad": 30, "ciudad": "Bogota", "departamento": "IT", "activo": true },
  { "id": 2, "nombre": "Luis Ramirez", "edad": 22, "ciudad": "Medellin", "departamento": "Ventas", "activo": true },
  { "id": 3, "nombre": "Carla Gomez", "edad": 27, "ciudad": "Bogota", "departamento": "Marketing", "activo": false },
  { "id": 4, "nombre": "Pedro Rios", "edad": 40, "ciudad": "Cali", "departamento": "IT", "activo": true },
  { "id": 5, "nombre": "Laura Sanchez", "edad": 35, "ciudad": "Medellin", "departamento": "IT", "activo": true },
  { "id": 6, "nombre": "Mario Perez", "edad": 45, "ciudad": "Cali", "departamento": "Finanzas", "activo": true },
  { "id": 7, "nombre": "Lucia Herrera", "edad": 29, "ciudad": "Bogota", "departamento": "IT", "activo": false },
  { "id": 8, "nombre": "Javier Molina", "edad": 32, "ciudad": "Barranquilla", "departamento": "IT", "activo": true },
  { "id": 9, "nombre": "Sofia Castro", "edad": 26, "ciudad": "Bogota", "departamento": "Recursos Humanos", "activo": true },
  { "id": 10, "nombre": "Andres Peña", "edad": 38, "ciudad": "Cali", "departamento": "IT", "activo": false },
  { "id": 11, "nombre": "Carlos Castro", "edad": 20, "ciudad": "Bogota", "departamento": "Recursos Humanos", "activo": true },
  { "id": 12, "nombre": "Lorena Ruiz", "edad": 26, "ciudad": "Bogota", "departamento": "IT", "activo": true }
]
```

