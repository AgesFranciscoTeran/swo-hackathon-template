# Reto 16: Corrección de errores Python

## Descripción
Este desafío consiste en identificar y corregir errores en un programa Python que procesa información de clientes bancarios, calcula intereses y evalúa el estado de los pagos.

## Prerrequisitos
- Sistema operativo: Windows, macOS o Linux.
- Python 3.8 o superior instalado.

## Estructura del proyecto
```
challenge_16/
├── clientes.json           # Archivo de entrada con los datos de los clientes
├── ConErrores/
│   └── main.py            # Versión original con errores
├── Corregido/
│   └── main.py            # Tu solución corregida y funcional
└── README.md              # Este archivo de instrucciones
```

## Instrucciones para la solución

1. La solución debe implementarse en el archivo `challenge_16/Corregido/main.py`.
2. El programa debe leer y procesar el archivo `clientes.json` ubicado en la raíz de `challenge_16`.
3. El programa debe ejecutarse sin errores y mostrar los resultados en formato tabular, como se indica en el ejemplo.
4. El código debe manejar adecuadamente excepciones, validar formatos de fecha y realizar cálculos matemáticos correctos.
5. El código debe estar limpio, bien estructurado y documentado.
6. Los valores monetarios deben mostrarse en formato inglés (punto decimal, sin separador de miles).
7. El programa debe capturar y mostrar errores por cada cliente procesado y errores generales si ocurren.

## Ejecución

Para ejecutar la solución, abre una terminal y ejecuta:

```sh
cd challenge_16/Corregido
python main.py
```

El programa debe leer automáticamente el archivo `../clientes.json` y mostrar la salida en pantalla.

## Criterios de aceptación

- El programa debe ejecutarse sin errores.
- Debe procesar correctamente todos los clientes del archivo JSON.
- Debe calcular los intereses y estados de pago de forma precisa.
- Debe mostrar los resultados en formato tabular, por ejemplo:

## Ejemplo output de ejecucion
```
Cliente         | Estado     | Pagado   | Interés   | Deuda Total  | Días
----------------------------------------------------------------------
Juan Perez     | EN MORA   |  9000.00 |  3731.51 |    13731.51 | 908
Ana Gomez      | EN MORA   |  1000.00 |   621.37 |     5621.37 | 252
Carlos Malo    | SIN PAGOS |     0.00 |  1774.36 |     8774.36 | 771
Monica Díaz    | ERROR      | Motivo: could not convert string to float: 'once mil'
Esteban Ríos   | EN MORA   |  6000.00 |  2715.40 |    10715.40 | 953
Laura Vargas   | EN MORA   |  2500.00 |   501.70 |     3501.70 | 436
Pedro Casas    | SIN PAGOS |     0.00 |  2441.64 |    12441.64 | 557
Angela Mora    | EN MORA   |  6000.00 |  3173.18 |    12173.18 | 757
Miguel Torres  | EN MORA   |  6000.00 |  4654.36 |    16654.36 | 1287
Sofía Leon     | EN MORA   |  4000.00 |   966.58 |     4966.58 | 588
Diego Ramírez  | EN MORA   |  1000.00 |  2526.03 |    12526.03 | 922
Tatiana Useche | EN MORA   |  4000.00 |   875.34 |     5875.34 | 710
Luis Herrera   | EN MORA   |  7500.00 |  3604.11 |    11104.11 | 877
Camila Suarez  | EN MORA   |  1500.00 |  6732.88 |    16732.88 | 983
Oscar Mejia    | ERROR      | Motivo: Formato de fecha inválido: fecha-incorrecta
Natalia Gomez  | EN MORA   |  1500.00 |   582.68 |     2582.68 | 818
Ricardo Gacha  | EN MORA   |  6000.00 |  2754.74 |    11754.74 | 798
Diana Salas    | EN MORA   | 10000.00 |  3379.73 |    13379.73 | 771
Mauricio Nino  | EN MORA   |  6000.00 |  1831.23 |     7831.23 | 557
Valeria Ortiz  | EN MORA   |  3000.00 |  1420.27 |     5920.27 | 640
```

- Los valores monetarios deben estar en formato inglés (punto decimal, sin separador de miles).
- Si ocurre un error al procesar un cliente, debe mostrarse un mensaje indicando el nombre del cliente y el error.
- Si ocurre un error general, debe mostrarse un mensaje descriptivo.

## Criterios de aceptación técnicos

- Manejo adecuado de excepciones.
- Validación de formatos de fecha.
- Cálculos matemáticos correctos.
- Código limpio y bien estructurado.

## Observaciones

- El archivo `clientes.json` contiene datos de prueba con diferentes formatos de fecha.
- Algunos clientes tienen pagos parciales, otros ningún pago.
- El programa debe manejar correctamente todos los casos edge.
- Presta atención a los formatos de fecha inconsistentes.
- Verifica los cálculos de intereses y estados de pago.
- Los valores monetarios deben mostrarse en formato inglés.
- Los errores deben ser capturados y reportados por cliente y generales.

## Recursos útiles

- [Documentación de datetime en Python](https://docs.python.org/3/library/datetime.html)
- [Manejo de JSON en Python](https://docs.python.org/3/library/json.html)
- [Manejo de excepciones en Python](https://docs.python.org/3/tutorial/errors.html)

## Nota importante sobre la fecha de referencia

Para asegurar resultados consistentes, el cálculo de días y de intereses se realiza usando la fecha fija **11/07/2025** como referencia (no la fecha actual del sistema). Todos los resultados y pruebas deben considerar esta fecha como “hoy”.
