// variables.tf
// Define variables tipadas y documentadas para la infraestructura
// Ejemplo:
// variable "resource_group_name" {
//   description = "Nombre del grupo de recursos principal"
//   type        = string
// }

variable "resource_group_name" {
  description = "Nombre del grupo de recursos principal para la solución bancaria."
  type        = string
}

variable "location" {
  description = "Región de Azure donde se desplegarán los recursos."
  type        = string
  default     = "eastus"
}

variable "acr_name" {
  description = "Nombre del Azure Container Registry (ACR) privado para almacenar la imagen del contenedor."
  type        = string
}

variable "acr_sku" {
  description = "SKU del Azure Container Registry (ACR). Ejemplo: 'Basic', 'Standard', 'Premium'."
  type        = string
  default     = "Standard"
}

variable "app_service_plan_name" {
  description = "Nombre del App Service Plan para la aplicación bancaria."
  type        = string
}

variable "app_service_plan_tier" {
  description = "Tier del App Service Plan (Ejemplo: 'PremiumV2', 'Standard')."
  type        = string
  default     = "PremiumV2"
}

variable "app_service_plan_size" {
  description = "Tamaño del App Service Plan (Ejemplo: 'P1v2', 'S1')."
  type        = string
  default     = "P1v2"
}

variable "app_service_name" {
  description = "Nombre del App Service para la aplicación bancaria."
  type        = string
}

variable "acr_image_name" {
  description = "Nombre de la imagen de contenedor en el ACR."
  type        = string
}

variable "acr_image_tag" {
  description = "Tag de la imagen de contenedor en el ACR."
  type        = string
  default     = "latest"
}

variable "sql_server_name" {
  description = "Nombre del servidor lógico de Azure SQL."
  type        = string
}

variable "sql_admin_login" {
  description = "Usuario administrador para el servidor SQL. Debe almacenarse en Key Vault en producción."
  type        = string
}

variable "sql_admin_password" {
  description = "Contraseña del usuario administrador SQL. Debe almacenarse en Key Vault en producción."
  type        = string
  sensitive   = true
}

variable "sql_database_name" {
  description = "Nombre de la base de datos principal en Azure SQL."
  type        = string
}

variable "sql_database_sku" {
  description = "SKU de la base de datos SQL (Ejemplo: 'S0', 'S1', 'P1')."
  type        = string
  default     = "S0"
}

variable "key_vault_name" {
  description = "Nombre del Azure Key Vault para gestionar secretos y credenciales."
  type        = string
}

variable "key_vault_sku" {
  description = "SKU del Key Vault (Ejemplo: 'standard', 'premium')."
  type        = string
  default     = "standard"
}

variable "tenant_id" {
  description = "Tenant ID de Azure Active Directory."
  type        = string
}

variable "admin_object_id" {
  description = "Object ID del usuario administrador para acceso a Key Vault."
  type        = string
}

variable "storage_account_name" {
  description = "Nombre del Storage Account para Blob Storage."
  type        = string
}

variable "storage_account_tier" {
  description = "Tier del Storage Account (Ejemplo: 'Standard', 'Premium')."
  type        = string
  default     = "Standard"
}

variable "storage_account_replication" {
  description = "Tipo de replicación del Storage Account (Ejemplo: 'LRS', 'GRS')."
  type        = string
  default     = "LRS"
}

variable "storage_container_name" {
  description = "Nombre del contenedor de Blob Storage."
  type        = string
}

variable "storage_container_access" {
  description = "Tipo de acceso del contenedor (Ejemplo: 'private', 'blob', 'container')."
  type        = string
  default     = "private"
}

variable "gateway_public_ip_name" {
  description = "Nombre del recurso Public IP para Application Gateway."
  type        = string
}

variable "gateway_name" {
  description = "Nombre del Application Gateway."
  type        = string
}

variable "gateway_sku_name" {
  description = "SKU Name del Application Gateway (Ejemplo: 'WAF_v2', 'Standard_v2')."
  type        = string
  default     = "Standard_v2"
}

variable "gateway_sku_tier" {
  description = "SKU Tier del Application Gateway (Ejemplo: 'Standard', 'WAF')."
  type        = string
  default     = "Standard"
}

variable "gateway_capacity" {
  description = "Capacidad (número de instancias) del Application Gateway."
  type        = number
  default     = 2
}

variable "gateway_subnet_id" {
  description = "ID de la subred donde se desplegará el Application Gateway."
  type        = string
}

variable "gateway_ssl_cert_name" {
  description = "Nombre del certificado SSL para Application Gateway."
  type        = string
}

variable "gateway_ssl_cert_data" {
  description = "Datos del certificado SSL en base64. Debe almacenarse en Key Vault en producción."
  type        = string
  sensitive   = true
}

variable "gateway_ssl_cert_password" {
  description = "Contraseña del certificado SSL. Debe almacenarse en Key Vault en producción."
  type        = string
  sensitive   = true
}

variable "monitor_workspace_name" {
  description = "Nombre del Log Analytics Workspace para Azure Monitor."
  type        = string
}

variable "monitor_workspace_sku" {
  description = "SKU del Log Analytics Workspace (Ejemplo: 'PerGB2018')."
  type        = string
  default     = "PerGB2018"
}

variable "monitor_retention_days" {
  description = "Días de retención de logs en Log Analytics Workspace."
  type        = number
  default     = 30
}

variable "acr_admin_password" {
  description = "Contraseña del administrador del Azure Container Registry (ACR). Debe almacenarse en Key Vault en producción."
  type        = string
  sensitive   = true
}

variable "aad_client_id" {
  description = "Client ID de la aplicación registrada en Azure AD para autenticación en App Service."
  type        = string
}

variable "aad_client_secret" {
  description = "Client Secret de la aplicación registrada en Azure AD. Debe almacenarse en Key Vault en producción."
  type        = string
  sensitive   = true
}

variable "aad_issuer_url" {
  description = "Issuer URL de Azure AD para autenticación en App Service."
  type        = string
}
