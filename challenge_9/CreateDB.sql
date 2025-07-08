-- CreditoVehicularDB: Modelo relacional para reto de optimización SQL

CREATE TABLE Clientes (
  id_cliente INT PRIMARY KEY,
  nombre VARCHAR(100),
  identificacion VARCHAR(20),
  fecha_nacimiento DATE,
  estado_civil VARCHAR(20),
  ingresos_mensuales DECIMAL(10,2),
  ciudad_residencia VARCHAR(50)
);

CREATE TABLE Asesores (
  id_asesor INT PRIMARY KEY,
  nombre VARCHAR(100),
  sucursal VARCHAR(50),
  correo VARCHAR(100)
);

CREATE TABLE Concesionarios (
  id_concesionario INT PRIMARY KEY,
  nombre VARCHAR(100),
  ciudad VARCHAR(50),
  telefono VARCHAR(20)
);

CREATE TABLE Vehiculos (
  id_vehiculo INT PRIMARY KEY,
  marca VARCHAR(50),
  modelo VARCHAR(50),
  anio INT,
  valor_comercial DECIMAL(12,2),
  id_concesionario INT,
  FOREIGN KEY (id_concesionario) REFERENCES Concesionarios(id_concesionario)
);

CREATE TABLE Solicitudes (
  id_solicitud INT PRIMARY KEY,
  id_cliente INT,
  fecha_solicitud DATE,
  monto_solicitado DECIMAL(12,2),
  plazo_meses INT,
  estado VARCHAR(20),
  id_vehiculo INT,
  id_asesor INT,
  FOREIGN KEY (id_cliente) REFERENCES Clientes(id_cliente),
  FOREIGN KEY (id_vehiculo) REFERENCES Vehiculos(id_vehiculo),
  FOREIGN KEY (id_asesor) REFERENCES Asesores(id_asesor)
);

CREATE TABLE EvaluacionesCredito (
  id_evaluacion INT PRIMARY KEY,
  id_solicitud INT,
  score_credito INT,
  resultado VARCHAR(20),
  observaciones TEXT,
  fecha_evaluacion DATE,
  FOREIGN KEY (id_solicitud) REFERENCES Solicitudes(id_solicitud)
);

CREATE TABLE Pagos (
  id_pago INT PRIMARY KEY,
  id_solicitud INT,
  fecha_pago DATE,
  monto_pago DECIMAL(10,2),
  numero_cuota INT,
  FOREIGN KEY (id_solicitud) REFERENCES Solicitudes(id_solicitud)
);

CREATE TABLE HistorialLaboral (
  id_historial INT PRIMARY KEY,
  id_cliente INT,
  empresa VARCHAR(100),
  cargo VARCHAR(50),
  salario DECIMAL(10,2),
  fecha_inicio DATE,
  fecha_fin DATE,
  FOREIGN KEY (id_cliente) REFERENCES Clientes(id_cliente)
);

CREATE TABLE ReferenciasPersonales (
  id_referencia INT PRIMARY KEY,
  id_cliente INT,
  nombre VARCHAR(100),
  relacion VARCHAR(50),
  telefono VARCHAR(20),
  FOREIGN KEY (id_cliente) REFERENCES Clientes(id_cliente)
);

CREATE TABLE ReportesBuroCredito (
  id_reporte INT PRIMARY KEY,
  id_cliente INT,
  score INT,
  estado_crediticio VARCHAR(50),
  fecha_reporte DATE,
  FOREIGN KEY (id_cliente) REFERENCES Clientes(id_cliente)
);
