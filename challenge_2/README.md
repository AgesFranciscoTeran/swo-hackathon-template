
# Reto 2: Analizador de Sentimientos


## Descripción

Debes crear una aplicación sencilla en Node.js que actúe como un "robot analizador de sentimientos". Esta aplicación debe recibir frases escritas por usuarios y, utilizando el modelo GPT-4.1 a través de la API de GitHub Models, determinar si la frase expresa un sentimiento positivo, negativo o neutral.

El objetivo es experimentar la integración de modelos de lenguaje avanzados dentro de una aplicación práctica, simulando cómo las empresas pueden automatizar el análisis de opiniones en redes sociales, encuestas o reseñas de productos.

## Prerrequisitos

- [Node.js v22](https://nodejs.org/en/download)
- [npm](https://docs.npmjs.com/downloading-and-installing-node-js-and-npm)
- Sistema operativo: Windows, macOS o Linux.
- PAT válida generada desde [GitHub Models](https://github.com/marketplace/models) con permisos "admin:public_key" los participantes haran uso de este PAT para probar el correcto funcionamiento del programa
- El modelo a utilizar es "openai/gpt-4.1".
- para el correcto funcionamiento del challenge debes hacer uso de @azure-rest/ai-inference que es un SDK oficial de Microsoft para Node.js que permite consumir servicios de inteligencia artificial (IA) de Azure y de GitHub Models usando una interfaz REST moderna y sencilla. usa (npm install @azure-rest/ai-inference @azure/core-auth node-fetch)

## Estructura del Proyecto

```
Sentimientos-Bot/

├── index.js
├── package.json
├── package-lock.json
├── node_modules    
└── ...
```

## Criterios de aceptación

1. La aplicación debe aceptar argumentos por línea de comandos:
   - GitHub Models: `<PAT> "mensaje"`                 (si se hace uso de github models solo se deben enviar dos parametros)
   - Azure OpenAI: `<API_KEY> "mensaje" <ENDPOINT>`   (si se hace uso de Azure OpenAI se deben utilizar 3 parametros)
2. Si falta algún argumento, debe mostrar el error correspondiente.
3. Si el token es inválido, debe mostrar:
   - `Error: No es posible consumir los servicios con el KEY suministrado.`
4. Si la petición es exitosa, debe mostrar:
   - `Sentimiento detectado: <positivo|negativo|neutral>`
5. El modelo utilizado debe ser "openai/gpt-4.1".
6. El código debe estar en `index.js` en la raíz de la carpeta.

### Criterios de Aceptación Técnicos
- El programa debe estar implementado en Node.js.
- El código fuente debe estar en el repositorio GitHub suministrado en una carpeta con nombre _challenge_2.
- El archivo principal debe llamarse `index.js` y estar en la raíz de la carpeta.
- La ejecución del programa debe permitir pasar el API KEY y el mensaje como argumentos desde la línea de comandos.
- El código fuente debe ejecutarse correctamente y cumplir todos los criterios de aceptación funcionales.

## Ejemplo de Ejecución

### GitHub Models (SDK, PAT con admin:public_key)
```sh
npm start -- ghp_xxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx "Hoy es un gran día"
```
- El primer argumento es el PAT clásico de GitHub con scope `admin:public_key`.
- El segundo argumento es el mensaje a analizar.
- El endpoint y modelo se configuran automáticamente en el script.

### Azure OpenAI (API key y endpoint)
```sh
npm start -- <APIKEY> "Hoy es un gran día" <Endpoint>
```
- El primer argumento es el API key de Azure OpenAI.
- El segundo argumento es el mensaje a analizar.
- El tercer argumento es el endpoint completo de tu deployment en Azure.

El programa debe aceptar los parámetros necesarios para funcionar tanto con Azure OpenAI como con GitHub Models. Sin embargo, para las pruebas internas de los equipos, únicamente se utilizará GitHub Models.

## Instrucciones de implementación del ejercicio

1. Omite los pasos 1 a 3 si ya los ejecutaste. De lo contrario, clona el repositorio:
   https://github.com/SoftwareOne-Hackaton-Demo/swo-hackathon-template.git
2. Clona el repositorio asignado para tu equipo.
3. Copia y pega el contenido del repositorio https://github.com/SoftwareOne-Hackaton-Demo/swo-hackathon-template al repositorio asignado a tu equipo.
4. En la carpeta correspondiente al reto, crea un archivo llamado `index.js` en la raíz del proyecto.
5. Instala los paquetes necesarios para implementar la aplicación.
6. Implementa la aplicación y asegúrate de cumplir con los criterios funcionales y técnicos descritos.
7. Una vez finalizado, guarda los cambios y realiza commit y push de tu solución.
8. Finalmente, en el aplicativo de hackathon, envía el ejercicio correspondiente a challenge 2 para su revisión.

## Notas importantes
- El Personal Access Token (PAT) **debe** ser generado desde [GitHub Models](https://github.com/marketplace/models) y tener permisos "admin:public_key".
- El API KEY se pasa siempre como primer argumento al ejecutar el script, seguido del mensaje a analizar.
- el programa debe permitir ingresar dos casos:
Envio de PAT con mensaje (haciendo uso de github models)
```
sh
npm start -- PAT "Tu mensaje aquí"
```
Envio de APIKEY con mensaje y endopoint (haciendo uso de azure openAI), 
- No es necesario el archivo `.env` para la API KEY, ya que ahora se recibe por argumento.
- Si no se proporcionan ambos argumentos, el script mostrará un error y terminará.

## Observaciones
- el programa debe realizar la validacion de los siguientes errores:
- Si falta el token:
  - `Error: No se ha detectado un API Key (PAT de GitHub con admin:public_key o API Key de Azure OpenAI).`
- Si falta el mensaje:
  - `Error: No se ha detectado un mensaje para procesar.`
- Si falta el endpoint en Azure:
  - `Error: No se ha detectado un endpoint para procesar.`
- Si el token es inválido:
  - `Error: No es posible consumir los servicios con el KEY suministrado.`.

## Recurso útil
- [GitHub Models Marketplace](https://github.com/marketplace/models) para la generación y gestión del API KEY.
- [SDK Azure AI Inference](https://www.npmjs.com/package/@azure-rest/ai-inference)