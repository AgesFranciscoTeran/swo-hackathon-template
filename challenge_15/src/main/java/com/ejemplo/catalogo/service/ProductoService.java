package com.ejemplo.catalogo.service;

import com.ejemplo.catalogo.model.Categoria;
import com.ejemplo.catalogo.model.Producto;

import java.math.BigDecimal;
import java.util.*;
import java.util.stream.Collectors;

/**
 * Servicio de productos: contiene la lógica de negocio para búsquedas y filtrados.
 * Actualmente usa una lista en memoria como fuente de datos simulada.
 */
public class ProductoService {
    private final List<Producto> productos;

    public ProductoService() {
        // Simulación de datos "persistentes"
        Categoria electronica = new Categoria(1L, "Electrónica");
        Categoria libros = new Categoria(2L, "Libros");

        productos = new ArrayList<>();
        productos.add(new Producto(1L, "Notebook Lenovo", electronica, new BigDecimal("1200.00"), true, Arrays.asList("computador", "portatil")));
        productos.add(new Producto(2L, "Libro Clean Code", libros, new BigDecimal("45.00"), true, Arrays.asList("programacion", "libro")));
        productos.add(new Producto(3L, "Monitor LG", electronica, new BigDecimal("300.00"), false, Arrays.asList("monitor", "pantalla")));
        // Puedes agregar más productos para pruebas.
    }

    /**
     * Busca productos aplicando los filtros recibidos.
     * Si un filtro es null, no se aplica.
     */
    public List<Producto> buscar(String nombre, Long categoriaId, Boolean disponible, BigDecimal precioMin, BigDecimal precioMax, String tag, int page, int size) {
        List<Producto> filtrados = productos.stream()
            .filter(p -> nombre == null || p.getNombre().toLowerCase().contains(nombre.toLowerCase()))
            .filter(p -> categoriaId == null || p.getCategoria().getId().equals(categoriaId))
            .filter(p -> disponible == null || p.isDisponible() == disponible)
            .filter(p -> precioMin == null || p.getPrecio().compareTo(precioMin) >= 0)
            .filter(p -> precioMax == null || p.getPrecio().compareTo(precioMax) <= 0)
            .filter(p -> tag == null || (p.getTags() != null && p.getTags().contains(tag)))
            .collect(Collectors.toList());

        // Paginación manual
        int from = Math.max(0, page * size);
        int to = Math.min(filtrados.size(), from + size);
        if (from > to) return Collections.emptyList();
        return filtrados.subList(from, to);
    }
}
