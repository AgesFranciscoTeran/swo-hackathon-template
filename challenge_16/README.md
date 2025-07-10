# Reto 16: Corrección de errores Python

## Descripción
Este desafío consiste en identificar y corregir errores en un programa Python que procesa información de clientes bancarios, calcula intereses y evalúa el estado de los pagos.

## Prerrequisitos
- Sistema operativo: Windows, macOS o Linux.

## Estructura del proyecto
```
challenge_16/
├── clientes.json
├── ConErrores/
│   └── main.py
└── README.md
```

## Criterios de aceptación
- El programa debe ejecutarse sin errores
- Debe procesar correctamente todos los clientes del archivo JSON
- Debe calcular los intereses y estados de pago de forma precisa
- Debe mostrar los resultados en formato tabular

### Criterios de aceptación técnicos
- Manejo adecuado de excepciones
- Validación de formatos de fecha
- Cálculos matemáticos correctos
- Código limpio y bien estructurado

### Ejemplo de ejecución
```
Cliente         | Estado     | Pagado   | Interes   | Deuda Total  | Días
----------------------------------------------------------------------
Juan Perez      | SALDADO    | 9000.00  | 1234.56   | 11234.56     | 540
Ana Gomez       | EN MORA    | 1000.00  | 456.78    | 5456.78      | 245
Carlos Malo     | SIN PAGOS  | 0.00     | 2345.67   | 9345.67      | 398
```


## Instrucciones de implementación del ejercicio

1. Omite los pasos 1 a 3 si ya los ejecutaste. De lo contrario, clona el repositorio:
   https://github.com/SoftwareOne-Hackaton-Demo/swo-hackathon-template.git
2. Clona el repositorio asignado para tu equipo.
3. Copia y pega el contenido del repositorio https://github.com/SoftwareOne-Hackaton-Demo/swo-hackathon-template al repositorio asignado a tu equipo.
4. Navega al directorio `challenge_16/ConErrores/`
5. Ejecuta el programa Python para identificar los errores
6. Corrige los errores encontrados
7. Verifica que el programa funcione correctamente con todos los datos de prueba

## Observaciones
- El archivo `clientes.json` contiene datos de prueba con diferentes formatos de fecha
- Algunos clientes tienen pagos parciales, otros ningún pago
- El programa debe manejar correctamente todos los casos edge
- Presta atención a los formatos de fecha inconsistentes
- Verifica los cálculos de intereses y estados de pago

## Recursos Útiles
- [Documentación de datetime en Python](https://docs.python.org/3/library/datetime.html)
- [Manejo de JSON en Python](https://docs.python.org/3/library/json.html)
- [Manejo de excepciones en Python](https://docs.python.org/3/tutorial/errors.html)
