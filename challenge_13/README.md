# Reto 13: Automatización CI Azure DevOps

## Descripción

El equipo de innovación tecnológica de un banco del sector financiero está desarrollando una serie de aplicaciones prototipo que simulan escenarios reales del negocio, con el fin de entrenar modelos internos, validar lógicas de negocio y experimentar con prácticas modernas de DevOps.

Uno de estos prototipos es una aplicación de consola en .NET 8 llamada BankAccountApp, que permite realizar operaciones básicas de una cuenta bancaria, tales como:

- Consultar el saldo

- Realizar depósitos y retiros

- Visualizar el historial de transacciones

Aunque se trata de un entorno de desarrollo, el área de arquitectura del banco ha solicitado implementar automatización de CI para garantizar que todo nuevo cambio en el código:

- Se compile correctamente

- Ejecute pruebas unitarias

- Pase análisis estático de calidad

- Genere artefactos publicables

## Prerrequisitos
- Sistema operativo: Windows, macOS o Linux.
- .NET 8 SDK
- Azure Pipelines (estructura YAML)

## Estructura del proyecto
```
├── BankAccountApp/               
│   ├── Program.cs                
│   ├── Models/
│   │   └── Transaction.cs        
│   └── Services/
│       └── BankAccount.cs        
│
├── BankAccountApp.Tests/         
│   └── BankAccountTests.cs       
│
├── azure-pipelines.yml           
```
## Criterios de aceptación

- El pipeline debe estar definido en un archivo YAML llamado `azure-pipelines.yml` en la raíz del proyecto.

- El archivo `.yml` debe usar una imagen de agente hospedada de Microsoft (`ubuntu-latest`, `windows-latest`, etc.).

- Definir correctamente las tareas en etapas secuenciales: restore → build → test → análisis → publish.

- Debe ejecutar la restauración de paquetes, compilación de la solución, pruebas unitarias y publicación de la aplicación.

- Publicar los artefactos en la sección de artefactos del pipeline.

- El pipeline debe generar un artefacto llamado `drop` con los binarios publicados.

- Si ocurre un error en cualquiera de las etapas, el pipeline debe detenerse y mostrar un mensaje de error.

## Instrucciones de implementación del ejercicio

1. Si ya tienes el repositorio base, omite los pasos 2 y 3. Si no, clona el repositorio:
https://github.com/SoftwareOne-Hackaton-Demo/swo-hackathon-template.git

2. Clona el repositorio asignado para tu equipo.

3. Copia el contenido del repositorio https://github.com/SoftwareOne-Hackaton-Demo/swo-hackathon-template al repositorio asignado a tu equipo.

4. Implementa la solución siguiendo la estructura y requisitos descritos anteriormente.

5. Sube los archivos de validación y la estructura del proyecto al repositorio de tu equipo.

## Observaciones

- No es necesario que ejecutes el pipeline. Solo debes entregar un archivo `azure-pipelines.yml` bien estructurado.

- El uso de buenas prácticas en la redacción del YAML (nombres claros, orden lógico, comentarios) será valorado positivamente.

- La solución debe mantenerse simple y enfocada. No agregues lógica adicional que no esté especificada en el reto.

## Recursos Útiles

- [Documentación oficial de Azure Pipelines YAML](https://docs.microsoft.com/en-us/azure/devops/pipelines/yaml-schema)
- [Ejemplo de pipeline para .NET en Azure DevOps](https://docs.microsoft.com/en-us/azure/devops/pipelines/languages/dotnet-core)
- [Publicar artefactos en Azure Pipelines](https://docs.microsoft.com/en-us/azure/devops/pipelines/artifacts/pipeline-artifacts)
