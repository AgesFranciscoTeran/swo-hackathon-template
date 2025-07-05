
# Reto 2: Analizador de Sentimientos


## Descripción

Debes crear una aplicacion sencilla en Node.js y actúe como un "robot analizador de sentimientos". Esta aplicación debe recibir frases escritas por usuarios y, utilizando el modelo GPT-4.1 a través de la API de GitHub Models, determinar si la frase expresa un sentimiento positivo, negativo o neutral.

El objetivo es experimentar la integración de modelos de lenguaje avanzados dentro de una aplicación práctica, simulando cómo las empresas pueden automatizar el análisis de opiniones en redes sociales, encuestas o reseñas de productos.

## Prerequisitos

- Node.js y npm instalados en tu sistema.
- Sistema operativo: Windows, macOS o Linux.
- API KEY válida generada desde [GitHub Models](https://github.com/marketplace/models) con permisos "models:read" (no usar claves de OpenAI ni de otros proveedores).
- El modelo a utilizar es "openai/gpt-4.1".

## Estructura del Proyecto

```
Sentimientos-Bot/
├── index.js
├── package.json
└── ...
```

## Criterios de aceptación

1. La aplicación debe recibir el API KEY y el mensaje a analizar como argumentos desde la línea de comandos.
2. Si no se proporciona el API KEY, debe mostrar el mensaje:
   - `Error: No se ha detectado un API Key de conexión a GitHub Models.`
3. Si no se proporciona el mensaje a analizar, debe mostrar el mensaje:
   - `Error: No se ha detectado un mensaje para procesar.`
4. Si el API KEY es inválido, debe mostrar el mensaje:
   - `Error: No es posible consumir los servicios de GitHub Models con el KEY suministrado.`
5. Si la petición es exitosa, debe mostrar el mensaje:
   - `Sentimiento detectado: <positivo|negativo|neutral>`
6. El modelo utilizado debe ser "openai/gpt-4.1".
7. El código debe estar en un archivo llamado `index.js` en la raíz de la carpeta del proyecto.

### Criterios de Aceptación Técnicos
- El programa debe estar implementado en Node.js.
- El código fuente debe estar en el repositorio GitHub suministrado en una carpeta con nombre _challenge_2_.
- El archivo principal debe llamarse `index.js` y estar en la raíz de la carpeta.
- La ejecución del programa debe permitir pasar el API KEY y el mensaje como argumentos desde la línea de comandos.
- El código fuente debe ejecutarse correctamente y cumplir todos los criterios de aceptación funcionales.

### Ejemplo de Ejecución con Parámetro de Línea de Comandos

Ejecuta la aplicación desde la terminal, dentro de la carpeta del proyecto:

```sh
npm start -- TU_API_KEY "Tu mensaje aquí"
```

- Reemplaza `TU_API_KEY` por el key generado desde GitHub Models.
- Reemplaza `"Tu mensaje aquí"` por la frase que deseas analizar.

## Instrucciones de implementación del ejercicio

1. Clona la carpeta correspondiente a challenge_2 desde el repositorio:
   https://github.com/SoftwareOne-Hackaton-Demo/swo-hackathon-template/tree/main
2. Crea un archivo llamado `index.js` en la raíz del proyecto .
3. Instala los paquetes necesarios: `@azure-rest/ai-inference` y `@azure/core-auth` (se instalan con el comando: `npm install @azure-rest/ai-inference @azure/core-auth`).
4. Implementa la lógica para recibir el API KEY y el mensaje desde la línea de comandos.
5. Realiza la petición al modelo "openai/gpt-4.1" usando la API de GitHub Models y muestra el resultado o el mensaje de error correspondiente.
6. Asegúrate de cumplir con los criterios funcionales y técnicos descritos arriba.
7. Una vez finalizado, guarda los cambios y realiza commit y push de tu solución usando los siguientes comandos dentro de la carpeta `challenge_2`:
   ```sh
   git add index.js
   git commit -m "Solución challenge 2"
   git push
   ```
8. Finalmente, en el aplicativo de hackaton, envía el ejercicio correspondiente a challenge 2 para su revisión.

## Notas importantes
- El API KEY **debe** ser generado desde [GitHub Models](https://github.com/marketplace/models) y tener permisos "models:read".
- El API KEY se pasa siempre como primer argumento al ejecutar el script, seguido del mensaje a analizar.
- No es necesario el archivo `.env` para la API KEY, ya que ahora se recibe por argumento.
- Si no se proporcionan ambos argumentos, el script mostrará un error y terminará.

## Observaciones
- Se debe validar que el API KEY no se encuentre vacío, pues el equipo que presente el ejercicio debe realizar sus correspondientes pruebas.

## Recurso útil
- [GitHub Models Marketplace](https://github.com/marketplace/models) para la generación y gestión del API KEY.
