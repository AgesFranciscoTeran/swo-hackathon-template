// main.tf
// Define los recursos principales de Azure para la solución bancaria
// Incluye: Resource Group, ACR, App Service Plan, App Service, SQL Server, SQL DB, Key Vault, Blob Storage, Application Gateway, Monitor
// Referencia variables y outputs

resource "azurerm_resource_group" "main" {
  name     = var.resource_group_name
  location = var.location
}

resource "azurerm_container_registry" "acr" {
  name                = var.acr_name
  resource_group_name = azurerm_resource_group.main.name
  location            = azurerm_resource_group.main.location
  sku                 = var.acr_sku
  admin_enabled       = false
}

resource "azurerm_app_service_plan" "plan" {
  name                = var.app_service_plan_name
  location            = azurerm_resource_group.main.location
  resource_group_name = azurerm_resource_group.main.name
  kind                = "Linux"
  reserved            = true
  sku {
    tier = var.app_service_plan_tier
    size = var.app_service_plan_size
  }
}

resource "azurerm_app_service" "app" {
  name                = var.app_service_name
  location            = azurerm_resource_group.main.location
  resource_group_name = azurerm_resource_group.main.name
  app_service_plan_id = azurerm_app_service_plan.plan.id

  site_config {
    linux_fx_version = "DOCKER|${azurerm_container_registry.acr.login_server}/${var.acr_image_name}:${var.acr_image_tag}"
    acr_use_managed_identity_creds = true
    acr_user_managed_identity_id   = azurerm_user_assigned_identity.acr_identity.id
  }

  identity {
    type = "UserAssigned"
    identity_ids = [azurerm_user_assigned_identity.acr_identity.id]
  }

  app_settings = {
    "DOCKER_REGISTRY_SERVER_URL"      = azurerm_container_registry.acr.login_server
    "DOCKER_REGISTRY_SERVER_USERNAME" = null
    "DOCKER_REGISTRY_SERVER_PASSWORD" = null
    "KEY_VAULT_URI"                   = azurerm_key_vault.kv.vault_uri
  }
}

resource "azurerm_sql_server" "sql" {
  name                         = var.sql_server_name
  resource_group_name          = azurerm_resource_group.main.name
  location                     = azurerm_resource_group.main.location
  version                      = "12.0"
  administrator_login          = var.sql_admin_login
  administrator_login_password = var.sql_admin_password
}

resource "azurerm_sql_database" "db" {
  name                = var.sql_database_name
  resource_group_name = azurerm_resource_group.main.name
  location            = azurerm_resource_group.main.location
  server_name         = azurerm_sql_server.sql.name
  sku_name            = var.sql_database_sku
}

resource "azurerm_key_vault" "kv" {
  name                        = var.key_vault_name
  location                    = azurerm_resource_group.main.location
  resource_group_name         = azurerm_resource_group.main.name
  tenant_id                   = var.tenant_id
  sku_name                    = var.key_vault_sku
  soft_delete_enabled         = true
  purge_protection_enabled    = true
  enabled_for_disk_encryption = true
  enabled_for_template_deployment = true
  access_policy {
    tenant_id = var.tenant_id
    object_id = var.admin_object_id
    secret_permissions = ["get", "list", "set", "delete"]
    key_permissions    = ["get", "list", "create", "delete"]
  }
}

resource "azurerm_storage_account" "blob" {
  name                     = var.storage_account_name
  resource_group_name      = azurerm_resource_group.main.name
  location                 = azurerm_resource_group.main.location
  account_tier             = var.storage_account_tier
  account_replication_type = var.storage_account_replication
  kind                     = "StorageV2"
  enable_https_traffic_only = true
}

resource "azurerm_storage_container" "container" {
  name                  = var.storage_container_name
  storage_account_name  = azurerm_storage_account.blob.name
  container_access_type = var.storage_container_access
}

resource "azurerm_public_ip" "gateway_ip" {
  name                = var.gateway_public_ip_name
  location            = azurerm_resource_group.main.location
  resource_group_name = azurerm_resource_group.main.name
  allocation_method   = "Static"
  sku                 = "Standard"
}

