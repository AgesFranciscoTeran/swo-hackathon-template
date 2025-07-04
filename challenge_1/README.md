# hackaton-challenge-1

## Descripción

Esta aplicación genera contraseñas seguras de manera automática, cumpliendo con los siguientes criterios de seguridad:
- Al menos una letra mayúscula (A-Z)
- Al menos una letra minúscula (a-z)
- Al menos un dígito (0-9)
- Al menos un carácter especial (!@#$%^&*)
- **Longitud mínima requerida: 8 caracteres**

## Prerequisitos

- Python 3.13 o superior
- Sistema operativo: Windows, macOS, o Linux

## Estructura del Proyecto

```
swo-hackaton-challenge-1/
└── password_generator.py       # Archivo principal con la lógica del generador
```



### Criterios de aceptación funcionales

1. El programa debe solicitar la longitud de la contraseña como argumento desde la línea de comandos.
2. Si no se proporciona la longitud o no es un número entero, debe mostrar el mensaje:
   - `Error: Se debe enviar el campo longitud y este debe ser de tipo entero`
3. Si la longitud es menor a 8, debe mostrar el mensaje:
   - `Error: La longitud minima para generar la contrasena debe ser de 8`
4. La contraseña generada debe contener al menos:
   - Una letra mayúscula (A-Z)
   - Una letra minúscula (a-z)
   - Un dígito (0-9)
   - Un carácter especial de la lista: `!@#$%^&*`
5. El programa debe imprimir la contraseña generada con el mensaje:
   - `La contrasena generada es: <CONTRASEÑA GENERADA>`
6. Si ocurre cualquier otro error, debe mostrar un mensaje con el formato:
   - `Error: Detalle del error`
7. El programa debe ejecutarse correctamente desde la línea de comandos usando Python y aceptar el parámetro de longitud.
8. El código debe estar en un archivo llamado `password_generator.py` en la raíz de la carpeta `challenge_1`.

**Criterios de Aceptación Técnicos:** 
- El programa deberá ser implementado en Python.
- El código fuente debe estar en el repositorio GitHub suministrado en una carpeta con nombre _challenge_1_
- El programa desarrollado debe existir en un archivo llamado password_generator.py en la raíz de la carpeta.
- La ejecución del programa debe permitir pasar el parámetro de longitud directamente desde la línea de comandos (Ver sección "Ejemplo de Ejecución")
- El código fuente debe compilar satisfactoriamente.
- La aplicación ejecuta satisfactoriamente todos los criterios de aceptación funcionales.

### Ejempleo de Ejecución con Parámetro de Línea de Comandos
Ejecuta el programa pasando la longitud deseada como argumento (mínimo 8 caracteres):

```powershell
python password_generator.py 12
```

Ejemplos:
```powershell
# Generar una contraseña de 8 caracteres (mínimo)
python password_generator.py 8

# Generar una contraseña de 12 caracteres
python password_generator.py 12

# Generar una contraseña de 16 caracteres
python password_generator.py 16

# Generar una contraseña de 20 caracteres  
python password_generator.py 20
```



### Instrucciones de implementación del ejercicio

1. Crea un archivo llamado `password_generator.py`.
2. Importa los módulos necesarios: `random`, `string` y `sys`.
3. Define una función llamada `generar_contrasena` que reciba como argumento la longitud de la contraseña.
4. Dentro de la función, valida que la longitud sea al menos 8 caracteres.
5. Define los conjuntos de caracteres: mayúsculas, minúsculas, dígitos y caracteres especiales.
6. Asegúrate de incluir al menos un carácter de cada tipo en la contraseña.
7. Completa el resto de la contraseña con caracteres aleatorios de todos los conjuntos.
8. Mezcla los caracteres para que el orden sea aleatorio.
9. Une la lista de caracteres en un string final.
10. Imprime la contraseña generada y retorna el valor.
11. En el bloque principal (`if __name__ == "__main__":`), toma la longitud desde la línea de comandos y llama a la función.
12. Maneja posibles errores, como argumentos inválidos o longitud insuficiente, mostrando los siguientes mensajes según corresponda:
    - Si no se proporciona la longitud:
      - `Error: Se debe enviar el campo longitud y este debe ser de tipo entero` (Ver caso de prueba: Longitud no proporcionada)
    - Si la longitud no es un número entero (por ejemplo, texto o decimal):
      - `Error: Se debe enviar el campo longitud y este debe ser de tipo entero` (Ver casos de prueba: Longitud no es un número entero, Longitud es un número decimal)
    - Si la longitud es menor a 8 o es un número negativo:
      - `Error: La longitud minima para generar la contrasena debe ser de 8` (Ver casos de prueba: Longitud menor a 8, Longitud es un número negativo)
    - Si ocurre cualquier otro error:
      - `Error: Detalle del error`



# Casos de Prueba

| Caso de Prueba                                      | Comando de Ejemplo                      | Output Esperado                                                                                   |
|-----------------------------------------------------|-----------------------------------------|---------------------------------------------------------------------------------------------------|
| Longitud válida (12)                                | `python password_generator.py 12`       | La contrasena generada es: <contraseña de 12 caracteres, cumple todos los requisitos>             |
| Longitud menor a 8                                  | `python password_generator.py 5`        | Error: La longitud minima para generar la contrasena debe ser de 8                                |
| Longitud no proporcionada                           | `python password_generator.py`          | Error: Se debe enviar el campo longitud y este debe ser de tipo entero                            |
| Longitud no es un número entero                     | `python password_generator.py abc`      | Error: Se debe enviar el campo longitud y este debe ser de tipo entero                            |
| Longitud es un número decimal                       | `python password_generator.py 10.5`     | Error: Se debe enviar el campo longitud y este debe ser de tipo entero                            |
| Longitud es un número negativo                      | `python password_generator.py -10`      | Error: La longitud minima para generar la contrasena debe ser de 8                                |
| Contraseña cumple requisitos de composición         | `python password_generator.py 10`       | La contrasena generada es: <contraseña de 10 caracteres, incluye mayúscula, minúscula, dígito, especial> |
