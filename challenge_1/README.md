
# Reto 1: Generación de Contraseñas Seguras

## Descripción

Debes crear una aplicación sencilla en Python que genere contraseñas seguras de manera automática. La contraseña debe cumplir con los siguientes criterios de seguridad:
- Al menos una letra mayúscula (A-Z)
- Al menos una letra minúscula (a-z)
- Al menos un dígito (0-9)
- Al menos un carácter especial (!@#$%^&*)
- Longitud mínima requerida: 8 caracteres

El objetivo es practicar la generación de contraseñas seguras y la validación de argumentos desde la línea de comandos.

## Prerrequisitos

- [Python v3.13](https://wiki.python.org/moin/BeginnersGuide/Download)
- Sistema operativo: Windows, macOS o Linux

## Estructura del Proyecto

```
challenge_1/
├── password_generator.py
└── ...
```

## Criterios de aceptación

1. El programa debe solicitar la longitud de la contraseña como argumento desde la línea de comandos.
2. Si no se proporciona la longitud o no es un número entero, debe mostrar el mensaje:
   - `Error: Se debe enviar el campo longitud y este debe ser de tipo entero`
3. Si la longitud es menor a 8, debe mostrar el mensaje:
   - `Error: La longitud mínima para generar la contraseña debe ser de 8`
4. La contraseña generada debe contener al menos:
   - Una letra mayúscula (A-Z)
   - Una letra minúscula (a-z)
   - Un dígito (0-9)
   - Un carácter especial de la lista: `!@#$%^&*`
5. El programa debe imprimir la contraseña generada con el mensaje:
   - `La contraseña generada es: <CONTRASEÑA GENERADA>`
6. Si ocurre cualquier otro error, debe mostrar un mensaje con el formato:
   - `Error: Detalle del error`
7. El código debe estar en un archivo llamado `password_generator.py` en la raíz de la carpeta `challenge_1`.

### Criterios de Aceptación Técnicos:
- El programa debe estar implementado en Python.
- El código fuente debe estar en el repositorio GitHub suministrado en una carpeta con nombre _challenge_1_.
- El archivo principal debe llamarse `password_generator.py` y estar en la raíz de la carpeta.
- La ejecución del programa debe permitir pasar el parámetro de longitud directamente desde la línea de comandos.
- El código fuente debe ejecutarse correctamente y cumplir todos los criterios de aceptación funcionales.

### Ejemplo de Ejecución

Ejecuta el programa desde la terminal, dentro de la carpeta del proyecto:

```sh
python password_generator.py 12
```

Puedes probar con diferentes longitudes:

```sh
python password_generator.py 8
python password_generator.py 12
python password_generator.py 16
python password_generator.py 20
```

## Instrucciones de implementación del ejercicio

1. Omite los pasos 1 a 3 si ya los ejecutaste. De lo contrario, clona el repositorio:
   https://github.com/SoftwareOne-Hackathon-Demo/swo-hackathon-template.git
2. Clona el repositorio asignado para tu equipo.
3. Copia y pega el contenido del repositorio https://github.com/SoftwareOne-Hackaton-Demo/swo-hackathon-template al repositorio asignado a tu equipo.
4. En la carpeta correspondiente al reto, crea un archivo llamado `password_generator.py` en la carpeta `challenge_1`.
5. Implementa la lógica para recibir la longitud desde la línea de comandos y generar la contraseña cumpliendo los criterios funcionales.
6. Una vez finalizado, guarda los cambios y realiza commit y push de tu solución.
7. Finalmente, en el aplicativo de hackathon, envía el ejercicio correspondiente a challenge 1 para su revisión.

## Notas importantes
- El script debe ejecutarse con Python 3.13 o superior.
- El parámetro de longitud debe pasarse siempre como argumento al ejecutar el script.
- No es necesario un archivo `.env` ni configuración adicional.
- Si no se proporciona el argumento de longitud, el script mostrará un error y terminará.

## Observaciones
- Se debe validar que la longitud no se encuentre vacía y cumpla con los criterios, pues el equipo que presente el ejercicio debe realizar sus correspondientes pruebas.

### Recurso útil
- [Documentación oficial de Python](https://docs.python.org/3/)