-- Reporte de solicitudes por asesor y estado
SELECT 
  a.nombre, 
  s.estado,
  (SELECT COUNT(*) 
   FROM Solicitudes s2 
   WHERE s2.id_asesor = a.id_asesor AND s2.estado = s.estado) AS total
FROM Asesores a
JOIN Solicitudes s ON s.id_asesor = a.id_asesor
WHERE s.estado IS NOT NULL
ORDER BY a.nombre;


-- Clientes con solicitudes rechazadas en los últimos 12 meses
SELECT *
FROM Clientes
WHERE id_cliente IN (
  SELECT s.id_cliente
  FROM Solicitudes s
  WHERE DATEDIFF(DAY, s.fecha_solicitud, GETDATE()) < 365
    AND s.estado = 'Rechazado'
)


-- Detalle de pagos con JOINs innecesarios
SELECT 
  c.nombre, 
  p.fecha_pago, 
  p.monto_pago, 
  v.marca, 
  v.modelo,
  s.plazo_meses,
  a.nombre as nombre_asesor
FROM Pagos p
JOIN Solicitudes s ON p.id_solicitud = s.id_solicitud
JOIN Clientes c ON s.id_cliente = c.id_cliente
JOIN Vehiculos v ON s.id_vehiculo = v.id_vehiculo
JOIN Concesionarios cs ON v.id_concesionario = cs.id_concesionario
JOIN EvaluacionesCredito e ON s.id_solicitud = e.id_solicitud
JOIN Asesores a ON s.id_asesor = a.id_asesor
WHERE cs.ciudad LIKE '%'
ORDER BY c.nombre;


-- Score de crédito promedio por concesionario
SELECT 
  cs.nombre,
  (SELECT AVG(e.score_credito)
   FROM EvaluacionesCredito e
   JOIN Solicitudes s2 ON e.id_solicitud = s2.id_solicitud
   JOIN Vehiculos v2 ON s2.id_vehiculo = v2.id_vehiculo
   WHERE v2.id_concesionario = cs.id_concesionario) AS promedio_score
FROM Concesionarios cs;


-- Top 10 vehículos más financiados
SELECT TOP 10 *
FROM Vehiculos
WHERE id_vehiculo IN (
  SELECT id_vehiculo
  FROM Solicitudes
  WHERE estado = 'Aprobado'
  GROUP BY id_vehiculo
  ORDER BY COUNT(*) DESC
)
