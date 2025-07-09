package com.ejemplo.catalogo.dto;


import java.math.BigDecimal;
import java.util.List;

/**
 * DTO de respuesta para la consulta de productos.
 * Representa cómo se muestra un producto al cliente externo.
 */
public class ProductoResponse {
    private Long id;
    private String nombre;
    private String categoria; // Nombre legible de la categoría
    private BigDecimal precio;
    private boolean disponible;
    private List<String> tags;

    public ProductoResponse(Long id, String nombre, String categoria, BigDecimal precio, boolean disponible, List<String> tags) {
        this.id = id;
        this.nombre = nombre;
        this.categoria = categoria;
        this.precio = precio;
        this.disponible = disponible;
        this.tags = tags;
    }

    // Getters
    public Long getId() { return id; }
    public String getNombre() { return nombre; }
    public String getCategoria() { return categoria; }
    public BigDecimal getPrecio() { return precio; }
    public boolean isDisponible() { return disponible; }
    public List<String> getTags() { return tags; }
}
