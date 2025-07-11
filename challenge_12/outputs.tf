// outputs.tf
// Define outputs relevantes: endpoints, nombres de recursos, cadenas de conexión (referenciadas desde Key Vault)
// Ejemplo:
// output "app_service_url" {
//   description = "URL del App Service"
//   value       = azurerm_app_service.example.default_site_hostname
// }

output "resource_group_name" {
  description = "Nombre del Resource Group creado."
  value       = azurerm_resource_group.main.name
}

output "acr_login_server" {
  description = "URL del Azure Container Registry."
  value       = azurerm_container_registry.acr.login_server
}

output "app_service_url" {
  description = "URL pública del App Service."
  value       = azurerm_app_service.app.default_site_hostname
}

output "sql_server_name" {
  description = "Nombre del servidor lógico de Azure SQL."
  value       = azurerm_sql_server.sql.name
}

output "sql_database_name" {
  description = "Nombre de la base de datos principal en Azure SQL."
  value       = azurerm_sql_database.db.name
}

output "key_vault_uri" {
  description = "URI del Azure Key Vault."
  value       = azurerm_key_vault.kv.vault_uri
}

output "storage_account_name" {
  description = "Nombre del Storage Account para Blob Storage."
  value       = azurerm_storage_account.blob.name
}

output "storage_container_name" {
  description = "Nombre del contenedor de Blob Storage."
  value       = azurerm_storage_container.container.name
}

output "application_gateway_ip" {
  description = "IP pública del Application Gateway."
  value       = azurerm_public_ip.gateway_ip.ip_address
}

output "monitor_workspace_id" {
  description = "ID del Log Analytics Workspace para Azure Monitor."
  value       = azurerm_log_analytics_workspace.monitor.id
}

output "sql_connection_string_secret_id" {
  description = "ID del secreto de la cadena de conexión SQL en Key Vault."
  value       = azurerm_key_vault_secret.sql_connection.id
}
