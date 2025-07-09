
package com.ejemplo.catalogo.controller;


import com.ejemplo.catalogo.dto.ProductoResponse;
import com.ejemplo.catalogo.model.Producto;
import com.ejemplo.catalogo.service.ProductoService;
import com.ejemplo.catalogo.util.JsonUtil;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;

import java.io.IOException;
import java.io.PrintWriter;
import java.math.BigDecimal;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Controlador para la gestión de consultas al catálogo de productos.
 * Recibe solicitudes HTTP en /api/productos y aplica filtros según los parámetros recibidos.
 */
@WebServlet(name = "ProductoController", urlPatterns = {"/api/productos"})
public class ProductoController extends HttpServlet {

    // Servicio que maneja la lógica de negocio relacionada a productos
    private ProductoService productoService;

    @Override
    public void init() {
        this.productoService = new ProductoService();
    }

    /**
     * Maneja solicitudes GET para consultar productos con filtros avanzados y paginación.
     *
     * Parámetros soportados por query string:
     * - nombre: filtra por nombre de producto
     * - categoriaId: filtra por ID de categoría
     * - disponible: filtra por disponibilidad (true/false)
     * - precioMin: filtra por precio mínimo
     * - precioMax: filtra por precio máximo
     * - tag: filtra por etiquetas
     * - page: número de página (paginación)
     * - size: tamaño de página (paginación)
     */
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {

        // Obtención segura de los parámetros de consulta
        String nombre = req.getParameter("nombre");
        Long categoriaId = parseLong(req.getParameter("categoriaId"));
        Boolean disponible = parseBoolean(req.getParameter("disponible"));
        BigDecimal precioMin = parseBigDecimal(req.getParameter("precioMin"));
        BigDecimal precioMax = parseBigDecimal(req.getParameter("precioMax"));
        String tag = req.getParameter("tag");
        int page = parseInt(req.getParameter("page"), 0);
        int size = parseInt(req.getParameter("size"), 10);

        // Llamada al servicio de negocio para obtener la lista filtrada
        List<Producto> encontrados = productoService.buscar(
            nombre, categoriaId, disponible, precioMin, precioMax, tag, page, size
        );

        // Mapeo de modelo a DTO de respuesta pública
        List<ProductoResponse> respuesta = encontrados.stream()
            .map(p -> new ProductoResponse(
                p.getId(),
                p.getNombre(),
                p.getCategoria().getNombre(),
                p.getPrecio(),
                p.isDisponible(),
                p.getTags()
            ))
            .collect(Collectors.toList());

        // Respuesta en formato JSON
        resp.setContentType("application/json");
        try (PrintWriter out = resp.getWriter()) {
            out.print(JsonUtil.productoListToJson(respuesta));
        }
    }

    // Métodos auxiliares privados para parseo seguro de parámetros
    private Long parseLong(String v) {
        try { return v == null ? null : Long.parseLong(v); } catch (Exception e) { return null; }
    }

    private Boolean parseBoolean(String v) {
        try { return v == null ? null : Boolean.parseBoolean(v); } catch (Exception e) { return null; }
    }

    private BigDecimal parseBigDecimal(String v) {
        try { return v == null ? null : new BigDecimal(v); } catch (Exception e) { return null; }
    }

    private int parseInt(String v, int def) {
        try { return v == null ? def : Integer.parseInt(v); } catch (Exception e) { return def; }
    }
}
