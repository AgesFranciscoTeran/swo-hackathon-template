package com.ejemplo.catalogo.model;

import java.math.BigDecimal;
import java.util.List;

/**
 * Modelo de dominio para productos. 
 * Representa los datos internos del producto en el sistema.
 */
public class Producto {
    private Long id;
    private String nombre;
    private Categoria categoria;
    private BigDecimal precio;
    private boolean disponible;
    private List<String> tags;

    public Producto(Long id, String nombre, Categoria categoria, BigDecimal precio, boolean disponible, List<String> tags) {
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
    public Categoria getCategoria() { return categoria; }
    public BigDecimal getPrecio() { return precio; }
    public boolean isDisponible() { return disponible; }
    public List<String> getTags() { return tags; }
}