resource "azurerm_application_gateway" "gateway" {
  name                = var.gateway_name
  location            = azurerm_resource_group.main.location
  resource_group_name = azurerm_resource_group.main.name
  sku {
    name     = var.gateway_sku_name
    tier     = var.gateway_sku_tier
    capacity = var.gateway_capacity
  }
  gateway_ip_configuration {
    name      = "appGatewayIpConfig"
    subnet_id = var.gateway_subnet_id
  }
  frontend_port {
    name = "frontendPort"
    port = 443
  }
  frontend_ip_configuration {
    name                 = "frontendIpConfig"
    public_ip_address_id = azurerm_public_ip.gateway_ip.id
  }
  backend_address_pool {
    name  = "backendPool"
    fqdns = [azurerm_app_service.app.default_site_hostname]
  }
  backend_http_settings {
    name                  = "httpSettings"
    port                  = 443
    protocol              = "Https"
    cookie_based_affinity = "Disabled"
    pick_host_name_from_backend_address = true
  }
  http_listener {
    name                           = "httpsListener"
    frontend_ip_configuration_name = "frontendIpConfig"
    frontend_port_name             = "frontendPort"
    protocol                      = "Https"
    ssl_certificate_name           = var.gateway_ssl_cert_name
  }
  request_routing_rule {
    name                       = "rule1"
    rule_type                  = "Basic"
    http_listener_name         = "httpsListener"
    backend_address_pool_name  = "backendPool"
    backend_http_settings_name = "httpSettings"
  }
  ssl_certificate {
    name     = var.gateway_ssl_cert_name
    data     = var.gateway_ssl_cert_data
    password = var.gateway_ssl_cert_password
  }
}

resource "azurerm_log_analytics_workspace" "monitor" {
  name                = var.monitor_workspace_name
  location            = azurerm_resource_group.main.location
  resource_group_name = azurerm_resource_group.main.name
  sku                 = var.monitor_workspace_sku
  retention_in_days   = var.monitor_retention_days
}

resource "azurerm_monitor_diagnostic_setting" "app_diag" {
  name               = "appservice-diagnostics"
  target_resource_id = azurerm_app_service.app.id
  log_analytics_workspace_id = azurerm_log_analytics_workspace.monitor.id
  logs {
    category = "AppServiceHTTPLogs"
    enabled  = true
    retention_policy {
      enabled = false
    }
  }
  metrics {
    category = "AllMetrics"
    enabled  = true
    retention_policy {
      enabled = false
    }
  }
}

resource "azurerm_key_vault_secret" "sql_connection" {
  name         = "sql-connection-string"
  value        = "Server=${azurerm_sql_server.sql.fully_qualified_domain_name};Database=${azurerm_sql_database.db.name};User ID=${var.sql_admin_login};Password=${var.sql_admin_password};"
  key_vault_id = azurerm_key_vault.kv.id
}

resource "azurerm_key_vault_secret" "acr_password" {
  name         = "acr-password"
  value        = var.acr_admin_password
  key_vault_id = azurerm_key_vault.kv.id
}

resource "azurerm_key_vault_secret" "storage_account_key" {
  name         = "storage-account-key"
  value        = azurerm_storage_account.blob.primary_access_key
  key_vault_id = azurerm_key_vault.kv.id
}

resource "azurerm_key_vault_secret" "app_settings" {
  name         = "app-settings"
  value        = jsonencode({
    "SQL_CONNECTION_STRING" = azurerm_key_vault_secret.sql_connection.value
    "STORAGE_ACCOUNT_KEY"   = azurerm_key_vault_secret.storage_account_key.value
    "ACR_PASSWORD"          = azurerm_key_vault_secret.acr_password.value
  })
  key_vault_id = azurerm_key_vault.kv.id
}

resource "azurerm_app_service_active_directory" "aad_auth" {
  app_service_id = azurerm_app_service.app.id
  enabled        = true
  client_id      = var.aad_client_id
  client_secret  = var.aad_client_secret
  issuer        = var.aad_issuer_url
  allowed_audiences = [var.aad_client_id]
}
