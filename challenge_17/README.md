# Reto 17: Resolver Preguntas Código

## Descripción

El objetivo de este ejercicio es analizar el aplicativo open source disponible en [https://github.com/dotnet/eShop](https://github.com/dotnet/eShop) y responder a una serie de preguntas técnicas sobre su arquitectura, patrones y funcionamiento. Las preguntas están definidas a continuación y cubren temas como microservicios, comunicación, autenticación, testing, CI/CD, entre otros.

## Prerrequisitos
- Sistema operativo: Windows, macOS o Linux.

## Estructura del proyecto
```
swo-hackaton-challenge-17/
├── eShop/                # Carpeta donde se debe clonar el repositorio eShop
│   ├── src/
│   ├── tests/
│   └── ...
├── respuestas.txt        # Archivo con las respuestas a las preguntas
└── README.md             # Instrucciones y guía del reto
```

## Criterios de aceptación

- Analizar el repositorio eShop y responder cada pregunta de forma clara y concisa.
- Las respuestas deben entregarse en un archivo de texto plano (por ejemplo, `respuestas.txt`).

### Preguntas

1. ¿Cómo está estructurada la arquitectura de microservicios en eShop? - Explorar los servicios Catalog.API, Ordering.API, Basket.API y sus responsabilidades.
2. ¿Qué es .NET Aspire y cómo se utiliza en el proyecto? - Examinar eShop.AppHost/Program.cs para entender la orquestación de servicios.
3. ¿Cómo funciona la comunicación entre microservicios? - Analizar el uso de RabbitMQ y los integration events en IntegrationEventLogService.
4. ¿Qué patrones de diseño se implementan en la API de Ordering? - Revisar ValidatorBehavior y el patrón Mediator.
5. ¿Cómo se maneja la persistencia de datos en diferentes servicios? - Explorar Entity Framework en OrderQueries y las diferentes bases de datos.
6. ¿Cómo funciona la búsqueda semántica en el catálogo? - Examinar CatalogAI y GetItemsBySemanticRelevance.
7. ¿Qué estrategia de versionado de APIs se utiliza? - Analizar los endpoints v1 y v2 en CatalogApi.
8. ¿Cómo se implementa la autenticación y autorización? - Revisar Identity.API y los decoradores [Authorize].
9. ¿Cómo funciona el chatbot con IA? - Explorar Chatbot.razor y ChatState.
10. ¿Qué tecnologías se usan para el frontend? - Analizar Blazor en WebApp y HybridApp para MAUI.
11. ¿Cómo se configura el CI/CD del proyecto? - Examinar ci.yml y los scripts de build.
12. ¿Cómo se maneja la containerización? - Revisar los Dockerfiles y la configuración de contenedores en eShop.AppHost.
13. ¿Qué estrategia de testing se implementa? - Analizar CatalogApiTests y los tests funcionales.
14. ¿Cómo se configura el monitoreo y observabilidad? - Explorar la integración con OpenTelemetry y logging.
15. ¿Cómo se integra OpenAI en el proyecto? - Revisar AddOpenAI y la configuración de IA.
16. ¿Cómo se manejan las migraciones de base de datos? - Examinar MigrateDbContextExtensions.
17. ¿Qué estrategia se usa para el manejo de errores y validación? - Analizar LinqSelectExtensions y los behaviors de validación.
18. ¿Cómo funciona el sistema de webhooks? - Explorar WebHooksApi y WebhookClient.
19. ¿Cómo se implementa la funcionalidad de carrito de compras? - Revisar la integración entre servicios y el manejo de estado.
20. ¿Cómo se maneja la búsqueda y filtrado de productos? - Analizar CatalogSearch.razor y los endpoints de filtrado en CatalogApi.

### Ejemplo de formato de respuesta

El archivo de respuestas debe tener el siguiente formato:

```
1. [PREGUNTA] - [RESPUESTA GENERADA POR EL PARTICIPANTE]
2. [PREGUNTA] - [RESPUESTA GENERADA POR EL PARTICIPANTE]
...
```

## Instrucciones de implementación del ejercicio

- Clona el repositorio eShop en tu entorno local.
- Analiza el código y responde cada pregunta en el archivo de texto.
- Entrega el archivo `respuestas.txt` junto con tu solución.

## Observaciones

- Se recomienda justificar brevemente cada respuesta con referencias a archivos o fragmentos de código cuando sea posible.

## Recursos Útiles

- [Repositorio eShop en GitHub](https://github.com/dotnet/eShop)
- [Documentación oficial de eShop](https://github.com/dotnet/eShop/tree/main/docs)
- [Guía de patrones de arquitectura de microservicios](https://docs.microsoft.com/en-us/azure/architecture/microservices/)
- [Documentación de .NET Aspire](https://learn.microsoft.com/en-us/dotnet/aspire/)
