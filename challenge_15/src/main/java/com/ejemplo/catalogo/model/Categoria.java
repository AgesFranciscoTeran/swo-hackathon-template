
package com.ejemplo.catalogo.model;
/**
 * Modelo de dominio para la categoría de un producto.
 */
public class Categoria {
    private Long id;
    private String nombre;

    public Categoria(Long id, String nombre) {
        this.id = id;
        this.nombre = nombre;
    }

    // Getters
    public Long getId() { return id; }
    public String getNombre() { return nombre; }
}
