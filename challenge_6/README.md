# Reto 6: Validador de Fechas

## Descripción
Recibirás una función en Java que valida fechas ingresadas como texto, admitiendo múltiples formatos y un rango específico de años. Tu objetivo es crear un archivo de pruebas unitarias que cubra distintos escenarios: formatos válidos e inválidos, fechas fuera de rango, nulas, vacías, años bisiestos, etc.

## Prerrequisitos
- [Java v21](https://www.oracle.com/co/java/technologies/downloads/)
- [maven](https://maven.apache.org/install.html)
- JUnit 5 para pruebas unitarias.
- Sistema operativo: Windows, macOS o Linux.

## Estructura del proyecto
```
swo-hackaton-challenge-6/
├── src/
│   ├── main/java/com/swo/validador/ValidadorFecha.java   # Archivo entregado, no modificar
│   └── test/java/com/swo/validador/                     # Aquí debes crear tu archivo de pruebas
├── pom.xml
├── README.md
└── ...
```

> **Nota:** El archivo `ValidadorFechaTest.java` no está incluido por defecto. Debes crearlo tú mismo en la ruta indicada (`src/test/java/com/swo/validador/ValidadorFechaTest.java`) para implementar las pruebas unitarias solicitadas.

## Criterios de aceptación funcionales
- El archivo de pruebas debe llamarse `ValidadorFechaTest.java` y estar en `src/test/java/com/swo/validador/`.
- Debes implementar al menos ocho pruebas unitarias usando JUnit 5, cubriendo los siguientes escenarios:

### Casos de prueba sugeridos
| Escenario | Descripción |
|-----------|-------------|
| Formato válido (yyyy-MM-dd) | Validar una fecha como "2024-06-30" debe ser aceptada. |
| Formato válido (dd/MM/yyyy) | Validar una fecha como "30/06/2024" debe ser aceptada. |
| Fecha fuera de rango | Fechas como "1999-12-31" (fuera del rango permitido) deben ser rechazadas. |
| Formato inválido | Fechas como "31.12.2024" deben ser rechazadas. |
| Entrada nula o vacía | null o "" debe ser rechazado. |
| Año bisiesto válido | "29/02/2024" debe ser aceptado. |
| Fecha inválida en año no bisiesto | "29/02/2023" debe ser rechazada. |
| Todas las pruebas ejecutan correctamente | Validar que todas las pruebas se ejecuten y reporten correctamente con Maven. |

- Puedes agregar otros casos que consideres relevantes para asegurar la robustez de la validación.
- Todas las pruebas deben ejecutarse correctamente con Maven.

### Criterios de aceptación técnicos
- El archivo `ValidadorFechaTest.java` debe ser creado por el usuario y contener todas las pruebas unitarias solicitadas.
- El código fuente debe compilar sin errores y cumplir todos los criterios funcionales y técnicos.
- No modifiques el archivo `ValidadorFecha.java`.

### Ejemplo de ejecución
En la terminal, dentro de la carpeta del proyecto, ejecuta:
```
mvn test
```
La salida debe mostrar que todas las pruebas pasan correctamente o indicar los errores encontrados.

## Instrucciones de implementación del ejercicio
1. Clona el repositorio base del hackathon:
   ```
   git clone <URL_DEL_REPOSITORIO>
   cd swo-hackaton-challenge-6
   ```
2. Verifica que tienes el archivo `ValidadorFecha.java` en:
   ```
   src/main/java/com/swo/validador/ValidadorFecha.java
   ```
3. Crea el archivo de pruebas unitarias en:
   ```
   src/test/java/com/swo/validador/ValidadorFechaTest.java
   ```
4. Implementa al menos ocho pruebas unitarias usando JUnit 5, cubriendo los escenarios solicitados.
5. Ejecuta las pruebas localmente para validar que todo funcione:
   ```
   mvn test
   ```
6. Realiza commit de tus cambios:
   ```
   git add src/test/java/com/swo/validador/ValidadorFechaTest.java
   git commit -m "Agrega pruebas unitarias para ValidadorFecha"
   git push
   ```
7. Sube tu solución según las instrucciones del hackathon.

## Observaciones
- El archivo `ValidadorFechaTest.java` debe ser creado por el usuario y contener todas las pruebas unitarias solicitadas.
- No modifiques el archivo `ValidadorFecha.java`.
- El código fuente debe compilar y todas las pruebas deben ejecutarse correctamente.
- Valida que la lógica de validación se comporte de forma consistente frente a distintas condiciones de entrada.

## Recursos útiles
- [Documentación oficial de JUnit 5](https://junit.org/junit5/)
