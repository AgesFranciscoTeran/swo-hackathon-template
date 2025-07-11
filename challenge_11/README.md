# Reto 11: Modernización de Extractor Bancario

## Descripción

En este reto trabajarás con una aplicación de consola desarrollada en C# sobre .NET Framework. Esta aplicación simula la generación de un extracto bancario mensual para un cliente, a partir de un archivo JSON con movimientos. La lógica actual está acoplada, carece de separación de responsabilidades, y utiliza patrones obsoletos, el objetivo es que debes modernizar este programa a .net framework manteniendo el output generado por .NET Framework haciendo uso del json entregado.



## Prerrequisitos

- **[.NET SDK 8.0](https://dotnet.microsoft.com/en-us/download/dotnet/8.0)** o superior
- **Sistema operativo**: Windows, macOS o Linux
- **Editor**: VS Code
- **Git** para control de versiones

## Estructura del Proyecto

```
challenge_11/
├── original/                    # Código .NET Framework original
│   ├── Movimiento.cs
│   ├── GeneradorExtracto.cs
│   ├── Program.cs
│   ├── movimientos.json
│   └── bin/
│       └── Debug/
│           ├── ConsoleApp1.exe
│           └── movimientos.json
├── modernizado/                 # Tu implementación .NET 8 (a crear)
├── src/
│   ├── main/java/com/swo/validador/ValidadorFecha.java   # Archivo entregado, no modificar
│   └── test/java/com/swo/validador/                     # Aqui debes crear tu archivo de pruebas
├── pom.xml
├── README.md                    # Este archivo
└── ...
```

> **Nota:** El archivo `ValidadorFechaTest.java` no esta incluido por defecto. Debes crearlo tu mismo en la ruta indicada (`src/test/java/com/swo/validador/ValidadorFechaTest.java`) para implementar las pruebas unitarias solicitadas.

## Criterios de Aceptación Funcionales

- La aplicación debe poder leer un archivo JSON con una lista de movimientos bancarios.

- Debe calcular el saldo final a partir de un saldo anterior fijo (ej: $1000).

- El resultado debe imprimirse en consola con detalle de cada movimiento y saldo acumulado.

- Se debe permitir cambiar el formato de salida implementando el patrón Strategy (por ejemplo: salida como texto plano o JSON).

### Criterios de Aceptación Técnicos
- El proyecto modernizado debe usar .NET 8.

- El punto de entrada debe ser un archivo Program.cs con uso de Main(string[] args).

- La lectura del archivo debe recibirse como argumento por línea de comandos.

- La estructura del proyecto debe estar en la carpeta challenge_11/Modernizado.

- Se deben aplicar buenas prácticas de arquitectura (separación de responsabilidades, inyección de dependencias si aplica).

- **El formato numérico de los montos y saldos debe ser en inglés (en-US): punto como separador decimal y coma como separador de miles, por ejemplo: $ 3,449.75**


## Ejecución del Proyecto Versión Original (.NET Framework)

Para probar la aplicación original sin recompilar:

```powershell
# Navegar a la carpeta del ejecutable
cd challenge_11/original/bin/Debug

# Ejecutar el programa
# En PowerShell:
.\ConsoleApp1.exe movimientos.json 1000

# En CMD:
ConsoleApp1.exe movimientos.json 1000
```

## Instrucciones de Implementación
1. Clona el repositorio base del reto:
   ```
   git clone <URL_DEL_REPOSITORIO>
   cd swo-hackaton-challenge_11
   ```
2. Valida que el programa este funcionando:
   ejecuta el programa como se menciona anteriormente

3. moderniza el ejercicio de extracto bancario a .Net core
  
4. prueba la ejecucion de tu programa modernizado
```bash
# Navegar a tu proyecto modernizado
cd challenge_11/modernizado

# Ejecutar con dotnet run
dotnet run -- movimientos.json 1000

```

5. Entrega
```bash
# Commit y push
git add .
git commit -m "feat: Modernización extracto bancario a .NET 8 con arquitectura SOLID"
git push origin main
```


## Recursos Útiles

### Documentación
- [**.NET 8 Documentation**](https://learn.microsoft.com/en-us/dotnet/core/) - Documentación oficial
- **[Principios SOLID en C#](https://medium.com/@cramirez92/principios-solid-en-c-1c5d9c2f180e)** - Guía práctica
- **[Dependency Injection en .NET](https://docs.microsoft.com/en-us/dotnet/core/extensions/dependency-injection)** - DI oficial

## Notas Importantes para los Participantes

- **Carpeta de destino:** El proyecto modernizado debe estar en la carpeta `challenge_11/modernizado`.
- **Formato de salida:** El programa debe imprimir el extracto bancario únicamente en formato texto plano por consola, no se requiere salida en JSON ni otros formatos.
- **Formato del archivo JSON:** El archivo `movimientos.json` debe mantener exactamente el mismo formato y estructura que el archivo original proporcionado. No modifiques la estructura ni los nombres de los campos.
- **Restaurar dependencias:** Si agregas paquetes o dependencias, recuerda ejecutar `dotnet restore` antes de compilar o ejecutar el proyecto.

## Ejemplo de salida esperada

```
=== Extracto Mensual ===
Saldo anterior: $ 1000.00
01/06/2025 | Pago nómina | $ 2,500.00 | Saldo: $ 3,500.00
02/06/2025 | Supermercado | -$ 320.50 | Saldo: $ 3,179.50
03/06/2025 | Restaurante | -$ 85.75 | Saldo: $ 3,093.75
... (más movimientos)
Saldo final: $ XXXX.XX
```





