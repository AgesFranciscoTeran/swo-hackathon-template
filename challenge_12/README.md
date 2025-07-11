# Reto 12: Publicación servicios en Azure

## Descripción

El Banco **Financiera Ágil S.A.** busca modernizar el despliegue de su aplicación web bancaria utilizando infraestructura como código (Terraform) y mejores prácticas de seguridad y modularidad. Tu misión es definir la infraestructura necesaria para esta solución en Azure, **sin necesidad de desplegarla** realmente.

A continuación, podrás ver la arquitectura de despliegue diseñada para tal fin. Se espera que la aplicación debe estar diseñada para ejecutarse desde una imagen de contenedor almacenada en un **Azure Container Registry (ACR)** privado, y la solución debe garantizar la protección de credenciales y secretos.

![Arquitectura Banca](https://github.com/SoftwareOne-Hackaton-Demo/swo-hackathon-template/blob/main/challenge_12/docs/arquitectura_banca.png)

## Prerrequisitos
- Sistema operativo: Windows, macOS o Linux.
- [Terraform](https://www.terraform.io/downloads) instalado.
- [TFLint](https://github.com/terraform-linters/tflint) instalado.

## Estructura del proyecto
```
swo-hackaton-challenge-12/
├── main.tf
├── variables.tf
├── outputs.tf
├── providers.tf
├── terraform.tfvars
├── .tflint.hcl
├── README.md
├── docs/
│ └── arquitectura_banca.png
```

## Criterios de aceptación

 1. Tu código debe cubrir al menos los siguientes recursos de Azure:
    - Resource Group
    - Azure Container Registry (ACR)
    - App Service Plan
    - App Service (ejecutando imagen de contenedor desde ACR)
    - Azure SQL Database y servidor lógico
    - Azure Key Vault (gestionando cadenas de conexión y secretos)
    - Azure Blob Storage
    - Application Gateway
    - Azure Monitor
2. El App Service debe estar configurado para usar una imagen de ACR.
3. Todos los secretos y cadenas de conexión deben ir en Azure Key Vault.
4. Debe incluir recursos para monitoreo.
5. El acceso debe estar pensado para Application Gateway y autenticación con Azure AD.
6. Define outputs relevantes (endpoints, conexiones, etc.).

### Criterios de aceptación técnicos
- Toda la infraestructura debe estar definida con Terraform.
- El código debe pasar **TFLint** sin advertencias ni errores.
- Las variables y outputs deben estar tipados y documentados.
- El App Service debe estar autenticado contra el ACR privado en la definición del recurso.
- No debe haber secretos hardcodeados en los archivos.
- El proyecto debe tener un **README.md** y un diagrama de arquitectura en `/docs/`.


## Instrucciones de implementación del ejercicio

1. Omite los pasos 1 a 3 si ya los ejecutaste. De lo contrario, clona el repositorio:
   https://github.com/SoftwareOne-Hackaton-Demo/swo-hackathon-template.git
2. Clona el repositorio asignado para tu equipo.
3. Copia y pega el contenido del repositorio https://github.com/SoftwareOne-Hackaton-Demo/swo-hackathon-template al repositorio asigando a tu equipo.

## Ejemplo de validacion

```bash
# Inicializa el entorno de Terraform
terraform init

# Valida la sintaxis y la estructura del proyecto
terraform validate

# Muestra el plan de ejecución (simulado, no despliega nada)
terraform plan

# Ejecuta TFLint para verificar buenas prácticas
tflint

```

## Instrucciones de implementacion del proyecto 
1. Si ya tienes el repositorio base, omite los pasos 1 a 3. Si no, clona el repositorio:
https://github.com/SoftwareOne-Hackaton-Demo/swo-hackathon-template.git

2. Clona el repositorio asignado para tu equipo.

3. Copia y pega el contenido del repositorio https://github.com/SoftwareOne-Hackaton-Demo/swo-hackathon-template al repositorio asignado a tu equipo.

4. Implementa la solución siguiendo la estructura y requisitos descritos arriba.

5. Sube los archivos de validación y la estructura del proyecto al repositorio de tu equipo.

## Observaciones
- Nunca almacenes secretos ni contraseñas en texto plano ni subas archivos sensibles.

- Asegúrate de que las variables y outputs tengan tipo y descripción.

## Recursos útiles

- [Documentación Azure Provider para Terraform](https://registry.terraform.io/providers/hashicorp/azurerm/latest/docs)  
  Referencia oficial para todos los recursos de Azure soportados en Terraform.

- [Guía TFLint para Azure](https://github.com/terraform-linters/tflint-ruleset-azure)  
  Complemento y reglas para validar buenas prácticas en recursos Azure con TFLint.

- [Configuración de autenticación entre App Service y ACR](https://learn.microsoft.com/es-es/azure/app-service/containers/tutorial-custom-docker-image#configure-container-registry)  
  Cómo conectar tu App Service con Azure Container Registry privado.

- [Mejores prácticas Terraform](https://developer.hashicorp.com/terraform/tutorials/configuration-language/best-practices)  
  Recomendaciones oficiales para escribir código Terraform limpio, seguro y mantenible.

