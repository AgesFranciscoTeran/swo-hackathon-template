# Reto 5: Calculadora Básica

## Descripción
Recibirás una calculadora científica en Python que ya implementa operaciones matemáticas básicas y avanzadas (suma, resta, multiplicación, división, potencia, raíz cuadrada, módulo y promedio).

Tu objetivo es crear un archivo de pruebas unitarias para validar el correcto funcionamiento de cada operación, incluyendo casos extremos y entradas inválidas.

## Prerrequisitos
- [Python v3.13](https://wiki.python.org/moin/BeginnersGuide/Download).
- Sistema operativo: Windows, macOS o Linux.

## Estructura del proyecto
```
calculadora.py
test_calculadora.py
README.md
```

## Criterios de aceptación
- El archivo de pruebas debe llamarse **test_calculadora.py** y estar en la raíz de la carpeta `challenge_5`.
- Debes implementar pruebas unitarias para todas las funciones de la calculadora, cubriendo:
  - Operaciones con enteros, decimales y números negativos.
  - Manejo de errores como división entre cero o raíz cuadrada de números negativos.
  - Promedio de listas vacías.
- Las pruebas deben ejecutarse correctamente usando el módulo `unittest` de Python.

### Pruebas mínimas requeridas
- `test_sumar_positivos`: prueba la función sumar con dos números positivos.
- `test_potencia_positiva`: prueba la función potencia con base y exponente positivos.
- `test_promedio_lista`: prueba la función promedio con una lista de números.
- `test_dividir_por_cero`: prueba que dividir por cero lanza ValueError.
- `test_raiz_cuadrada_negativo`: prueba que la raíz cuadrada de un número negativo lanza ValueError.
- `test_promedio_lista_vacia`: prueba que el promedio de una lista vacía lanza ValueError.
- `test_modulo_borde`: prueba la función módulo con divisor 1.
- `test_multiplicar_decimales`: prueba la función multiplicar con decimales.
- `test_potencia_decimal_negativo`: prueba la función potencia con base negativa y exponente par.

### Criterios de aceptación técnicos
- El archivo `test_calculadora.py` debe ser creado por el usuario y contener todas las pruebas unitarias solicitadas.
- El código fuente debe ejecutarse correctamente y cumplir todos los criterios funcionales y técnicos.
- Se debe validar que las funciones manejen correctamente los errores y casos extremos.

### Ejemplo de ejecución

En la terminal, dentro de la carpeta del proyecto, ejecuta:
```
python -m unittest test_calculadora.py
```
La salida debe mostrar que todas las pruebas pasan correctamente o indicar los errores encontrados.

## Instrucciones de implementación del ejercicio
1. Omite los pasos 1 a 3 si ya los ejecutaste. De lo contrario, clona el repositorio:
   https://github.com/SoftwareOne-Hackaton-Demo/swo-hackathon-template.git
2. Clona el repositorio asignado para tu equipo.
3. Copia y pega el contenido del repositorio https://github.com/SoftwareOne-Hackaton-Demo/swo-hackathon-template al repositorio asignado a tu equipo.
4. Ingresa a la carpeta `challenge_5` del repositorio clonado.
5. Crea el archivo `test_calculadora.py` en la raíz del proyecto.
6. Implementa los tests unitarios solicitados.
7. Ejecuta las pruebas localmente para validar que todo funcione.
8. Realiza commit y push de tus cambios al repositorio.
9. Finalmente, en el aplicativo de hackathon, envía el ejercicio correspondiente a challenge 5 para su revisión.

## Observaciones
- Valida que las funciones manejen correctamente los errores y casos extremos.
- El archivo `test_calculadora.py` debe ser creado por el usuario y contener todas las pruebas unitarias solicitadas.
- **No modifiques el archivo `calculadora.py`.**

## Recursos útiles
- [Documentación oficial de unittest](https://docs.python.org/3/library/unittest.html)
