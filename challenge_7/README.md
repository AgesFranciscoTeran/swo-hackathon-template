# Reto 7: Simulador de Interés

## Descripción
Una empresa del sector bancario ha implementado una solución para validar y calcular un aproximado del cálculo de tasas de interés para diferentes productos financieros. Sin embargo, buscan confirmar la robustez y exactitud de su lógica mediante la creación de pruebas unitarias que cubran distintos escenarios: tipos de producto válidos e inválidos, montos fuera de rango, tasas y plazos en cero, y combinaciones de parámetros. Tu objetivo es diseñar y ejecutar estas pruebas para asegurar la calidad del sistema.

## Prerrequisitos
- [Node.js v18+](https://nodejs.org/)
- [npm](https://www.npmjs.com/)
- Jest para pruebas unitarias.
- Sistema operativo: Windows, macOS o Linux.

## Criterios de aceptación funcionales
- Debes implementar al menos ocho pruebas unitarias usando Jest, cubriendo distintos escenarios que permitan validar la lógica, el manejo de errores y la robustez del sistema ante diferentes tipos de entrada.

### Criterios de aceptación técnicos
- El archivo `calculoInteresService.test.js` debe ser creado o completado por el usuario y contener todas las pruebas unitarias solicitadas. El archivo debe estar ubicado en la carpeta **`tests/`** dentro del proyecto, es decir: `tests/calculoInteresService.test.js`. No modifiques la estructura del proyecto ni cambies el nombre o ubicación del archivo de pruebas.
- Se debe garantizar que al ejecutar las pruebas genere el reporte de cobertura correspondiente.
- El código fuente debe ejecutarse sin errores (con npm run build) y cumplir todos los criterios funcionales y técnicos.
- No modifiques los archivos de lógica principal salvo para corregir errores o mejorar validaciones.

### Ejemplo de ejecución
En la terminal, dentro de la carpeta del proyecto, ejecuta:
```
npm test
```
La salida debe mostrar que todas las pruebas pasan correctamente o indicar los errores encontrados.

## Instrucciones de implementación del ejercicio
1. Omite los pasos 1 a 3 si ya los ejecutaste. De lo contrario, clona el repositorio:
   https://github.com/SoftwareOne-Hackaton-Demo/swo-hackathon-template.git
2. Clona el repositorio asignado para tu equipo.
3. Copia y pega el contenido del repositorio https://github.com/SoftwareOne-Hackaton-Demo/swo-hackathon-template al repositorio asigando a tu equipo.
4. En la carpeta correspondiente al reto, verifica que tienes el archivo `calculoInteresService.js` en:
   ```
   services/calculoInteresService.js
   ```
5. Crea la carpeta `tests/` en la raíz del proyecto si no existe.
6. Dentro de la carpeta `tests/`, crea el archivo de pruebas unitarias llamado:
   ```
   calculoInteresService.test.js
   ```
7. Implementa las pruebas unitarias garantizando un buen porcentaje de cobertura.
8. Ejecuta las pruebas localmente para validar que todo funcione.
9. Realiza commit y push de tus cambios.
10. Finalmente, en el aplicativo de hackaton, envía el ejercicio correspondiente a challenge 7 para su revisión.

## Observaciones
- El archivo `calculoInteresService.test.js` debe ser creado o completado por el usuario y contener todas las pruebas unitarias solicitadas.
- No modifiques los archivos de lógica principal salvo para corregir errores o mejorar validaciones.
- El código fuente debe ejecutarse y todas las pruebas deben pasar correctamente.
- Valida que la lógica de cálculo se comporte de forma consistente frente a distintas condiciones de entrada.

## Recursos útiles
- [Documentación oficial de Jest](https://jestjs.io/)
